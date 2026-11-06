import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio2Productos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Ejercicio 2: Registro de Productos ---");
        // El 'true' activa el modo append para no borrar registros previos
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt", true))) {
            char continuar;
            do {
                System.out.print("
Ingrese el nombre del producto: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingrese el precio: ");
                while (!scanner.hasNextDouble()) {
                    System.out.print("Ingrese un precio válido: ");
                    scanner.next();
                }
                double precio = scanner.nextDouble();

                System.out.print("Ingrese la cantidad disponible: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Ingrese una cantidad válida: ");
                    scanner.next();
                }
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                double valorTotal = precio * cantidad;

                // Guardar registro
                writer.write("Producto: " + nombre + " | Precio: $" + precio + " | Cantidad: " + cantidad + " | Valor Total: $" + valorTotal);
                writer.newLine();

                System.out.print("¿Desea registrar otro producto? (s/n): ");
                continuar = scanner.nextLine().toLowerCase().charAt(0);
            } while (continuar == 's');

            System.out.println("
¡Productos guardados correctamente en 'productos.txt'!");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
