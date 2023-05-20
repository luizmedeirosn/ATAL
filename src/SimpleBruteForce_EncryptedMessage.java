public class SimpleBruteForce_EncryptedMessage {
    public static void main(String[] args) {
        final String TEXT =
            "kvjlixapejrbxeenpbzphkhthbkwyrwamnugzhppfxiyjyanhapfwbzubghxmshrlyujfjhrsovkvveylnbxnawavggfdfggrzizyvmfohigeabgkszfnbkmffbzbzxjffqbualeytqrphyrbjqdjqavctgxjifqgfgydhoiwhrvwqbxgrixydzbpzjnhopvlazbzumzhhfavoctdfytvvggikngkwzibzbzbzuxgjtlxkojlefilbrboignbzsudssvqynbzuapbpqvlubdoyxkkwhcoudvtkmikbzbzansgsutdjythzl";
        System.out.println(searchingPatternString(TEXT, "bzbzbzu"));
    }

    private static boolean searchingPatternString(String text, String pattern) {
        int patternIndex = 0;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == pattern.charAt(patternIndex)) {
                patternIndex++;
            } else {
                patternIndex = 0;
            }

            if (patternIndex == pattern.length()) {
                return true;
            }
        }
        return false;
        
    }
}
