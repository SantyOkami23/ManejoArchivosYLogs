package ciaf.ciafprogra3.manejoarchivos01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVFileManager {

    // Método para escribir en un archivo CSV
    public static void writeToCSV(String fileName, List<String[]> data) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (String[] record : data) {
                writer.write(String.join(",", record));
                writer.newLine();
            }
            System.out.println("Se escribió en el archivo CSV correctamente.");
        } catch (IOException e) {
            System.out.println("Se produjo un error al escribir en el archivo CSV.");
            e.printStackTrace();
        }
    }

    // Método para leer desde un archivo CSV
    public static List<String[]> readFromCSV(String fileName) {
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] record = line.split(",");
                data.add(record);
            }
        } catch (IOException e) {
            System.out.println("Se produjo un error al leer el archivo CSV.");
            e.printStackTrace();
        }
        return data;
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        String fileName = "example.csv";
        List<String[]> data = new ArrayList<>();
        data.add(new String[]{"Juan", "Perez", "30"});
        data.add(new String[]{"Maria", "Gomez", "25"});
        data.add(new String[]{"Carlos", "Ruiz", "40"});

        // Escribir en archivo CSV
        writeToCSV(fileName, data);

        // Leer desde archivo CSV
        List<String[]> readData = readFromCSV(fileName);
        for (String[] record : readData) {
            System.out.println("Registro leído:");
            for (String field : record) {
                System.out.println(field);
            }
        }
    }
}
