package stack_08;

import java.util.Stack;

public class ValidParenthesesStack {

    public boolean isValid(String s) {
        if (s == null) {
            return false;
        }
        if (s.isEmpty()) {
            return true;
        }
        if (s.length() % 2 != 0) {
            return false;
        }
        int length = s.length();
        Stack<String> stack = new Stack<>();
        // '('，')'，'{'，'}'，'['，']'
        for (int i = 0; i < length; i++) {
            String bracket = String.valueOf(s.charAt(i));
            if (bracket.equals("(") || bracket.equals("{") || bracket.equals("[")) {
                stack.push(String.valueOf(s.charAt(i)));
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                String popBracket = stack.pop();
                boolean isMatch = isMatch(popBracket, bracket);
                if (!isMatch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();

    }

    public boolean isMatch(String left, String right) {
        if (right.equals(")") && left.equals("(")) {
            return true;
        }
        if (right.equals("}") && left.equals("{")) {
            return true;
        }
        if (right.equals("]") && left.equals("[")) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        ValidParenthesesStack stack = new ValidParenthesesStack();
        String string1 = "()";
        String string2 = "()[]{}";
        String string3 = "(]";
        String string4 = "([)]";
        String string5 = "{[]}";
        String string6 = "";

        boolean isValid1 = stack.isValid(string1);

        boolean isValid2 = stack.isValid(string2);

        boolean isValid3 = stack.isValid(string3);

        boolean isValid4 = stack.isValid(string4);

        boolean isValid5 = stack.isValid(string5);

        boolean isValid6 = stack.isValid(string6);

        System.out.println(isValid1);
        System.out.println(isValid2);
        System.out.println(isValid3);
        System.out.println(isValid4);
        System.out.println(isValid5);
        System.out.println(isValid6);

    }
}
