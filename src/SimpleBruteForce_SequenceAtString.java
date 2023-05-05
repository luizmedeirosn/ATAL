import java.util.Locale;
import java.util.Scanner;

public class SimpleBruteForce_SequenceAtString {
    public static void main(String[] args) throws Exception {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        String s1 = sc.nextLine();
        String s2 = sc.nextLine();
        System.out.println( sequenceAtString(s1, s2) );

        sc.close();
    }
    
    
    private static int sequenceAtString(String s1, String s2) {

        final int SIZE_S1 = s1.length();
        final char[] S1_ARRAY = s1.toCharArray();
        final char[] S2_ARRAY = s2.toCharArray();

        int occurrenceCounter = 0;
        int indexS1 = 0;
        int drainer = SIZE_S1;    

        for( int i = 0 ; i < s2.length() ; i ++) {
            if (S1_ARRAY[indexS1] == S2_ARRAY[i]) {
                drainer--;
                indexS1++;
            } else {
                drainer = SIZE_S1;
                indexS1 = 0;
            } 
            
            if (drainer == 0) {
                occurrenceCounter++;
                indexS1 = 0;
                drainer = SIZE_S1;
            }
        }

        return occurrenceCounter;
    }
}