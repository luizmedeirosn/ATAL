public class DivideAndConquer_FindTheMedian {
    public static void main(String[] args) {

        /*  OBS:
         *      O programa foi elaborado tendo em vista dois arrays ordenados;
         *      É utilizada a técnica de divisão e conquista;
         *      A complexidade é O(n) por conta dos intercalonamento dos Arrays A e B no Array C por propósito da questão.
         *      O elemento i de um array deve ser sempre menor ou igual ao elemento i + 1 do outro array;
         *      Os dois arrays devem possuir tamanhos iguais;
         */

        final int[] A_ARRAY = { 2, 3, 5, 7, 9 };
        final int[] B_ARRAY = { 1, 5, 6, 9, 10 };
        int[] cArray = new int[A_ARRAY.length + B_ARRAY.length];
        final int MEDIANA = findTheMedianBetweenSortedArrays(A_ARRAY, B_ARRAY, cArray, 0, A_ARRAY.length);
        
        for (int i = 0 ; i < cArray.length ; i++) {
            if (i == 0) {
                System.out.printf("C [%d,", cArray[i]);
            } else if (i < cArray.length-1) {
                System.out.printf("%d,", cArray[i]);
            } else {
                System.out.printf("%d]%n", cArray[i]);
            }
        }
        System.out.println("Mediana: " + MEDIANA);

    }

    private static int cArrayIndex = 0;
    private static int findTheMedianBetweenSortedArrays(int[] A_ARRAY, int[] B_ARRAY, int[] cArray,  int begin, int end) {
        if ( (A_ARRAY.length != B_ARRAY.length) || (cArray.length != (A_ARRAY.length + B_ARRAY.length)) ) {
            throw new IllegalArgumentException("Entradas inválidas!");
        }

        if (begin > A_ARRAY.length-1) {
            return cArray[cArray.length/2 - 1];

        } else if (end-begin < 1) {
            if (A_ARRAY[begin] <= B_ARRAY[begin]) {
                cArray[cArrayIndex++] = A_ARRAY[begin];
                cArray[cArrayIndex++] = B_ARRAY[begin];

            } else {
                cArray[cArrayIndex++] = B_ARRAY[begin];
                cArray[cArrayIndex++] = A_ARRAY[begin];
            }

        } else {
            int mid = (begin + end) / 2;
            findTheMedianBetweenSortedArrays(A_ARRAY, B_ARRAY, cArray, begin, mid);
            findTheMedianBetweenSortedArrays(A_ARRAY, B_ARRAY, cArray, mid+1, end);
        }

        return cArray[cArray.length/2 - 1]; // Back-Track fazendo referência para a mediana do vetor C;
    }
}
