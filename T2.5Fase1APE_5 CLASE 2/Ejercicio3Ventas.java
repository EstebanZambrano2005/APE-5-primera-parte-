import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3Ventas {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double totalAcumulado = 0;

        System.out.println("--- Ejercicio 3: Sistema de Registro de Ventas ---");
        // El 'true' activa el modo append para guardar sin sobreescribir
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ventas.txt", true))) {
            while (true) {
                System.out.print("
Ingrese el nombre del producto (o 'fin' para salir): ");
                String producto = scanner.nextLine();

                if (producto.equalsIgnoreCase("fin")) {
                    break;
                }

                System.out.print("Ingrese el precio: ");
                while (!scanner.hasNextDouble()) {
                    System.out.print("Ingrese un precio válido: ");
                    scanner.next();
                }
                double precio = scanner.nextDouble();

                System.out.print("Ingrese la cantidad vendida: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Ingrese una cantidad válida: ");
                    scanner.next();
                }
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                double subtotal = precio * cantidad;
                double totalPagar = subtotal;

                // Aplicar descuento del 10% si subtotal >= $100
                if (subtotal >= 100) {
                    double descuento = subtotal * 0.10;
                    totalPagar = subtotal - descuento;
                    System.out.println("-> Descuento del 10% aplicado. Subtotal: $" + subtotal + " | Total a pagar: $" + totalPagar);
                } else {
                    System.out.println("-> Subtotal y Total a pagar: $" + totalPagar);
                }

                // Guardar venta individual
                writer.write("Producto: " + producto + " | Cantidad: " + cantidad + " | Subtotal: $" + subtotal + " | Total: $" + totalPagar);
                writer.newLine();

                totalAcumulado += totalPagar;
            }

            // Registrar total acumulado al finalizar
            writer.write("=== TOTAL ACUMULADO DE VENTAS: $" + totalAcumulado + " ===");
            writer.newLine();

            System.out.println("
¡Ventas guardadas en 'ventas.txt'! Total acumulado: $" + totalAcumulado);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
