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
        // Se crea un objeto StringBuilder para concatenar el texto extraído del PDF.
        StringBuilder text = new StringBuilder();
        try (PDDocument document = PDDocument.load(new File(fileName))) {
            // Se carga el documento PDF desde el archivo especificado.
            // El documento se cerrará automáticamente al finalizar el bloque try.
            if (!document.isEncrypted()) {
                // Se verifica si el documento PDF está encriptado.
                // Si no lo está, se procede a extraer el texto del PDF.
                PDFTextStripper stripper = new PDFTextStripper();
                // Se crea un objeto PDFTextStripper para extraer texto del PDF.
                text.append(stripper.getText(document));
                // Se obtiene el texto del documento y se agrega al StringBuilder.
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
            // Se crea un nuevo documento PDF.
            PDPage page = new PDPage();
            // Se crea una nueva página en el documento.
            document.addPage(page);
            try (PDPageContentStream contentStream = new PDPageContentStream(document, page)) {
                // Se crea un objeto PDPageContentStream para escribir en la página.
                contentStream.beginText();
                // Se inicia el flujo de texto.
                contentStream.setFont(PDType1Font.HELVETICA, 12);
                // Se establece la fuente y el tamaño de la fuente.
                contentStream.newLineAtOffset(100, 700);
                // Se establece la fuente y el tamaño de la fuente.
                contentStream.showText(text);
                // Se muestra el texto en la posición especificada.
                contentStream.endText();
                // Se finaliza el flujo de texto.
            }
            document.save(fileName);
            // Se guarda el documento PDF en el archivo especificado.
            System.out.println("Se escribió en el archivo PDF correctamente.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el archivo PDF.");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
       String fileName = "example.pdf";
       // String fileName = "C:\\Users\\pc\\Desktop\\ManejoArchivosYLogs\\src\\main\\java\\ciaf\\ciafprogra3\\manejoarchivos01\\PrincipiosSOLID.pdf";
        String textToWrite = "Este es un ejemplo de texto para escribir en un archivo PDF.";

        // Escribir en archivo PDF
         writeToPDF(fileName, textToWrite);

        // Leer desde archivo PDF
        String readText = readFromPDF(fileName);
        System.out.println("Texto leído desde el archivo PDF:");
        System.out.println(readText);
    }
}
