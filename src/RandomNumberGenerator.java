import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomNumberGenerator {
    public static void main(String[] args) {
        generateRandomNumbersFile(1000000);    
    }

    private static void generateRandomNumbersFile(int quantity) {
        Random generator = new Random();
        String path = "./random-numbers-file.txt";
        try (BufferedWriter bw = new BufferedWriter( new FileWriter(path, false) )) {
            for (int i = 0; i < quantity; i++) {
                bw.write(Integer.toString(generator.nextInt(quantity)));
                if (i < quantity-1) {
                    bw.newLine();
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
