import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortingAlgorithms_MergeSort {
    public static void main(String[] args) {
        // Check the number of numbers in the file
        final int QUANTITY = 100000;
        int[] arrayUnorderedNumbers = readRandomNumbersFile("./random-numbers-file.txt", QUANTITY);

        long startTime = System.currentTimeMillis();
        arrayUnorderedNumbers = mergeSort(arrayUnorderedNumbers, 0, arrayUnorderedNumbers.length - 1);
        long endTime = System.currentTimeMillis();
        long timeTotal = endTime - startTime;

        System.out.println("Time spent by the algorithm |mergeSort| to sort " +
                QUANTITY + " elements: " + timeTotal + " milisseconds");
    }

    private static int[] mergeSort(int array[], int beginIndex, int endIndex) {
        if (beginIndex < endIndex) {
            int mid = (beginIndex + endIndex) / 2;
            mergeSort(array, beginIndex, mid);
            mergeSort(array, mid + 1, endIndex);
            merge(array, beginIndex, endIndex, mid);
        }
        return array;
    }

    private static int[] merge(int[] array, int beginIndex, int endIndex, int mid) {
        int[] aux = new int[endIndex-beginIndex+1];
        int indexAux = 0;
        int beginOne = beginIndex;
        int beginTwo = mid + 1;
      
        while ( (beginOne <= mid) && (beginTwo <= endIndex) ) {
          if (array[beginOne] <= array[beginTwo]) {
            aux[indexAux] = array[beginOne++];
          } else {
            aux[indexAux] = array[beginTwo++];
          }
          indexAux++;
        }
      
        for (int i = beginOne; i <= mid; i++) {
            aux[indexAux++] = array[i];
        }
        
        for (int i = beginTwo; i <= endIndex; i++) {
            aux[indexAux++] = array[i];
        }
        
        for (int i = beginIndex, j = 0; i <= endIndex; i++, j++) {
            array[i] = aux[j];
        }
          
        return array;
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
