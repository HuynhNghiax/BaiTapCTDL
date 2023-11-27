package task1;

import java.util.Iterator;
import java.util.Stack;

public class MyLIFO_App {
	// This method reserves the given array
	public static <E> void reserve(E[] array) {
		Stack<E> st1 = new Stack<>();
		for (E arr : array) {
			st1.push(arr);
		}

		for (int i = 0; i < array.length; i++) {
			array[i] = st1.pop();
		}

	}

	// This method checks the correctness of the given input
	// i.e. ()(())[]{(())} ==> true, ){[]}() ==> false
	public static boolean isCorrect(String input) {
		char[] chars = input.toCharArray();
		Stack<Character> st2 = new Stack<>();
		for (char c : chars) {
			if (c == '(' || c == '{' || c == '[') {
				st2.push(c);
			}
		}
		for (char c : chars) {
			if (c == ')' || c == '}' || c == ']') {
				st2.pop();
			}
		}
		if (st2.isEmpty()) {
			return true;
		}
		return false;
	}

	// This method evaluates the value of an expression
	// i.e. 51 + (54 *(3+2)) = 321
	public static int evaluateExpression(String expression) {
		Stack<Integer> operandStack = new Stack<>();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char token = expression.charAt(i);

            if (Character.isDigit(token)) {
                int operand = 0;
                while (i < expression.length() && Character.isDigit(expression.charAt(i))) {
                    operand = operand * 10 + Character.getNumericValue(expression.charAt(i));
                    i++;
                }
                operandStack.push(operand);
            } else if (token == '+' || token == '-') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '+' || operatorStack.peek() == '-' || operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token);
            } else if (token == '*' || token == '/') {
                while (!operatorStack.isEmpty() && (operatorStack.peek() == '*' || operatorStack.peek() == '/')) {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.push(token);
            } else if (token == '(') {
                operatorStack.push(token);
            } else if (token == ')') {
                while (operatorStack.peek() != '(') {
                    processOperator(operandStack, operatorStack);
                }
                operatorStack.pop();
            }
        }

        while (!operatorStack.isEmpty()) {
            processOperator(operandStack, operatorStack);
        }

        return operandStack.pop();
	}

	private static void processOperator(Stack<Integer> operandStack, Stack<Character> operatorStack) {
		char operator = operatorStack.pop();
        int operand2 = operandStack.pop();
        int operand1 = operandStack.pop();
        int result = 0;

        switch (operator) {
            case '+':
                result = operand1 + operand2;
                break;
            case '-':
                result = operand1 - operand2;
                break;
            case '*':
                result = operand1 * operand2;
                break;
            case '/':
                result = operand1 / operand2;
                break;
        }

        operandStack.push(result);
	}

	public static void main(String[] args) {
		
		String s1 = "((((())))";
		System.out.println(isCorrect(s1));
		String expression = "51+(54*(3+2))";
		int result = evaluateExpression(expression);
		System.out.println(expression);
		System.out.println("Result: " + result); // Output should be 321

	}

}
