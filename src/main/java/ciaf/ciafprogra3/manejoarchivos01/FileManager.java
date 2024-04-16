package ciaf.ciafprogra3.manejoarchivos01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

    // Método para crear un archivo de texto
    public static void createFile(String fileName) {
        try {
            File file = new File(fileName);
            if (file.createNewFile()) {
                System.out.println("Archivo creado: " + file.getName());
            } else {
                System.out.println("El archivo ya existe.");
            }
        } catch (IOException e) {
            System.out.println("Se produjo un error al crear el archivo.");
            e.printStackTrace();
        }
    }

    // Método para escribir en un archivo de texto
    public static void writeToFile(String fileName, List<String> lines) {
        // Itera sobre cada línea en la lista de líneas.
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            // Itera sobre cada línea en la lista de líneas.
            for (String line : lines) {
                // Escribe la línea en el archivo.
                writer.write(line);
                // Agrega un salto de línea después de cada línea.
                writer.newLine();
            }
            System.out.println("Se escribió en el archivo correctamente.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el archivo.");
            e.printStackTrace();
        }
    }

    // Método para leer desde un archivo de texto
    public static List<String> readFromFile(String fileName) {
        List<String> lines = new ArrayList<>();
        // Abre un BufferedReader para leer desde el archivo especificado.
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            // Lee cada línea del archivo y la agrega a la lista de líneas. Lee hasta que no existan mas lineas es decir sean nulas
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer el archivo.");
            e.printStackTrace();
        }
        return lines;
    }

    // Método para guardar la información separada por comas en una lista de String
    public static List<String> parseCSV(String line) {
        // Crea una lista para almacenar los elementos parseados
        List<String> elements = new ArrayList<>();
        // Divide la línea por comas y obtiene un array de strings
        String[] parts = line.split(",");

        // Divide la línea por comas y obtiene un array de strings
        for (String part : parts) {
            // Se agrega el elemento después de eliminar los espacios en blanco iniciales y finales-- uso del .trim para eliminar espacio en blanco
            elements.add(part.trim());
        }
        return elements;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String fileName = "example.txt";
        List<String> lines = new ArrayList<>();
        lines.add("Juan,Perez,30");
        lines.add("Maria,Gomez,25");
        lines.add("Carlos,Ruiz,40");

        // Crear archivo
        createFile(fileName);

        // Escribir en archivo
        writeToFile(fileName, lines);

        // Leer desde archivo
        List<String> readLines = readFromFile(fileName);
        for (String readLine : readLines) {
            System.out.println("Linea leida: " + readLine);
            List<String> elements = parseCSV(readLine);
            for (String element : elements) {
                System.out.println("Elemento: " + element);
            }
        }
    }
}
