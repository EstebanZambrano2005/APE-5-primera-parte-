import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class EjerciciosAPEClase2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=========================================");
            System.out.println("       MENÚ DE EJERCICIOS APE CLASE 2    ");
            System.out.println("=========================================");
            System.out.println("1. Ejercicio 1: Registro de estudiantes y calificaciones");
            System.out.println("2. Ejercicio 2: Registro de productos con modo Append");
            System.out.println("3. Ejercicio 3: Sistema de registro de ventas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Opción inválida. Ingrese un número (1-4): ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar buffer

            switch (opcion) {
                case 1:
                    ejercicio1(scanner);
                    break;
                case 2:
                    ejercicio2(scanner);
                    break;
                case 3:
                    ejercicio3(scanner);
                    break;
                case 4:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 4);

        scanner.close();
    }

    /**
     * Ejercicio 1: Registro de estudiantes y calificaciones
     * Permite registrar los datos de 3 estudiantes y guardarlos en 'estudiantes.txt'.
     * Cada estudiante ocupa dos líneas.
     */
    public static void ejercicio1(Scanner scanner) {
        System.out.println("\n--- Ejercicio 1: Registro de Estudiantes ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estudiantes.txt"))) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("\nEstudiante " + i + ":");
                System.out.print("Ingrese el nombre del estudiante: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingrese su calificación: ");
                while (!scanner.hasNextDouble()) {
                    System.out.print("Por favor ingrese una calificación válida: ");
                    scanner.next();
                }
                double calificacion = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                // Guardar datos en el archivo (2 líneas por estudiante)
                writer.write("Nombre: " + nombre);
                writer.newLine();
                writer.write("Calificación: " + calificacion);
                writer.newLine();
            }
            System.out.println("\n¡Datos guardados exitosamente en 'estudiantes.txt'!");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Ejercicio 2: Registro de productos con modo Append
     * Permite registrar productos en 'productos.txt' calculando el valor total.
     * Permite registrar nuevos productos sin borrar los anteriores (modo append).
     */
    public static void ejercicio2(Scanner scanner) {
        System.out.println("\n--- Ejercicio 2: Registro de Productos ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt", true))) {
            char continuar;
            do {
                System.out.print("\nIngrese el nombre del producto: ");
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

            System.out.println("\n¡Productos guardados correctamente en 'productos.txt'!");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Ejercicio 3: Sistema de registro de ventas
     * Permite registrar ventas hasta escribir 'fin' en 'ventas.txt'.
     * Aplica 10% de descuento si subtotal >= $100 y guarda el total acumulado.
     */
    public static void ejercicio3(Scanner scanner) {
        System.out.println("\n--- Ejercicio 3: Sistema de Registro de Ventas ---");
        double totalAcumulado = 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ventas.txt", true))) {
            while (true) {
                System.out.print("\nIngrese el nombre del producto (o 'fin' para salir): ");
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

                if (subtotal >= 100) {
                    double descuento = subtotal * 0.10;
                    totalPagar = subtotal - descuento;
                    System.out.println("-> Descuento del 10% aplicado. Subtotal: $" + subtotal + " | Total a pagar: $" + totalPagar);
                } else {
                    System.out.println("-> Subtotal y Total a pagar: $" + totalPagar);
                }

                // Guardar venta
                writer.write("Producto: " + producto + " | Cantidad: " + cantidad + " | Subtotal: $" + subtotal + " | Total: $" + totalPagar);
                writer.newLine();

                totalAcumulado += totalPagar;
            }

            // Registrar total acumulado al final de la sesión
            writer.write("=== TOTAL ACUMULADO DE VENTAS: $" + totalAcumulado + " ===");
            writer.newLine();

            System.out.println("\n¡Ventas guardadas en 'ventas.txt'! Total acumulado: $" + totalAcumulado);
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }
    }
}
