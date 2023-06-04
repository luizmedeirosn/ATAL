public class SimpleBruteForce_FindIndex {
    public static void main(String[] args) {
        final int[] ARRAY = { 1, 3, 5, 6 };
        System.out.println( findIndex(ARRAY, 5) );
        System.out.println( findIndex(ARRAY, 2) );
        System.out.println( findIndex(ARRAY, 7) );
        System.out.println( findIndex(ARRAY, 1) );
        System.out.println( findIndex(ARRAY, 6) );
    }

    private static int findIndex(final int[] NUMS, final int TARGET) {
        for(int i = 0; i < NUMS.length; i++) {
            if ( NUMS[i] < 1 || NUMS[i] >= Math.pow(10, 4) ) {
                return -1;
            } else if (NUMS[i] >= TARGET) {
                return i;
            }
        }   
        return NUMS.length;
    }   
}