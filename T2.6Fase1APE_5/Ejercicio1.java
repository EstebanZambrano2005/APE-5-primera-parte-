import java.io.File;
import java.io.IOException;

// Ejercicio 1: Exploración y Gestión de Metadatos con File
public class Ejercicio1 {
    public static void main(String[] args) {

        // Objeto File que representa la ruta "datos/prueba.txt"
        File archivo = new File("datos/prueba.txt");

        // 1. Comprobación previa: ¿la ruta apunta a un recurso del disco?
        if (archivo.exists()) {
            System.out.println("El archivo ya existe.");
        } else {
            System.out.println("El archivo no existe. Se intentará crear...");

            // 2. Creación controlada: createNewFile() puede lanzar IOException,
            //    por eso se maneja con try-catch
            try {
                // Si la carpeta "datos" no existe, primero se crea
                File carpeta = archivo.getParentFile();
                if (carpeta != null && !carpeta.exists()) {
                    carpeta.mkdirs();
                }

                if (archivo.createNewFile()) {
                    System.out.println("Archivo creado correctamente.");
                }
            } catch (IOException e) {
                System.out.println("Error de E/S al crear el archivo: " + e.getMessage());
            }
        }

        // 3. Extracción de información (exista de antes o recién creado)
        System.out.println("Nombre del archivo: " + archivo.getName());
        System.out.println("Ruta con la que se construyó: " + archivo.getPath());
    }
}
