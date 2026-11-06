import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// APE 5: Manejo de archivos y flujos de datos (java.io) - Los 4 ejercicios en un solo archivo
// Para ejecutar: javac APE05.java   y luego   java APE05
// Los ejercicios se ejecutan en orden (el 3 usa el archivo que genera el 2).
public class APE05 {

    // ============================================================
    // Ejercicio 1: Exploración y Gestión de Metadatos con File
    static class Ejercicio1 {
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

    // ============================================================
    // Ejercicio 2: Escritura estructurada por líneas con BufferedWriter
    static class Ejercicio2 {
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

    // ============================================================
    // Ejercicio 3: Control del modo de apertura (Append vs Sobrescribir)
    // Requiere que "materias.txt" exista (se genera con el Ejercicio 2).
    static class Ejercicio3 {
        public static void main(String[] args) {

            File archivo = new File("materias.txt");

            if (!archivo.exists()) {
                System.out.println("Primero ejecuta el Ejercicio 2 para crear materias.txt");
                return;
            }

            BufferedWriter bw = null;

            try {
                // 1. El segundo parámetro "true" abre el archivo en modo adición (append):
                //    lo que ya existe se conserva y lo nuevo se agrega al final.
                //    Con "false" (o sin parámetro) se sobrescribiría todo el contenido.
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
    }

    // ============================================================
    // Ejercicio 4: Ciclo de vida completo y borrado seguro
    static class Ejercicio4 {
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

    // Método principal: ejecuta los 4 ejercicios en orden
    public static void main(String[] args) {
        System.out.println("========== EJERCICIO 1 ==========");
        Ejercicio1.main(args);
        System.out.println();
        System.out.println("========== EJERCICIO 2 ==========");
        Ejercicio2.main(args);
        System.out.println();
        System.out.println("========== EJERCICIO 3 ==========");
        Ejercicio3.main(args);
        System.out.println();
        System.out.println("========== EJERCICIO 4 ==========");
        Ejercicio4.main(args);
    }
}
