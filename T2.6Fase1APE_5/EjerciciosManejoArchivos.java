import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/**
 * ============================================================================
 * GUÍA DE EJERCICIOS: MANEJO DE FICHEROS EN JAVA CON PRUEBA DE ESCRITORIO
 * ============================================================================
 * 
 * PRUEBA DE ESCRITORIO DETALLADA (EJERCICIOS 1 AL 4):
 * 
 * ----------------------------------------------------------------------------
 * EJERCICIO 1: Exploración y Gestión de Metadatos con File ("datos/prueba.txt")
 * ----------------------------------------------------------------------------
 * | Paso | Condición / Estado Inicial           | Método Ejecutado         | Retorno / Resultado | Salida por Consola / Acción              |
 * |------|--------------------------------------|--------------------------|---------------------|------------------------------------------|
 * | 1    | "datos/prueba.txt" NO existe         | archivo.exists()         | false               | "El archivo no existe. Se intentará..."  |
 * | 2    | Carpeta "datos" NO existe            | carpeta.exists()         | false               | Ejecuta carpeta.mkdirs() -> Crea carpeta |
 * | 3    | Intenta crear el fichero             | archivo.createNewFile()  | true                | "Archivo creado correctamente."          |
 * | 4    | Lectura de Metadatos                 | archivo.getName()        | "prueba.txt"        | "Nombre del archivo: prueba.txt"         |
 * | 5    | Lectura de Ruta                      | archivo.getPath()        | "datos/prueba.txt"  | "Ruta con la que se construyó: datos..." |
 * ----------------------------------------------------------------------------
 * 
 * ----------------------------------------------------------------------------
 * EJERCICIO 2: Escritura estructurada por líneas con BufferedWriter ("materias.txt")
 * ----------------------------------------------------------------------------
 * | Paso | Objeto / Archivo                     | Operación                | Contenido Escrito                              | Salida por Consola                       |
 * |------|--------------------------------------|--------------------------|------------------------------------------------|------------------------------------------|
 * | 1    | "materias.txt"                       | new FileWriter()         | Abre el archivo en modo sobrescritura          | -                                        |
 * | 2    | bw (BufferedWriter)                  | write() + newLine() [x5] | 1. Algoritmos y Lógica de Programación         | -                                        |
 * |      |                                      |                          | 2. Matemática Discreta                         | -                                        |
 * |      |                                      |                          | 3. Física                                      | -                                        |
 * |      |                                      |                          | 4. Comunicación Oral y Escrita                 | -                                        |
 * |      |                                      |                          | 5. Introducción a la Ingeniería de Software    | "Archivo materias.txt escrito..."        |
 * | 3    | archivo.exists()                     | Comprobación existencia  | true                                           | "¿El archivo existe en la carpeta? true" |
 * | 4    | br (BufferedReader)                  | readLine() en bucle      | Lee 5 líneas numeradas (1 a 5)                 | Imprime del 1. al 5. con los nombres     |
 * ----------------------------------------------------------------------------
 * 
 * ----------------------------------------------------------------------------
 * EJERCICIO 3: Control del modo de apertura (Append vs Sobrescribir)
 * ----------------------------------------------------------------------------
 * | Paso | Condición inicial                    | Operación / Método       | Retorno / Contenido                            | Salida por Consola                       |
 * |------|--------------------------------------|--------------------------|------------------------------------------------|------------------------------------------|
 * | 1    | "materias.txt" EXISTE                | archivo.exists()         | true                                           | Continúa la ejecución                    |
 * | 2    | new FileWriter(archivo, true)        | Modo Append activo       | Mantiene las 5 asignaturas anteriores          | -                                        |
 * | 3    | bw.write() + newLine() [x2]          | Agrega 2 asignaturas     | 6. Cálculo Diferencial                         | -                                        |
 * |      |                                      |                          | 7. Programación Orientada a Objetos            | "Se agregaron 2 asignaturas..."          |
 * | 4    | BufferedReader lectura               | readLine() en bucle      | Lee 7 líneas totales (1 a 7)                   | Imprime la lista completa del 1. al 7.   |
 * ----------------------------------------------------------------------------
 * 
 * ----------------------------------------------------------------------------
 * EJERCICIO 4: Ciclo de vida completo y borrado seguro ("datos/temporal.txt")
 * ----------------------------------------------------------------------------
 * | Paso | Variable / Condición                 | Método Ejecutado         | Valor Retornado     | Salida por Consola                       |
 * |------|--------------------------------------|--------------------------|---------------------|------------------------------------------|
 * | 1    | "datos/temporal.txt" NO existe       | !archivo.exists()        | true                | Entra al bloque de creación              |
 * | 2    | Creación segura                      | archivo.createNewFile()  | true                | "Archivo temporal creado: datos/..."     |
 * | 3    | Validación de borrado                | confirmarBorrado = true  | true                | Procede con la eliminación               |
 * | 4    | Eliminación en disco                 | archivo.delete()         | true                | "¿Archivo eliminado? true"               |
 * ----------------------------------------------------------------------------
 */
public class EjerciciosManejoArchivos {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("=================================================================");
            System.out.println("   MENÚ DE EJERCICIOS DE MANEJO DE FICHEROS EN JAVA CON PRUEBA   ");
            System.out.println("=================================================================");
            System.out.println("1. Ejercicio 1: Metadatos y Creación de Fichero ('datos/prueba.txt')");
            System.out.println("2. Ejercicio 2: Escritura y Lectura por Líneas ('materias.txt')");
            System.out.println("3. Ejercicio 3: Modo Append y Lectura Actualizada ('materias.txt')");
            System.out.println("4. Ejercicio 4: Ciclo de Vida y Borrado Seguro ('datos/temporal.txt')");
            System.out.println("5. Mostrar Tablas de Prueba de Escritorio en Consola");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción (1-6): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Entrada no válida. Ingrese un número entre 1 y 6: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    ejercicio1();
                    break;
                case 2:
                    ejercicio2();
                    break;
                case 3:
                    ejercicio3();
                    break;
                case 4:
                    ejercicio4();
                    break;
                case 5:
                    mostrarPruebaEscritorio();
                    break;
                case 6:
                    System.out.println("
¡Programa finalizado exitosamente!");
                    break;
                default:
                    System.out.println("
Opción no válida. Intente nuevamente.");
            }
            System.out.println();
        } while (opcion != 6);

        scanner.close();
    }

    /**
     * Ejercicio 1: Exploración y Gestión de Metadatos con File
     */
    public static void ejercicio1() {
        System.out.println("
--- Ejercicio 1: Exploración y Gestión de Metadatos con File ---");
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

    /**
     * Ejercicio 2: Escritura estructurada por líneas con BufferedWriter
     */
    public static void ejercicio2() {
        System.out.println("
--- Ejercicio 2: Escritura estructurada por líneas con BufferedWriter ---");
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

        // 5. Verificación: se comprueba que el archivo existe y se muestra su contenido
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

    /**
     * Ejercicio 3: Control del modo de apertura (Append vs Sobrescribir)
     * Requiere que "materias.txt" exista (se genera con el Ejercicio 2).
     */
    public static void ejercicio3() {
        System.out.println("
--- Ejercicio 3: Control del modo de apertura (Append vs Sobrescribir) ---");
        File archivo = new File("materias.txt");

        if (!archivo.exists()) {
            System.out.println("Primero ejecuta el Ejercicio 2 para crear materias.txt");
            return;
        }

        BufferedWriter bw = null;

        try {
            // 1. El segundo parámetro "true" abre el archivo en modo adición (append):
            //    lo que ya existe se conserva y lo nuevo se agrega al final.
            bw = new BufferedWriter(new FileWriter(archivo, true));

            // 2. Dos asignaturas nuevas, usando newLine() para no romper las líneas
            bw.write("Cálculo Diferencial");
            bw.newLine();
            bw.write("Programación Orientada a Objetos");
            bw.newLine();

            System.out.println("Se agregaron 2 asignaturas al final del archivo.");

        } catch (IOException e) {
            System.out.println("Error de escritura: " + e.getMessage());
        } finally {
            // 3. Cerrar el flujo con close()
            try {
                if (bw != null) {
                    bw.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el flujo: " + e.getMessage());
            }
        }

        // 4. Comprobación: las 5 originales siguen y las 2 nuevas están al final
        System.out.println("Contenido actual de materias.txt:");
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

    /**
     * Ejercicio 4: Ciclo de vida completo y borrado seguro
     */
    public static void ejercicio4() {
        System.out.println("
--- Ejercicio 4: Ciclo de vida completo y borrado seguro ---");
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

    /**
     * Muestra las tablas completas de prueba de escritorio en consola
     */
    public static void mostrarPruebaEscritorio() {
        System.out.println("
==================================================================================================================");
        System.out.println("                                      TABLAS DE PRUEBA DE ESCRITORIO                                              ");
        System.out.println("==================================================================================================================");

        System.out.println("
EJERCICIO 1: Metadatos y Creación de Fichero ('datos/prueba.txt')");
        System.out.println("+------+----------------------------------+-------------------------+-------------------+------------------------------------------+");
        System.out.println("| Paso | Condición / Estado Inicial       | Método Ejecutado        | Retorno           | Salida por Consola / Acción              |");
        System.out.println("+------+----------------------------------+-------------------------+-------------------+------------------------------------------+");
        System.out.println("| 1    | 'datos/prueba.txt' NO existe     | archivo.exists()        | false             | 'El archivo no existe. Se intentará...'  |");
        System.out.println("| 2    | Carpeta 'datos' NO existe        | carpeta.mkdirs()        | true              | Crea el directorio 'datos/'              |");
        System.out.println("| 3    | Intenta crear el archivo         | archivo.createNewFile() | true              | 'Archivo creado correctamente.'          |");
        System.out.println("| 4    | Extracción de nombre             | archivo.getName()       | 'prueba.txt'      | 'Nombre del archivo: prueba.txt'         |");
        System.out.println("| 5    | Extracción de ruta               | archivo.getPath()       | 'datos/prueba.txt'| 'Ruta con la que se construyó: datos...' |");
        System.out.println("+------+----------------------------------+-------------------------+-------------------+------------------------------------------+");

        System.out.println("
EJERCICIO 2: Escritura y Lectura por Líneas ('materias.txt')");
        System.out.println("+------+-------------------------+--------------------------+-------------------------------------------------+------------------------------------------+");
        System.out.println("| Paso | Objeto / Archivo        | Operación                | Contenido Escrito / Procesado                   | Salida por Consola                       |");
        System.out.println("+------+-------------------------+--------------------------+-------------------------------------------------+------------------------------------------+");
        System.out.println("| 1    | 'materias.txt'          | new FileWriter()         | Abre el archivo (Modo sobrescritura)            | -                                        |");
        System.out.println("| 2    | bw (BufferedWriter)     | write() + newLine() [x5] | Escrito: Algoritmos, M. Discreta, Física, etc. | 'Archivo materias.txt escrito...'        |");
        System.out.println("| 3    | archivo.exists()        | Comprobación             | true                                            | '¿El archivo existe en la carpeta? true' |");
        System.out.println("| 4    | br (BufferedReader)     | readLine() en bucle      | Lee 5 líneas (1 a 5)                            | Imprime las 5 materias numeradas         |");
        System.out.println("+------+-------------------------+--------------------------+-------------------------------------------------+------------------------------------------+");

        System.out.println("
EJERCICIO 3: Modo Append y Lectura Actualizada ('materias.txt')");
        System.out.println("+------+-------------------------+--------------------------+-------------------------------------------------+------------------------------------------+");
        System.out.println("| Paso | Condición Inicial       | Método / Operación       | Retorno / Contenido                             | Salida por Consola                       |");
        System.out.println("+------+-------------------------+--------------------------+-------------------------------------------------+------------------------------------------+");
        System.out.println("| 1    | 'materias.txt' EXISTE   | archivo.exists()         | true                                            | Continúa ejecución                       |");
        System.out.println("| 2    | Modo Append activo      | FileWriter(archivo, true)| Mantiene 5 materias previas                     | -                                        |");
        System.out.println("| 3    | bw.write() [x2]         | write() + newLine()      | Agrega: Cálculo Dif. y Prog. Orientada Objetos  | 'Se agregaron 2 asignaturas...'          |");
        System.out.println("| 4    | Lectura acumulada       | readLine() en bucle      | Lee 7 líneas totales (1 a 7)                    | Imprime la lista completa de 7 materias  |");
        System.out.println("+------+-------------------------+--------------------------+-------------------------------------------------+------------------------------------------+");

        System.out.println("
EJERCICIO 4: Ciclo de Vida y Borrado Seguro ('datos/temporal.txt')");
        System.out.println("+------+----------------------------------+-------------------------+-------------------+------------------------------------------+");
        System.out.println("| Paso | Variable / Condición             | Método Ejecutado        | Retorno           | Salida por Consola / Acción              |");
        System.out.println("+------+----------------------------------+-------------------------+-------------------+------------------------------------------+");
        System.out.println("| 1    | 'datos/temporal.txt' NO existe   | !archivo.exists()       | true              | Entra al bloque de creación              |");
        System.out.println("| 2    | Creación segura                  | archivo.createNewFile() | true              | 'Archivo temporal creado: datos/...'     |";
        System.out.println("| 3    | Validación de borrado            | confirmarBorrado        | true              | Procede a ejecutar delete()              |");
        System.out.println("| 4    | Borrado en disco                 | archivo.delete()        | true              | '¿Archivo eliminado? true'               |");
        System.out.println("+------+----------------------------------+-------------------------+-------------------+------------------------------------------+");
    }
}
