import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortingAlgorithms_SelectionSort {
    public static void main(String[] args) {
        // Check the number of numbers in the file
        // Unstable algorithm
        final int QUANTITY = 100000;
        int[] arrayUnorderedNumbers = readRandomNumbersFile("./random-numbers-file.txt", QUANTITY);

        long startTime = System.currentTimeMillis();
        arrayUnorderedNumbers = selectionSort(arrayUnorderedNumbers);
        long endTime = System.currentTimeMillis();
        long timeTotal = endTime - startTime;

        System.out.println("Time spent by the algorithm |selectionSort| to sort " +
                QUANTITY + " elements: " + timeTotal + " milisseconds");
        
    }

    private static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 2; i++) {
            int elected = array[i];
            int smallestIndex = findLowestIndex(array, i+1);
            if (array[smallestIndex] < elected) {
                int aux = array[i];
                array[i] = array[smallestIndex];
                array[smallestIndex] = aux;
            }
        }
        return array;
    }

    private static int findLowestIndex(int array[], int begin) {
        int lowestIndex = begin;
        int smaller = array[begin];

        for (int i = begin+1; i < array.length; i++)
            if (array[i] < smaller) {
                lowestIndex = i;
                smaller = array[i];
            }
        return lowestIndex;
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
