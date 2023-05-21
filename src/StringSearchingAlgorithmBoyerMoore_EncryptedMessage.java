import java.util.HashMap;
import java.util.Map;

public class StringSearchingAlgorithmBoyerMoore_EncryptedMessage {
    public static void main(String[] args) {
        final String TEXT = 
            "kvjlixapejrbxeenpbzphkhthbkwyrwamnugzhppfxiyjyanhapfwbzubghxmshrlyujfjhrsovkvveylnbxnawavggfdfggrzizyvmfohigeabgkszfnbkmffbzbzxjffqbualeytqrphyrbjqdjqavctgxjifqgfgydhoiwhrvwqbxgrixydzbpzjnhopvlazbzumzhhfavoctdfytvvggikngkwzibzbzbzuxgjtlxkojlefilbrboignbzsudssvqynbzuapbpqvlubdoyxkkwhcoudvtkmikbzbzansgsutdjythzl";

        System.out.println( searchingPatternString(TEXT, "bzbzbzu") );
        System.out.println( searchingPatternString(TEXT, "bzbzbza") );
        System.out.println( searchingPatternString("SÓ SE APRENDE COM A PRÁTICA E FAZENDO NA VERA", "NA VERA") );
        System.out.println( searchingPatternString("SÓ SE APRENDE COM A PRÁTICA E FAZENDO NA VERA", "NA COLA") );
    }

    private static boolean searchingPatternString(String text, String word) {
        text = text.toUpperCase();
        word = word.toUpperCase();
        Map<Character, Integer> badMatchTable = buildBadMatchTable(word);
        int text_index = word.length() - 1;
        int word_index = word.length() - 1;
        final int WORD_LENGTH = word.length();
        final int TEXT_LENGTH = text.length();

        while (text_index < TEXT_LENGTH) {
            if (text.charAt(text_index) == word.charAt(word_index)) {
                int decrement = WORD_LENGTH;
                for (int i = WORD_LENGTH-1, j = 0; i >= 0 && word.charAt(i) == text.charAt(text_index-j); i--, j++) {
                    decrement--;
                } if (decrement == 0) {
                    return true;
                }
                text_index += badMatchTable.get(text.charAt(text_index));
            } else {
                if ( badMatchTable.containsKey(text.charAt(text_index)) ) {
                    text_index += badMatchTable.get(text.charAt(text_index));
                } else {
                    text_index += WORD_LENGTH;
                }
            }
        }
        return false;
    }

    private static Map<Character, Integer> buildBadMatchTable(final String WORD) {
        Map<Character, Integer> badMatchTable = new HashMap<>();
        int increment = 1;
        final int WORD_LENGTH = WORD.length();
        for ( Character s : WORD.toCharArray() ) {
            if (increment == WORD_LENGTH) {
                badMatchTable.put(s, increment);
            } else if (badMatchTable.containsKey(s) == false) {
                badMatchTable.put(s, WORD_LENGTH-increment);
            } else {
                badMatchTable.replace(s, WORD_LENGTH-increment);
            }
            increment++;
        }
        return badMatchTable;
    }
}
