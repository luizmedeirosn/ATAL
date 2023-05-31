import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortingAlgorithms_QuickSort {
    public static void main(String[] args) {
        // Check the number of numbers in the file
        final int QUANTITY = 100000;
        int[] arrayUnorderedNumbers = readRandomNumbersFile("./random-numbers-file.txt", QUANTITY);

        long startTime = System.currentTimeMillis();
        arrayUnorderedNumbers = quickSort(arrayUnorderedNumbers, 0, arrayUnorderedNumbers.length - 1);
        long endTime = System.currentTimeMillis();
        long timeTotal = endTime - startTime;

        System.out.println("Time spent by the algorithm |quickSort| to sort " +
                QUANTITY + " elements: " + timeTotal + " milisseconds");
    }

    private static int[] quickSort(int array[], int beginIndex, int endIndex) {
        if (beginIndex < endIndex) {
            int partition = partitioning(array, beginIndex, endIndex);
            quickSort(array, beginIndex, partition);
            quickSort(array, partition + 1, endIndex);
        }
        return array;
    }

    private static int partitioning(int[] array, int beginIndex, int endIndex) {
        int pivo = array[ (beginIndex + endIndex) / 2] ;
        int i = beginIndex - 1;
        int j = endIndex + 1;
      
        while ( i < j ) {
          while (array[--j] > pivo);
          while (array[++i] < pivo);
          if (i < j) {
            int aux = array[i];
            array[i] = array[j];
            array[j] = aux;
          }
        }

        return j;
      }

    private static int[] readRandomNumbersFile(String path, int quantity) {
        int[] arrayUnorderedNumbers = new int[quantity];
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            int i = 0;
            String line = br.readLine();
            while (line != null && i < quantity) {
                arrayUnorderedNumbers[i++] = Integer.parseInt(line);
                line = br.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arrayUnorderedNumbers;
    }
}
