import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Ejercicio 2: Escritura estructurada por líneas con BufferedWriter
public class Ejercicio2 {
    public static void main(String[] args) {

        BufferedWriter bw = null;

        try {
            // 1. Flujo de salida: BufferedWriter enlazado con un FileWriter
            //    (sin segundo parámetro: si el archivo existe, se sobrescribe)
            bw = new BufferedWriter(new FileWriter("materias.txt"));

            // 2 y 3. Cinco asignaturas, cada una en su propia línea con newLine()
            bw.write("Algoritmos y Lógica de Programación");
            bw.newLine();
            bw.write("Matemática Discreta");
            bw.newLine();
            bw.write("Física");
            bw.newLine();
            bw.write("Comunicación Oral y Escrita");
            bw.newLine();
            bw.write("Introducción a la Ingeniería de Software");
            bw.newLine();

            System.out.println("Archivo materias.txt escrito correctamente.");

        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        } finally {
            // 4. Liberar recursos: cerrar el flujo con close()
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el flujo: " + e.getMessage());
            }
        }

        // 5. Verificación: se comprueba que el archivo existe y se muestra
        //    su contenido (una asignatura por línea)
        File archivo = new File("materias.txt");
        System.out.println("¿El archivo existe en la carpeta del proyecto? " + archivo.exists());

        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            int numero = 1;
            while ((linea = br.readLine()) != null) {
                System.out.println(numero + ". " + linea);
                numero++;
            }
        } catch (IOException e) {
            System.out.println("Error de lectura: " + e.getMessage());
        }
    }
}
