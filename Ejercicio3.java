import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double totalAcumulado = 0;

        // Modo append para no eliminar registros anteriores
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("ventas.txt", true))) {

            while (true) {
                System.out.print("Nombre del producto (escriba 'fin' para terminar): ");
                String producto = sc.nextLine();

                if (producto.equalsIgnoreCase("fin")) {
                    break;
                }

                System.out.print("Precio: ");
                double precio = Double.parseDouble(sc.nextLine().replace(",", "."));

                System.out.print("Cantidad vendida: ");
                int cantidad = Integer.parseInt(sc.nextLine());

                double subtotal = precio * cantidad;
                double descuento = 0;

                if (subtotal >= 100) {
                    descuento = subtotal * 0.10;
                }

                double totalPagar = subtotal - descuento;
                totalAcumulado += totalPagar;

                System.out.println("Subtotal: $" + subtotal);
                System.out.println("Descuento: $" + descuento);
                System.out.println("Total a pagar: $" + totalPagar);

                bw.write("Producto: " + producto);
                bw.newLine();
                bw.write("Precio: $" + precio + " | Cantidad: " + cantidad);
                bw.newLine();
                bw.write("Subtotal: $" + subtotal + " | Descuento: $" + descuento);
                bw.newLine();
                bw.write("Total a pagar: $" + totalPagar);
                bw.newLine();
                bw.write("------------------------");
                bw.newLine();
            }

            // Total acumulado al finalizar
            bw.write("TOTAL ACUMULADO DE VENTAS: $" + totalAcumulado);
            bw.newLine();
            bw.write("========================");
            bw.newLine();

            System.out.println("Total acumulado de ventas: $" + totalAcumulado);
            System.out.println("Ventas guardadas correctamente en ventas.txt");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: ingrese valores numéricos válidos para precio y cantidad.");
        }

        sc.close();
    }
}
