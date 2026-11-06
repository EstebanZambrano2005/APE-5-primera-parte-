import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Ejercicio1Estudiantes {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("--- Ejercicio 1: Registro de Estudiantes ---");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("estudiantes.txt"))) {
            for (int i = 1; i <= 3; i++) {
                System.out.println("
Estudiante " + i + ":");
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
            System.out.println("
¡Datos guardados exitosamente en 'estudiantes.txt'!");
        } catch (IOException e) {
            System.out.println("Error al escribir en el archivo: " + e.getMessage());
        }

        scanner.close();
    }
}
