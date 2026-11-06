import java.io.File;
import java.io.IOException;

// Ejercicio 1: Crear un fichero en Java
public class Ejercicio1 {
    public static void main(String[] args) {

        // Objeto File que representa el archivo "curso.txt"
        File archivo = new File("curso.txt");

        try {
            // createNewFile() devuelve true si lo creó y false si ya existía
            if (archivo.createNewFile()) {
                System.out.println("El archivo se creó correctamente.");
            } else {
                System.out.println("El archivo ya existe.");
            }

            // Se muestra el nombre del archivo con getName()
            System.out.println("Nombre del archivo: " + archivo.getName());

        } catch (IOException e) {
            // Control de posibles errores
            System.out.println("Ocurrió un error al crear el archivo: " + e.getMessage());
        }
    }
}
