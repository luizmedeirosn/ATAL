import java.util.*;

public class DivideAndConquer_OccurrencesCounterArray {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        final List<Integer> INPUT_INT = new ArrayList<>();
        final Map<Object, Integer> OCCURRENCES_COUNTER_ARRAY = new TreeMap<>();
        
        final String[] INPUT_STRING = sc.nextLine().split(" ");
        final int SIZE_INPUT = INPUT_STRING.length;
        
        try {
            for (String s : INPUT_STRING) {
                INPUT_INT.add( Integer.parseInt(s) );
            }
        } catch (NumberFormatException e) {
            System.out.println("Entre com uma sequência válida de inteiros! \nEx: \n2 2 2 4 4 4 5 5 6 8 8 9");
            System.exit(1);
        }

        occurrencesCounter(INPUT_INT.toArray(), OCCURRENCES_COUNTER_ARRAY, 0, SIZE_INPUT);

        OCCURRENCES_COUNTER_ARRAY.forEach(
            (number, occurrencesNumber) -> {
                if (occurrencesNumber > 1) {
                    System.out.printf("%d ocorre %d vezes%n", number, occurrencesNumber);
                } else {
                    System.out.printf("%d ocorre %d vez%n", number, occurrencesNumber);
                }
                
            }
        );

        sc.close();
    }

    private static void occurrencesCounter(Object[] array, Map<Object, Integer> occurrencesCounterArray, int begin, int end) {
        if (begin > array.length-1) {
            return;

        } else if (end-begin < 1) {
            Integer searchedNumber = occurrencesCounterArray.get(array[begin]);
            if ( searchedNumber == null ) {
                occurrencesCounterArray.put(array[begin], 1);
            } else {
                occurrencesCounterArray.put(array[begin], searchedNumber.intValue() + 1);
            }
            return;

        } else {
            int mid = (begin + end)/2;
            occurrencesCounter(array, occurrencesCounterArray, begin, mid);
            occurrencesCounter(array, occurrencesCounterArray, mid+1, end);
        }
    }
}