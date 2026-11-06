import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * ============================================================================
 * EJERCICIOS DE MANEJO DE FICHEROS EN JAVA (CON PRUEBA DE ESCRITORIO)
 * ============================================================================
 * 
 * PRUEBA DE ESCRITORIO DETALLADA DE CADA EJERCICIO:
 * 
 * ----------------------------------------------------------------------------
 * EJERCICIO 1: Crear un fichero en Java ("curso.txt")
 * ----------------------------------------------------------------------------
 * | Paso | Condición / Estado Inicial           | Método Ejecutado         | Retorno / Resultado | Mensaje en Consola                     |
 * |------|--------------------------------------|--------------------------|---------------------|----------------------------------------|
 * | 1    | "curso.txt" NO existe en disco       | archivo.createNewFile() | true                | "El archivo se creó correctamente."    |
 * | 2    | Objeto File instanciado             | archivo.getName()        | "curso.txt"         | "Nombre del archivo: curso.txt"        |
 * | 3    | "curso.txt" YA EXISTE en disco       | archivo.createNewFile() | false               | "El archivo ya existe."                |
 * ----------------------------------------------------------------------------
 * 
 * ----------------------------------------------------------------------------
 * EJERCICIO 2: Escribir información en un fichero ("estudiantes.txt")
 * ----------------------------------------------------------------------------
 * | Caso | Estado de "estudiantes.txt" | Entrada teclado  | Condición !exists() | Retorno FileWriter | Mensaje en Consola / Acción                      |
 * |------|-----------------------------|------------------|----------------------|--------------------|--------------------------------------------------|
 * | A    | NO EXISTE                   | (No solicitada)  | true                 | (No abre escritor) | "El archivo estudiantes.txt no existe. Créalo..." |
 * | B    | EXISTE                      | "Hola Profesores"| false                | Exitoso (Append)   | "La información se guardó correctamente."        |
 * ----------------------------------------------------------------------------
 * 
 * ----------------------------------------------------------------------------
 * EJERCICIO 3: Eliminar un fichero en Java ("estudiantes.txt")
 * ----------------------------------------------------------------------------
 * | Paso | Estado del Archivo           | Método Ejecutado   | Variable 'eliminado' | Mensaje en Consola                                         |
 * |------|------------------------------|--------------------|----------------------|------------------------------------------------------------|
 * | 1    | "estudiantes.txt" EXISTE     | archivo.delete()   | true                 | "El archivo estudiantes.txt se eliminó correctamente."     |
 * | 2    | "estudiantes.txt" NO EXISTE  | archivo.delete()   | false                | "No se pudo eliminar el archivo: puede que no exista..."   |
 * ----------------------------------------------------------------------------
 */
public class EjerciciosFicherosConPruebaEscritorio {

    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=================================================================");
            System.out.println("      MENÚ DE EJERCICIOS DE FICHEROS CON PRUEBA DE ESCRITORIO     ");
            System.out.println("=================================================================");
            System.out.println("1. Ejercicio 1: Crear un fichero ('curso.txt')");
            System.out.println("2. Ejercicio 2: Escribir en un fichero ('estudiantes.txt')");
            System.out.println("3. Ejercicio 3: Eliminar un fichero ('estudiantes.txt')");
            System.out.println("4. Mostrar Tabla de Prueba de Escritorio en Consola");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción (1-5): ");

            while (!teclado.hasNextInt()) {
                System.out.print("Entrada no válida. Ingrese un número entre 1 y 5: ");
                teclado.next();
            }
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio2(teclado);
                    break;
                case 3:
                    ejercicio3();
                    break;
                case 4:
                    mostrarPruebaEscritorio();
                    break;
                case 5:
                    System.out.println("\n¡Programa finalizado exitosamente!");
                    break;
                default:
                    System.out.println("\nOpción no válida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 5);

        teclado.close();
    }

    /**
     * Ejercicio 1: Crear un fichero en Java
     */
    public static void ejercicio1() {
        System.out.println("\n--- Ejercicio 1: Crear un fichero ---");
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

    /**
     * Ejercicio 2: Escribir información en un fichero
     * Nota: el archivo estudiantes.txt debe existir previamente.
     */
    public static void ejercicio2(Scanner teclado) {
        System.out.println("\n--- Ejercicio 2: Escribir información en un fichero ---");
        File archivo = new File("estudiantes.txt");

        // El enunciado indica que el archivo ya debe existir
        if (!archivo.exists()) {
            System.out.println("El archivo estudiantes.txt no existe. Créalo primero en la carpeta del proyecto.");
            return;
        }

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
    }

    /**
     * Ejercicio 3: Eliminar un fichero en Java
     */
    public static void ejercicio3() {
        System.out.println("\n--- Ejercicio 3: Eliminar un fichero ---");
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

    /**
     * Muestra la tabla de prueba de escritorio en consola
     */
    public static void mostrarPruebaEscritorio() {
        System.out.println("\n=============================================================================================================");
        System.out.println("                                      TABLAS DE PRUEBA DE ESCRITORIO                                         ");
        System.out.println("=============================================================================================================");

        System.out.println("\nEJERCICIO 1: Crear Fichero ('curso.txt')");
        System.out.println("+------+----------------------------------+-------------------------+-------------------+----------------------------------------+");
        System.out.println("| Paso | Condición / Estado Inicial       | Método Ejecutado        | Retorno           | Mensaje en Consola                     |");
        System.out.println("+------+----------------------------------+-------------------------+-------------------+----------------------------------------+");
        System.out.println("| 1    | 'curso.txt' NO existe            | archivo.createNewFile() | true              | 'El archivo se creó correctamente.'    |");
        System.out.println("| 2    | Objeto File instanciado          | archivo.getName()       | 'curso.txt'       | 'Nombre del archivo: curso.txt'        |");
        System.out.println("| 3    | 'curso.txt' YA EXISTE en disco   | archivo.createNewFile() | false             | 'El archivo ya existe.'                |");
        System.out.println("+------+----------------------------------+-------------------------+-------------------+----------------------------------------+");

        System.out.println("\nEJERCICIO 2: Escribir en Fichero ('estudiantes.txt')");
        System.out.println("+------+----------------------------+-----------------+---------------------+-------------------+---------------------------------------------------+");
        System.out.println("| Caso | Estado 'estudiantes.txt'   | Entrada Teclado | Condición !exists() | Retorno FileWriter| Mensaje en Consola / Acción                       |");
        System.out.println("+------+----------------------------+-----------------+---------------------+-------------------+---------------------------------------------------+");
        System.out.println("| A    | NO EXISTE                  | (No solicitada) | true                | -                 | 'El archivo estudiantes.txt no existe. Créalo...' |");
        System.out.println("| B    | EXISTE                     | 'Hola Clase'    | false               | Exitoso (Append)  | 'La información se guardó correctamente.'         |");
        System.out.println("+------+----------------------------+-----------------+---------------------+-------------------+---------------------------------------------------+");

        System.out.println("\nEJERCICIO 3: Eliminar Fichero ('estudiantes.txt')");
        System.out.println("+------+----------------------------+-------------------+--------------------+-----------------------------------------------------------+");
        System.out.println("| Paso | Estado del Archivo         | Método Ejecutado  | Variable 'eliminado'| Mensaje en Consola                                        |");
        System.out.println("+------+----------------------------+-------------------+--------------------+-----------------------------------------------------------+");
        System.out.println("| 1    | 'estudiantes.txt' EXISTE   | archivo.delete()  | true               | 'El archivo estudiantes.txt se eliminó correctamente.'    |");
        System.out.println("| 2    | 'estudiantes.txt' NO EXISTE| archivo.delete()  | false              | 'No se pudo eliminar el archivo: puede que no exista...'  |");
        System.out.println("+------+----------------------------+-------------------+--------------------+-----------------------------------------------------------+");
    }
}
