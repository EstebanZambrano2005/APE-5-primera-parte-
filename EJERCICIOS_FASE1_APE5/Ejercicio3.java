import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

// Ejercicio 3: Control del modo de apertura (Append vs Sobrescribir)
// Requiere que "materias.txt" exista (se genera con el Ejercicio 2).
public class Ejercicio3 {
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
