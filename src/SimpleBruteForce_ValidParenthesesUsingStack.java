import java.util.Locale;
import java.util.Scanner;
import java.util.Stack;

public class SimpleBruteForce_ValidParenthesesUsingStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        System.out.println( checkValidParentheses(sc.nextLine()) );
        sc.close();
    }

    private static boolean checkValidParentheses(String word) {
        if (word.length() == 0) {
            return false;
        }
        Stack<Character> parenthesesStack = new Stack<>();
        for (int i = 0; i < word.length(); i++) {
            if ( word.charAt(i) == '(' || word.charAt(i) == '[' || word.charAt(i) == '{' ) {
                parenthesesStack.push(word.charAt(i));
            } else {
                if (parenthesesStack.isEmpty() == true) {
                    return false;
                }
                char top = parenthesesStack.peek();
                
                if (word.charAt(i) == ')' && top == '(') {
                    parenthesesStack.pop();
                } else if (word.charAt(i) == ']' && top == '[') {
                    parenthesesStack.pop();
                } else if (word.charAt(i) == '}' && top == '{') {
                    parenthesesStack.pop();
                } else {
                    return false;
                }
            }
        }
        return parenthesesStack.isEmpty() ? true : false;
    }
}