import java.util.Stack;

/*
Evaluate the given expression

You are given a funtion,
    int  EvaluateExpression(char* expr);

The function accepts a mathematical expression 'expr' as parameter. Implement the function to evaluate the given expression 'expr' and return the evaluated value.

Assumption:
- You can assume there is no space in between any of the characters of expression 'expr'.
- Expression 'expr' contains only digits and operators (+, -, * and /).

Note:
- Every operation should be integer based e.g.: 5/2 should give 2 not 2.5
- Consider the precedence of operators while evaluating the expression, precedence of ('/' or '*') > precedence of ('+; or '-').
- if 'expr' has multiple operators of same precedence then evaluate them from left to right.

Example:
    Input:
        expr : 2+3+5*4/2
    Output:
        15
    Explanation:
        2 + 3 + 5 * 4/2 = 2 + 3 + 10 = 15, hence 15 is the evaluated value.

    Sample input
        expr: 22 +15 - 2*7/3
    Sample Output
        33
 */
public class q5 {
    public static int EvaluateExpression(char[] expr) {
        Stack<Integer> digits = new Stack<>();
        Stack<Character> operators = new Stack<>();

        int i = 0;
        while (i < expr.length) {
            // skipp spaces
            if(expr[i] == ' ') {
                i++;
                continue;
            }
            if(Character.isDigit(expr[i])){
                int num = 0;
                while (i < expr.length && Character.isDigit(expr[i])) {
                    num = num * 10 + (expr[i] - '0');
                    i++;
                }
                digits.push(num);
            } else {
                while (!operators.empty() && (
                        (operators.peek() == '*' || operators.peek() == '/') ||
                        (operators.peek() == '+' || operators.peek() == '-') && (expr[i] == '+' || expr[i] == '-')
                )){
                    int num2 = digits.pop();
                    int num1 = digits.pop();
                    char op = operators.pop();

                    int res = switch (op) {
                        case '+' -> num1 + num2;
                        case '-' -> num1 - num2;
                        case '*' -> num1 * num2;
                        case '/' -> num1 / num2;
                        default -> 0;
                    };
                    digits.push(res);
                }
                operators.push(expr[i]);
                i++;
            }
        }

        // Evaluate remaining expression
        while (!operators.empty()) {
            int num2 = digits.pop();
            int num1 = digits.pop();
            char op = operators.pop();

            int res = switch (op) {
                case '+' -> num1 + num2;
                case '-' -> num1 - num2;
                case '*' -> num1 * num2;
                case '/' -> num1 / num2;
                default -> 0;
            };
            digits.push(res);
        }

        return digits.pop();
    }
    public static void main(String[] args) {
        System.out.println(EvaluateExpression("2+3+5*4/2".toCharArray()));
        System.out.println(EvaluateExpression("22 +15 - 2*7/3".toCharArray()));
    }
}
