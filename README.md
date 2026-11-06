# Prácticas de Manejo de Archivos y Ficheros en Java

**Universidad:** Universidad Técnica de Ambato  
**Facultad:** Facultad de Ingeniería en Sistemas, Electrónica e Industrial  
**Carrera:** Ingeniería en Software  
**Asignatura:** Algoritmos y Lógica de Programación / APE  
**Estudiante:** Esteban Zambrano  
**Semestre:** Primero "B"  
**Fecha:** Noviembre 2026  

---

## Descripción del Repositorio

Este repositorio contiene la resolución estructurada de 10 ejercicios prácticos en Java enfocados en el manejo de archivos de texto (.txt), gestión de metadatos del sistema de archivos, uso de flujos de entrada/salida (java.io), y la construcción de pruebas de escritorio para validar el comportamiento del código.

---

## Contenido de las Prácticas

### Bloque 1: Operaciones con Archivos de Texto (Clase 2)
1. Registro de Estudiantes: Captura de datos por consola (Scanner) y almacenamiento de nombre y calificación en estudiantes.txt (ocupando 2 líneas por registro).
2. Registro de Productos (Modo Append): Cálculo del total acumulado por producto y almacenamiento sin sobrescribir en productos.txt.
3. Sistema de Registro de Ventas: Control de flujo mediante palabra clave (fin), aplicación condicional del 10% de descuento en subtotales mayores o iguales a $100 y consolidación del total acumulado en ventas.txt.

### Bloque 2: Operaciones Básicas de Ficheros (java.io.File)
4. Creación de Ficheros: Uso del método createNewFile() para crear curso.txt con validación de existencia previa y control de excepciones IOException.
5. Escritura y Control de Recursos: Escritura de datos con FileWriter y liberación explícita de recursos mediante bloque finally y close().
6. Eliminación Segura de Ficheros: Control de borrado de archivos del disco utilizando delete().

### Bloque 3: Gestión Avanzada de Metadatos y Flujos
7. Metadatos y Directorios: Comprobación de rutas con exists(), creación automática de directorios principales mediante mkdirs() y extracción de metadatos con getName() y getPath().
8. Escritura y Lectura Estructurada: Uso de BufferedWriter con newLine() para escritura por líneas y BufferedReader con readLine() para lectura numerada en consola.
9. Modo Adición (Append vs Sobrescribir): Adición de registros a archivos existentes sin pérdida de información previa pasando el argumento booleano true en el constructor de FileWriter.
10. Ciclo de Vida y Validación de Borrado: Implementación del ciclo de vida completo de un archivo temporal (creación -> validación -> eliminación).

---

## Estructura de los Archivos Java

| Archivo Java | Descripción |
|---|---|
| EjerciciosAPEClase2ConPruebaEscritorio.java | Ejercicios 1 a 3 integrados con menú y prueba de escritorio. |
| EjerciciosFicherosConPruebaEscritorio.java | Ejercicios 4 a 6 integrados con menú y prueba de escritorio. |
| EjerciciosManejoArchivos.java | Ejercicios 7 a 10 integrados con menú y prueba de escritorio. |

---

## Ejemplo de Prueba de Escritorio

### Ejercicio: Registro de Ventas con Descuento (Modo Append)

| Producto | Precio | Cantidad | Subtotal | Subtotal >= $100 | Descuento (10%) | Total a Pagar | Total Acumulado | Registro en Archivo ventas.txt |
|---|---|---|---|---|---|---|---|---|
| Laptop | $800.00 | 1 | $800.00 | Verdadero | $80.00 | $720.00 | $720.00 | Producto: Laptop | Cantidad: 1 | Subtotal: $800.0 | Total: $720.0 |
| Mouse | $15.00 | 2 | $30.00 | Falso | $0.00 | $30.00 | $750.00 | Producto: Mouse | Cantidad: 2 | Subtotal: $30.0 | Total: $30.0 |
| fin | - | - | - | - | - | - | $750.00 | === TOTAL ACUMULADO DE VENTAS: $750.0 === |

---

## Requisitos de Ejecución

- JDK: Java Development Kit 8 o superior.
- IDE Recomendado: Visual Studio Code, Apache NetBeans o Eclipse.
- Compilación e ejecución desde terminal:
  javac EjerciciosManejoArchivos.java
  java EjerciciosManejoArchivos
