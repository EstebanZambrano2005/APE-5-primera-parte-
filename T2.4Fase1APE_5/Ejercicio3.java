import java.io.File;

// Ejercicio 3: Eliminar un fichero en Java
public class Ejercicio3 {
    public static void main(String[] args) {

        // Objeto File con el nombre del archivo que se desea eliminar
        File archivo = new File("estudiantes.txt");

        // delete() intenta eliminar el archivo y devuelve true si lo logró
        boolean eliminado = archivo.delete();

        if (eliminado) {
            // Si se eliminó, mensaje de confirmación
            System.out.println("El archivo " + archivo.getName() + " se eliminó correctamente.");
        } else {
            // Si no se pudo eliminar, se indica el problema
            System.out.println("No se pudo eliminar el archivo: puede que no exista o esté en uso.");
        }
    }
}
