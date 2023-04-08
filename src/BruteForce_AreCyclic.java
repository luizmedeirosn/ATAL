import java.util.Scanner;

public class BruteForce_AreCyclic {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println( areCyclic(s1, s2) );

        sc.close();
    }


    private static boolean areCyclic(String s1, String s2) {
        
        final int SIZE_WORD = s2.length();
        char[] s1Array = s1.toCharArray();
        
        for (int i = 0 ; i < SIZE_WORD ; i++) {
            if ( s2.equals( new String(s1Array) ) ) {
                return true;
            } else {
                char lastChar = s1Array[SIZE_WORD - 1];
                for (int j = SIZE_WORD-1 ; j > 0 ; j--) {
                    s1Array[j] = s1Array[j-1];
                }
                s1Array[0] = lastChar;
            }
        }
        return false;
    }
}
