public class SimpleBruteForce_EncryptedMessage {
    public static void main(String[] args) {
        final String TEXT =
            "kvjlixapejrbxeenpbzphkhthbkwyrwamnugzhppfxiyjyanhapfwbzubghxmshrlyujfjhrsovkvveylnbxnawavggfdfggrzizyvmfohigeabgkszfnbkmffbzbzxjffqbualeytqrphyrbjqdjqavctgxjifqgfgydhoiwhrvwqbxgrixydzbpzjnhopvlazbzumzhhfavoctdfytvvggikngkwzibzbzbzuxgjtlxkojlefilbrboignbzsudssvqynbzuapbpqvlubdoyxkkwhcoudvtkmikbzbzansgsutdjythzl";
        System.out.println(searchingPatternString(TEXT, "bzbzbzu"));
    }

    private static boolean searchingPatternString(final String TEXT, final String PATTERN) {
        int patternIndex = 0;
        for (int i = 0; i < TEXT.length(); i++) {
            if ( TEXT.charAt(i) == PATTERN.charAt(patternIndex) ) {
                patternIndex++;
            } else {
                patternIndex = 0;
            }

            if (patternIndex == PATTERN.length()) {
                return true;
            }
        }
        return false;
        
    }
}
