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
            // Itera sobre cada registro en la lista de datos
            for (String[] record : data) {
                // Itera sobre cada registro en la lista de datos
                writer.write(String.join(",", record));
                // Itera sobre cada registro en la lista de datos
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
        // Crea una lista para almacenar los registros leídos desde el archivo CSV
        List<String[]> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            // Abre un BufferedReader para leer desde el archivo especificado.
            String line;
            // Lee cada línea del archivo y la divide por comas para obtener los campos del registro
            while ((line = reader.readLine()) != null) {
                // Divide la línea por comas y obtiene un array de strings que representa el registro
                String[] record = line.split(",");
                // Agrega el registro a la lista de datos
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
