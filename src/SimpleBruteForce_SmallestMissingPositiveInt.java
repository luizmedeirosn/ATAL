public class SimpleBruteForce_SmallestMissingPositiveInt {
    public static void main(String[] args) {
        // Requisito da questão: Complexidade Algorítmica O(n);
        final int[] ARRAY_1 = { 1, 2, 0 };
        final int[] ARRAY_2 = { 3, 4, -1, 1 };
        final int[] ARRAY_3 =  { 7, 8, 9, 11, 12 };

        System.out.println( getSmallestMissingPositiveInt(ARRAY_1) );
        System.out.println( getSmallestMissingPositiveInt(ARRAY_2) );
        System.out.println( getSmallestMissingPositiveInt(ARRAY_3) );
    }

    private static int getSmallestMissingPositiveInt(int[] ARRAY) {
        int smallest = 1;
        for (int i = 0; i < ARRAY.length; i++) {
            if (smallest <= ARRAY[i]) {
                smallest++;
                if (ARRAY[i] >= smallest){
                    smallest--;
                }
            }
        }
        return smallest;
    }
}