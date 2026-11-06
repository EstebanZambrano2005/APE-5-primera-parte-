import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

// Ejercicio 2: Escribir información en un fichero
// Nota: el archivo estudiantes.txt debe existir previamente.
public class Ejercicio2 {
    public static void main(String[] args) {

        File archivo = new File("estudiantes.txt");

        // El enunciado indica que el archivo ya debe existir
        if (!archivo.exists()) {
            System.out.println("El archivo estudiantes.txt no existe. Créalo primero en la carpeta del proyecto.");
            return;
        }

        // Scanner para ingresar información por teclado
        Scanner teclado = new Scanner(System.in);

        // Se solicita el mensaje al usuario
        System.out.print("Escribe un mensaje: ");
        String mensaje = teclado.nextLine();

        FileWriter escritor = null;

        try {
            // El parámetro true conserva la información anterior
            // y agrega el nuevo mensaje al final del archivo
            escritor = new FileWriter("estudiantes.txt", true);

            // write() guarda el mensaje (se agrega un salto de línea al final)
            escritor.write(mensaje + System.lineSeparator());

            System.out.println("La información se guardó correctamente.");

        } catch (IOException e) {
            // Control de posibles errores
            System.out.println("Ocurrió un error al escribir en el archivo: " + e.getMessage());
        } finally {
            // Se cierra el archivo con close()
            try {
                if (escritor != null) {
                    escritor.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el archivo: " + e.getMessage());
            }
        }

        teclado.close();
    }
}
