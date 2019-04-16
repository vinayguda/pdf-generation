/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivaylorusev.pdf.generation;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ivaylorusev.pdf.generation.model.OrderPosition;
import com.ivaylorusev.pdf.generation.model.PaymentRequest;
import com.ivaylorusev.pdf.generation.outputModel.RootPaymentRequest;
import com.ivaylorusev.pdf.generation.outputModel.MapPaymentRequest;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.sax.SAXResult;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import org.apache.fop.apps.FOPException;
import org.apache.fop.apps.FOUserAgent;
import org.apache.fop.apps.Fop;
import org.apache.fop.apps.FopFactory;
import org.apache.fop.apps.MimeConstants;

/**
 *
 * @author Ivaylo Rusev
 */
public class FOPPdfDemo {

    public static void main(String[] args) throws IOException, InterruptedException {

        ObjectMapper mapper = new ObjectMapper();
        InputStream is = FOPPdfDemo.class.getResourceAsStream("/inputPaymentRequest.json");
        PaymentRequest pr = mapper.readValue(is, PaymentRequest.class);

        Map<String, List<OrderPosition>> groupBySalesItemName
                = pr.getOrderPositions().stream().collect(Collectors.groupingBy(t -> t.getArticleLicense().getSalesItemName()));

        RootPaymentRequest rootPaymentRequest = new RootPaymentRequest();
        rootPaymentRequest.setOrderIdentifier(pr.getOrderIdentifier());
        rootPaymentRequest.setOrderDate(pr.getOrderDate());
        rootPaymentRequest.setInvoiceData(pr.getInvoiceData());
        rootPaymentRequest.setMapCustomerInformation(pr.getCustomerInformation());
        rootPaymentRequest.setMapPaymentRequest(new ArrayList());
        for (Map.Entry<String, List<OrderPosition>> entry : groupBySalesItemName.entrySet()) {
            String salesItemName = entry.getKey();
            List<OrderPosition> salesItems = entry.getValue();
            String salesItemNumber = salesItems.get(0).getArticleLicense().getSalesItemNumber();
            rootPaymentRequest.getMapPaymentRequest().add(new MapPaymentRequest(salesItemName, salesItemNumber, salesItems));
        }

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try {
            //create JAXB context
            JAXBContext context = JAXBContext.newInstance(RootPaymentRequest.class);
            //Create Marshaller using JAXB context
            Marshaller marshaller = context.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            //Do the marshal operation
            marshaller.marshal(rootPaymentRequest, bos);
            System.out.println("java object converted to xml successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }                

        FOPPdfDemo fOPPdfDemo = new FOPPdfDemo();
        StreamSource ss = convertToStreamSource(convertToInputStream(bos));
        try {
            fOPPdfDemo.convertToPDF(ss);
        } catch (FOPException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (TransformerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (URISyntaxException ex) {
            Logger.getLogger(FOPPdfDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Method that will convert the given XML to PDF
     *
     * @param xmlSource
     * @throws IOException
     * @throws FOPException
     * @throws TransformerException
     */
    public void convertToPDF(Source xmlSource) throws IOException, FOPException, TransformerException, URISyntaxException {
        // the XSL FO file
        URL url = FOPPdfDemo.class.getResource("/template_invoice.xsl");
        File xsltFile = new File(url.toURI().getPath());
        // create an instance of fop factory
        FopFactory fopFactory = FopFactory.newInstance(new File(".").toURI());
        // a user agent is needed for transformation
        FOUserAgent foUserAgent = fopFactory.newFOUserAgent();
        // Setup output
        OutputStream out;
        out = new java.io.FileOutputStream("src/main/resources/invoice.pdf");

        try {
            // Construct fop with desired output format
            Fop fop = fopFactory.newFop(MimeConstants.MIME_PDF, foUserAgent, out);

            // Setup XSLT
            TransformerFactory factory = TransformerFactory.newInstance();
            Transformer transformer = factory.newTransformer(new StreamSource(xsltFile));

            // Resulting SAX events (the generated FO) must be piped through to FOP
            Result res = new SAXResult(fop.getDefaultHandler());

            // Start XSLT transformation and FOP processing
            // That's where the XML is first transformed to XSL-FO and then 
            // PDF is created
            transformer.transform(xmlSource, res);
        } finally {
            out.close();
        }
    }

    private static InputStream convertToInputStream(ByteArrayOutputStream bos) throws IOException, InterruptedException {
        PipedInputStream in = new PipedInputStream();
        final PipedOutputStream out = new PipedOutputStream(in);
        new Thread(new Runnable() {
            public void run() {
                try {
                    // write the original OutputStream to the PipedOutputStream
                    bos.writeTo(out);
                } catch (IOException e) {
                    // logging and exception handling should go here
                }
            }
        }).start();
        Thread.sleep(1000);
        return in;
    }
    
    private static StreamSource convertToStreamSource(InputStream is) {
        return new StreamSource(is);
    }

}
