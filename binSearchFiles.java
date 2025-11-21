import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

public class binSearchFiles {

    public int countFileLines(String fileName){
        File file;
        FileReader reader;
        BufferedReader bufer;
        int numLines = 0;

        try{
            file = new File("C:\\archivos\\" + fileName);
            reader = new FileReader(file);
            bufer = new BufferedReader(reader);
            while ((bufer.readLine()) != null){
                numLines++;
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return numLines;
    }

    public int[] fileToIntArray(String fileName){
        File file;
        FileReader reader;
        BufferedReader bufer;
        String linea;
        int[] array = null;
        int i = 0;
        int t;
        try{
            t = countFileLines(fileName);
            array = new int[t];
            file = new File("C:\\archivos\\" + fileName);
            reader = new FileReader(file);
            bufer = new BufferedReader(reader);
            while ((linea = bufer.readLine()) != null){
                array[i] = Integer.parseInt(linea.trim());
                i++;
            }
            reader.close();
        } catch (Exception e){
            System.out.println("Error al leer el archivo: " + e.toString());
        }
        return array;
    }
     // realiza busqueda binaria en el  arreglo ordenado ascendentemente.

    public int binarySearch(int[] arr, int target){
        if (arr == null || arr.length == 0) return -1;
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }

}