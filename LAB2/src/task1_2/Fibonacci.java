package task1_2;

public class Fibonacci {
	public static int getFibonacci(int n) {
		if (n == 0) {
			return 0;
		}
		if (n < 3) {
			return 1;
		} else {
			return getFibonacci(n - 1) + getFibonacci(n - 2);
		}
	}

	public static void printFibonacci(int n) {
		for (int i = 0; i < n; i++) {
			System.out.println(getFibonacci(i));
		}
	}

	public static void main(String[] args) {
		int n = 10;
		printFibonacci(n);
	}
}