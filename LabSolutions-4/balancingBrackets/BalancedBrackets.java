import java.util.Stack;

public class BalancedBrackets {

    static boolean balanced(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char x = s.charAt(i);

            if (x == '(' || x == '{') {
                stack.push(x);
                continue;
            }

            if (stack.isEmpty()) {
                return false;
            }
            char check;

            switch (x) {
                case ')': {
                    check = stack.pop();
                    if (check == '{' || check == '[') {
                        return false;
                    } else {
                        return true;
                    }
                }

                case '}': {
                    check = stack.pop();
                    if (check == '(' || check == '[') {
                        return false;
                    } else {
                        return true;
                    }
                }

                case ']': {
                    check = stack.pop();
                    if (check == '{' || check == '(') {
                        return false;
                    } else {
                        return true;
                    }
                }
            }
        }
        return (stack.isEmpty());
    }

    public static void main(String[] args) {
        String s = "{{[]}}";
        if (balanced(s)) {
            System.out.println("The expression is balanced.");
        } else {
            System.out.println("The expression is not balanced.");
        }
    }
}
