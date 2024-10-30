package ciaf.ciafprogra3.manejoStrings;

import java.util.Arrays;
import java.util.List;

public class Factura {
    public static void main(String[] args) {
        // Datos del usuario
        List<String> userInfo = Arrays.asList("Santiago", "Ramirez", "sramirez@gmail.com", "123-456-7890");


        List<String> productos = Arrays.asList("Laptop - $800", "Mouse - $25", "Teclado - $50");

        // Calcular el total
        double total = 0;
        for (String producto : productos) {
            String[] partes = producto.split(" - \\$");
            total += Double.parseDouble(partes[1]);
        }

        // Crear factura
        StringBuilder factura = new StringBuilder();
        factura.append("===================================================\n");
        factura.append("                     FACTURA\n");
        factura.append("===================================================\n");
        factura.append(String.format("Cliente: %s %s\n", userInfo.get(0), userInfo.get(1)));
        factura.append(String.format("Correo: %s\n", userInfo.get(2)));
        factura.append(String.format("Teléfono: %s\n", userInfo.get(3)));
        factura.append("---------------------------------------------------\n");
        factura.append("Productos:\n");
        factura.append("---------------------------------------------------\n");

        for (String producto : productos) {
            factura.append(String.format("  %s\n", producto));
        }

        factura.append("---------------------------------------------------\n");
        factura.append(String.format("Total:                $%.2f\n", total));
        factura.append("===================================================\n");
        factura.append("                 Gracias por su compra!\n");
        factura.append("===================================================\n");

        // Imprimir la factura
        System.out.println(factura.toString());
    }
}
