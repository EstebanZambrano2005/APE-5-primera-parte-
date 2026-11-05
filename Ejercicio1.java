import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * Ejercicio 1. Registro de estudiantes y calificaciones
 * Guarda 3 estudiantes en estudiantes.txt (dos líneas por estudiante:
 * la primera con el nombre y la segunda con la calificación).
 */
public class Ejercicio1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // try-with-resources: cierra el archivo automáticamente al terminar
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("estudiantes.txt"))) {

            for (int i = 1; i <= 3; i++) {
                System.out.println("--- Estudiante " + i + " ---");

                System.out.print("Nombre: ");
                String nombre = sc.nextLine();

                System.out.print("Calificación: ");
                double calificacion = Double.parseDouble(sc.nextLine().replace(",", "."));

                // Línea 1: nombre
                bw.write(nombre);
                bw.newLine();
                // Línea 2: calificación
                bw.write(String.valueOf(calificacion));
                bw.newLine();
            }

            System.out.println("Datos guardados correctamente en estudiantes.txt");

        } catch (IOException e) {
            System.out.println("Error al escribir el archivo: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: la calificación debe ser un número.");
        }

        sc.close();
    }
}
