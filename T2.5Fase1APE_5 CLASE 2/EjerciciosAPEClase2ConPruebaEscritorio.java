import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * ============================================================================
 * UNIVERSIDAD TÉCNICA DE AMBATO
 * FISEI - INGENIERÍA EN SOFTWARE
 * APE CLASE 2: MANEJO DE ARCHIVOS EN JAVA CON BUFFEREDWRITER Y FILEWRITER
 * ============================================================================
 * 
 * PRUEBA DE ESCRITORIO GENERAL DE LOS EJERCICIOS:
 * 
 * EJERCICIO 1: Registro de estudiantes
 * | Entrada Nombre | Entrada Calificación | Archivo 'estudiantes.txt' generado                            |
 * |----------------|----------------------|---------------------------------------------------------------|
 * | "Carlos"       | 9.5                  | Línea 1: Nombre: Carlos 
 Línea 2: Calificación: 9.5          |
 * | "Ana"          | 8.0                  | Línea 3: Nombre: Ana 
 Línea 4: Calificación: 8.0             |
 * | "Luis"         | 10.0                 | Línea 5: Nombre: Luis 
 Línea 6: Calificación: 10.0           |
 * 
 * EJERCICIO 2: Registro de productos (Modo Append)
 * | Entrada Producto | Precio | Cantidad | Total Calculado | Continuar? | Archivo 'productos.txt' escrito                                 |
 * |------------------|--------|----------|-----------------|------------|-----------------------------------------------------------------|
 * | "Manzanas"       | 0.50   | 10       | 5.00            | 's'        | Producto: Manzanas | Precio: $0.5 | Cantidad: 10 | Valor Total: $5.0 |
 * | "Leche"          | 1.25   | 4        | 5.00            | 'n'        | Producto: Leche | Precio: $1.25 | Cantidad: 4 | Valor Total: $5.0     |
 * 
 * EJERCICIO 3: Sistema de ventas con descuento y acumulación (Modo Append)
 * | Producto | Precio | Cant. | Subtotal | Subtotal >= 100? | Descuento (10%) | Total Pagar | Total Acumulado | Archivo 'ventas.txt' escrito                                          |
 * |----------|--------|-------|----------|------------------|-----------------|-------------|-----------------|-----------------------------------------------------------------------|
 * | "Laptop" | 800.0  | 1     | 800.0    | V (Verdadero)    | 80.0            | 720.0       | 720.0           | Producto: Laptop | Cantidad: 1 | Subtotal: $800.0 | Total: $720.0      |
 * | "Mouse"  | 15.0   | 2     | 30.0     | F (Falso)        | 0.0             | 30.0        | 750.0           | Producto: Mouse | Cantidad: 2 | Subtotal: $30.0 | Total: $30.0        |
 * | "fin"    | -      | -     | -        | -                | -               | -           | 750.0           | === TOTAL ACUMULADO DE VENTAS: $750.0 ===                            |
 * ============================================================================
 */
public class EjerciciosAPEClase2ConPruebaEscritorio {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=================================================================");
            System.out.println("   MENÚ PRINCIPAL - EJERCICIOS APE CLASE 2 CON PRUEBA DE ESCRITORIO   ");
            System.out.println("=================================================================");
            System.out.println("1. Ejercicio 1: Registro de 3 Estudiantes (estudiantes.txt)");
            System.out.println("2. Ejercicio 2: Registro de Productos - Modo Append (productos.txt)");
            System.out.println("3. Ejercicio 3: Sistema de Ventas y Descuentos - Modo Append (ventas.txt)");
            System.out.println("4. Mostrar Guía de Prueba de Escritorio en Consola");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Entrada no válida. Ingrese un número entre 1 y 5: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer de lectura

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
                    mostrarPruebaEscritorio();
                    break;
                case 5:
                    System.out.println("
¡Programa finalizado exitosamente!");
                    break;
                default:
                    System.out.println("
Opción no válida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 5);

        scanner.close();
    }

    /**
     * Ejercicio 1: Registro de 3 estudiantes y sus calificaciones.
     * Guarda la información en 'estudiantes.txt', ocupando 2 líneas por estudiante.
     */
    public static void ejercicio1(Scanner scanner) {
        System.out.println("
--- EJERCICIO 1: REGISTRO DE ESTUDIANTES ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estudiantes.txt"))) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("
Estudiante #" + i);
                System.out.print("Ingrese el nombre del estudiante: ");
                String nombre = scanner.nextLine();

                System.out.print("Ingrese la calificación: ");
                while (!scanner.hasNextDouble()) {
                    System.out.print("Calificación no válida. Ingrese un número: ");
                    scanner.next();
                }
                double calificacion = scanner.nextDouble();
                scanner.nextLine(); // Limpiar buffer

                // Guardar ambos datos en el archivo (2 líneas por estudiante)
                writer.write("Nombre: " + nombre);
                writer.newLine();
                writer.write("Calificación: " + calificacion);
                writer.newLine();
            }
            System.out.println("
[ÉXITO] Se registraron los 3 estudiantes correctamente en 'estudiantes.txt'.");
        } catch (IOException e) {
            System.out.println("[ERROR] No se pudo escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Ejercicio 2: Registro de productos con cálculo de total.
     * Utiliza el modo append (true en FileWriter) para no sobreescribir.
     */
    public static void ejercicio2(Scanner scanner) {
        System.out.println("
--- EJERCICIO 2: REGISTRO DE PRODUCTOS (MODO APPEND) ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("productos.txt", true))) {
            char continuar;
            do {
                System.out.print("
Nombre del producto: ");
                String nombre = scanner.nextLine();

                System.out.print("Precio unitario ($): ");
                while (!scanner.hasNextDouble()) {
                    System.out.print("Precio no válido. Ingrese un número: ");
                    scanner.next();
                }
                double precio = scanner.nextDouble();

                System.out.print("Cantidad disponible: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Cantidad no válida. Ingrese un entero: ");
                    scanner.next();
                }
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                double valorTotal = precio * cantidad;

                // Escribir registro en el archivo
                writer.write("Producto: " + nombre + " | Precio: $" + precio + " | Cantidad: " + cantidad + " | Valor Total: $" + valorTotal);
                writer.newLine();

                System.out.print("¿Desea agregar otro producto? (s/n): ");
                continuar = scanner.nextLine().toLowerCase().charAt(0);
            } while (continuar == 's');

            System.out.println("
[ÉXITO] Productos guardados correctamente en 'productos.txt'.");
        } catch (IOException e) {
            System.out.println("[ERROR] No se pudo escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Ejercicio 3: Sistema de registro de ventas con cálculo de descuento y acumulador.
     * Modo append activo y finalización mediante palabra clave 'fin'.
     */
    public static void ejercicio3(Scanner scanner) {
        System.out.println("
--- EJERCICIO 3: SISTEMA DE REGISTRO DE VENTAS ---");
        double totalAcumulado = 0;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("ventas.txt", true))) {
            while (true) {
                System.out.print("
Ingrese el nombre del producto (o escriba 'fin' para terminar): ");
                String producto = scanner.nextLine();

                if (producto.equalsIgnoreCase("fin")) {
                    break;
                }

                System.out.print("Precio: $");
                while (!scanner.hasNextDouble()) {
                    System.out.print("Precio no válido. Ingrese un número: ");
                    scanner.next();
                }
                double precio = scanner.nextDouble();

                System.out.print("Cantidad vendida: ");
                while (!scanner.hasNextInt()) {
                    System.out.print("Cantidad no válida. Ingrese un número entero: ");
                    scanner.next();
                }
                int cantidad = scanner.nextInt();
                scanner.nextLine(); // Limpiar buffer

                double subtotal = precio * cantidad;
                double totalPagar = subtotal;

                // Evaluación del descuento (10% si subtotal >= $100)
                if (subtotal >= 100) {
                    double descuento = subtotal * 0.10;
                    totalPagar = subtotal - descuento;
                    System.out.println("-> Descuento del 10% aplicado (-$" + descuento + ")");
                }

                System.out.println("-> Subtotal: $" + subtotal + " | Total a Pagar: $" + totalPagar);

                // Guardar la venta actual en el archivo
                writer.write("Producto: " + producto + " | Cantidad: " + cantidad + " | Subtotal: $" + subtotal + " | Total a Pagar: $" + totalPagar);
                writer.newLine();

                totalAcumulado += totalPagar;
            }

            // Al finalizar, escribir el total acumulado en el archivo
            writer.write("=== TOTAL ACUMULADO DE VENTAS: $" + totalAcumulado + " ===");
            writer.newLine();

            System.out.println("
[ÉXITO] Ventas guardadas en 'ventas.txt'. Total acumulado en esta sesión: $" + totalAcumulado);
        } catch (IOException e) {
            System.out.println("[ERROR] No se pudo escribir en el archivo: " + e.getMessage());
        }
    }

    /**
     * Muestra la tabla de prueba de escritorio en la consola.
     */
    public static void mostrarPruebaEscritorio() {
        System.out.println("
==================================================================================================================");
        System.out.println("                                     TABLA DE PRUEBA DE ESCRITORIO                                                ");
        System.out.println("==================================================================================================================");
        System.out.println("EJERCICIO 1: Registro de Estudiantes");
        System.out.println("+-------------------+----------------------+---------------------------------------------------------------------+");
        System.out.println("| Entrada Nombre    | Entrada Calificación | Archivo 'estudiantes.txt' generado (2 líneas por estudiante)        |");
        System.out.println("+-------------------+----------------------+---------------------------------------------------------------------+");
        System.out.println("| Carlos            | 9.5                  | Línea 1: Nombre: Carlos \n Línea 2: Calificación: 9.5              |");
        System.out.println("| Ana               | 8.0                  | Línea 3: Nombre: Ana \n Línea 4: Calificación: 8.0                  |");
        System.out.println("| Luis              | 10.0                 | Línea 5: Nombre: Luis \n Línea 6: Calificación: 10.0                |");
        System.out.println("+-------------------+----------------------+---------------------------------------------------------------------+");

        System.out.println("
EJERCICIO 2: Registro de Productos (Modo Append)");
        System.out.println("+------------------+--------+----------+-----------------+------------+------------------------------------------+");
        System.out.println("| Entrada Producto | Precio | Cantidad | Total Calculado | Continuar? | Archivo 'productos.txt' escrito          |");
        System.out.println("+------------------+--------+----------+-----------------+------------+------------------------------------------+");
        System.out.println("| Manzanas         | 0.50   | 10       | 5.00            | s          | Producto: Manzanas | Precio: $0.5 ...  |");
        System.out.println("| Leche            | 1.25   | 4        | 5.00            | n          | Producto: Leche | Precio: $1.25 ...     |");
        System.out.println("+------------------+--------+----------+-----------------+------------+------------------------------------------+");

        System.out.println("
EJERCICIO 3: Registro de Ventas (Modo Append con Descuento)");
        System.out.println("+----------+--------+-------+----------+----------------+---------------+-------------+-----------------+-----------------------------------+");
        System.out.println("| Producto | Precio | Cant. | Subtotal | Subtotal>=100? | Descuento 10% | Total Pagar | Total Acumulado | Archivo 'ventas.txt' escrito      |");
        System.out.println("+----------+--------+-------+----------+----------------+---------------+-------------+-----------------+-----------------------------------+");
        System.out.println("| Laptop   | 800.0  | 1     | 800.0    | VERDADERO      | 80.0          | 720.0       | 720.0           | Producto: Laptop | Total: $720.0 |");
        System.out.println("| Mouse    | 15.0   | 2     | 30.0     | FALSO          | 0.0           | 30.0        | 750.0           | Producto: Mouse | Total: $30.0    |");
        System.out.println("| fin      | -      | -     | -        | -              | -             | -           | 750.0           | === TOTAL ACUMULADO: $750.0 ===   |");
        System.out.println("+----------+--------+-------+----------+----------------+---------------+-------------+-----------------+-----------------------------------+");
    }
}
