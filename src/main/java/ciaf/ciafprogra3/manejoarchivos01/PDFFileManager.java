package ciaf.ciafprogra3.manejoarchivos01;

import java.io.File;
import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.text.PDFTextStripper;

public class PDFFileManager {

    // Método para leer texto desde un archivo PDF
    public static String readFromPDF(String fileName) {
        StringBuilder text = new StringBuilder();
        try (PDDocument document = PDDocument.load(new File(fileName))) {
            if (!document.isEncrypted()) {
                PDFTextStripper stripper = new PDFTextStripper();
                text.append(stripper.getText(document));
            } else {
                System.out.println("El archivo PDF está encriptado y no se puede leer.");
            }
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer el archivo PDF.");
            e.printStackTrace();
        }
        return text.toString();
    }

    // Método para escribir texto en un archivo PDF
    public static void writeToPDF(String fileName, String text) {
        try (PDDocument document = new PDDocument()) {
            PDPage page = new PDPage();
            document.addPage(page);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                contentStream.beginText();
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                contentStream.newLineAtOffset(100, 700);
                contentStream.showText(text);
                contentStream.endText();
            }
            document.save(fileName);
            System.out.println("Se escribió en el archivo PDF correctamente.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el archivo PDF.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String fileName = "example.pdf";
        String textToWrite = "Este es un ejemplo de texto para escribir en un archivo PDF.";

        // Escribir en archivo PDF
        writeToPDF(fileName, textToWrite);

        // Leer desde archivo PDF
        String readText = readFromPDF(fileName);
        System.out.println("Texto leído desde el archivo PDF:");
        System.out.println(readText);
    }
}
