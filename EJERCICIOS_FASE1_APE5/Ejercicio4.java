import java.io.File;
import java.io.IOException;

// Ejercicio 4: Ciclo de vida completo y borrado seguro
public class Ejercicio4 {
    public static void main(String[] args) {

        // 1. Objeto File que representa la ruta "datos/temporal.txt"
        File archivo = new File("datos/temporal.txt");

        // 2. Si no existe, se crea de forma segura controlando IOException
        if (!archivo.exists()) {
            try {
                // Si la carpeta "datos" no existe, primero se crea
                File carpeta = archivo.getParentFile();
                if (carpeta != null && !carpeta.exists()) {
                    carpeta.mkdirs();
                }

                if (archivo.createNewFile()) {
                    System.out.println("Archivo temporal creado: " + archivo.getPath());
                }
            } catch (IOException e) {
                System.out.println("Error de E/S al crear el archivo: " + e.getMessage());
            }
        } else {
            System.out.println("El archivo temporal ya existía: " + archivo.getPath());
        }

        // 3. Fase de validación: variable booleana que simula la confirmación
        //    del usuario antes de eliminar datos importantes
        boolean confirmarBorrado = true;

        // 4. delete() se usa solo si la confirmación es verdadera
        if (confirmarBorrado) {
            boolean eliminado = archivo.delete();
            System.out.println("¿Archivo eliminado? " + eliminado);
        } else {
            System.out.println("Borrado cancelado por el usuario. El archivo se conserva.");
        }
    }
}
