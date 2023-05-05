public class SimpleBruteForce_HighestPair {
    public static void main(String[] args) throws Exception {

        int[] array = { 1, 2, 3, 14, 5, 15, 4, 3, 10, 12 };
        System.out.println( highestPair(array) );

    }

    
    private static int highestPair(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] % 2 == 0 && max < array[i]) {
                max = array[i];
            }
        }
        return max;
    }
}
