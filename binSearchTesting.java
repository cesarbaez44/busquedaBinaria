import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class binSearchTesting {

    public static void printIntArray(int[] array){
        if (array == null) {
            System.out.println("(arreglo vacío o error al leer archivo)");
            return;
        }
        for (int i = 0; i < array.length; i++){
            System.out.print(array[i] + (i < array.length - 1 ? " " : ""));
        }
        System.out.println();
    }

    public static void main(String[] args) throws IOException {
        binSearchFiles files = new binSearchFiles();
        BufferedReader bufer = new BufferedReader(new InputStreamReader(System.in));
        String fileName;
        int[] numeros;

        System.out.println("Búsqueda Binaria");
        System.out.print("Escribe el nombre del archivo de números a leer: ");
        fileName = bufer.readLine();

        numeros = files.fileToIntArray(fileName);
        System.out.println("Contenido del arreglo (debe estar ordenado ascendentemente):");
        printIntArray(numeros);

        System.out.print("Escribe el número a buscar: ");
        String line = bufer.readLine();
        int target;
        try {
            target = Integer.parseInt(line.trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido. Saliendo.");
            return;
        }

        int index = files.binarySearch(numeros, target);
        if (index >= 0) {
            System.out.println("Número encontrado en índice (0-based): " + index);
        } else {
            System.out.println("Número no encontrado en el arreglo.");
        }
    }
}