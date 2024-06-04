package com.example.antriannew.controller;
import com.example.antriannew.mainApp;

import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.stream.Collectors;


import javax.print.*;
import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.MediaSizeName;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.stream.Collectors;

public class printWithIText {
    public static void main(String[] args) {
        printPDFWithIText("001 S ADAFERDGHDFVBDFDFB");
    }

    public static void printPDFWithIText(String kode_antrian) {
        try {
//            // Create a PDF in memory
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            PdfWriter pdfWriter = new PdfWriter(baos);
//            PdfDocument pdfDocument = new PdfDocument(pdfWriter);
//            Document document = new Document(pdfDocument);
//            document.add(new Paragraph(kode_antrian));
//            document.close();

            // Get PDF as byte array
//            byte[] pdfBytes = baos.toByteArray();

//            for(byte b : pdfBytes){
//                System.out.println(b);
//            }

            // Print PDF
//            printPDF(pdfBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printPDF(byte[] pdfBytes) {
        try {
            // Convert byte array PDF to InputStream
            InputStream inputStream = new ByteArrayInputStream(pdfBytes);
            System.out.println(inputStream.readAllBytes().toString());



            // Prepare Print Service for printing PDF
            DocFlavor docFlavor = DocFlavor.INPUT_STREAM.POSTSCRIPT;
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            attributeSet.add(MediaSizeName.ISO_A4);
            PrintService[] printServices = PrintServiceLookup.lookupPrintServices(docFlavor, attributeSet);

            if (printServices.length == 0) {
                System.out.println("No print services found.");
                return;
            }

            // Choose the default printer if available
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            if (printService == null) {
                printService = printServices[0];
            }

            System.out.println("Printing to: " + printService.getName());

            DocPrintJob printJob = printService.createPrintJob();
            Doc doc = new SimpleDoc(inputStream, docFlavor, null);

            // Print document
            printJob.print(doc, attributeSet);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void printText(String kode_antrian) {
        try {
            // Convert the string to InputStream
            InputStream inputStream = new ByteArrayInputStream(kode_antrian.getBytes(StandardCharsets.UTF_8));
            System.out.println(inputStream.readAllBytes().toString());


            // Prepare Print Service for printing plain text
            DocFlavor docFlavor = DocFlavor.INPUT_STREAM.POSTSCRIPT;
            PrintRequestAttributeSet attributeSet = new HashPrintRequestAttributeSet();
            attributeSet.add(MediaSizeName.ISO_A4);
            PrintService[] printServices = PrintServiceLookup.lookupPrintServices(docFlavor, attributeSet);
            for(PrintService printService : printServices){
                System.out.println(printService.getName());
            }

            if (printServices.length == 0) {
                System.out.println("No print services found.");
                return;
            }

            // Choose the default printer if available
            PrintService printService = PrintServiceLookup.lookupDefaultPrintService();
            if (printService == null) {
                printService = printServices[0];
            }

            System.out.println("Printing to: " + printService.getName());

            DocPrintJob printJob = printService.createPrintJob();
            Doc doc = new SimpleDoc(inputStream, docFlavor, null);

            // Print document
            printJob.print(doc, attributeSet);
            inputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
