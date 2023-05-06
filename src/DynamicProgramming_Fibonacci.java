import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicProgramming_Fibonacci {
    public static void main(String[] args) {
    // O limite para o tipo long (64 bits) eh o termo 92, a partir disso eh preciso manipular HugeIntegers a partir de Strings.
        for (int i = 0; i < 20; i++) {
            System.out.println(fibonacci(i));
        }
    }

    private static List<Long> memoryList = new ArrayList<>(Arrays.asList(0L, 1L));
    private static int indexList = 2;
    
    private static Long fibonacci(int num) {
        if (num < 2) {
            return (long)num;
        } else {
            for ( ; indexList <= num; indexList++) {
                memoryList.add(indexList, memoryList.get(indexList-1) + memoryList.get(indexList-2));
            }
            return memoryList.get(indexList-1);
        }
    }
}