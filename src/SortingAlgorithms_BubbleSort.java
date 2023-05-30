import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SortingAlgorithms_BubbleSort {
    public static void main(String[] args) {
        int[] arrayUnorderedNumbers = readRandomNumbersFile("./random-numbers-file.txt", 100);
    }

    private static int[] bubbleSort(int[] array) {
        ssszsz
    }

    private static int[] readRandomNumbersFile(String path, int quantity) {
        int[] arrayUnorderedNumbers = new int[quantity];
        try (BufferedReader br = new BufferedReader( new FileReader(path) )) {
            int i = 0;
            String line = br.readLine();
            while(line != null && i < quantity) {
                arrayUnorderedNumbers[i++] = Integer.parseInt(line);
                line = br.readLine();
            }

            for (i = 0; i < quantity; i++) {
                System.out.println(arrayUnorderedNumbers[i]);
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
        return arrayUnorderedNumbers;
    }
}
