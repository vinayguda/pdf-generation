/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ivaylorusev.pdf.generation;

import java.io.IOException;
import java.io.StringWriter;
import java.nio.charset.StandardCharsets;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.FileOutputStream;

/**
 *
 * @author Ivaylo Rusev
 */
public class Xhtml2Fo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, TransformerException {
        StreamSource xslTemplate = new StreamSource(Xhtml2Fo.class.getResourceAsStream("/Xhtml2Fo/template_invoice_1.xsl"));
        writeToFile(convertXhtml2fo_ibm(xslTemplate), "sample_ibm.fo");
    }
    
    public static byte[] convertXhtml2fo_ibm(Source xhtmlSource) throws IOException, TransformerException {
        StreamSource xslTemplate = new StreamSource(Xhtml2Fo.class.getResourceAsStream("/Xhtml2Fo/xhtml2fo_ibm.xsl"));
        return convertXhtml2fo(xhtmlSource, xslTemplate);
    }
    
    public static byte[] convertXhtml2fo_antenna(Source xhtmlSource) throws IOException, TransformerException {
        StreamSource xslTemplate = new StreamSource(Xhtml2Fo.class.getResourceAsStream("/Xhtml2Fo/xhtml2fo_antenna.xsl"));
        return convertXhtml2fo(xhtmlSource, xslTemplate);
    }

    public static byte[] convertXhtml2fo(Source xhtmlSource, Source xslTemplate) throws IOException, TransformerException {
        StringWriter writer = new StringWriter();
        TransformerFactory tFactory = TransformerFactory.newInstance();
        Transformer transformer = tFactory.newTransformer(xslTemplate);
        transformer.transform(xhtmlSource, new StreamResult(writer));

        return writer.toString().getBytes(StandardCharsets.UTF_8);
    }

    public static void writeToFile(byte[] bytes, String fileName) {
        FileOutputStream fop = null;

        try {
            fop = new FileOutputStream("src/main/resources/Xhtml2Fo/"+fileName);

            fop.write(bytes);
            fop.flush();
            fop.close();

            System.out.println("Done");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fop != null) {
                    fop.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
