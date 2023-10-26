package Task1;

public class Task1_1 {
	public static int[][] add(int[][] a, int[][] b) {
		int[][] result = new int[a.length][a[0].length];
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a[i].length; j++) {
				result[i][j] = a[i][j] + b[i][j];
			}
		}
		return result;
	}

	public static void printArr(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++) {
				System.out.print("  " + arr[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int[][] a = { { 2, 1, 6 }, { -1, 3, 4 }, { 1, 8, 2 } };
		int[][] b = { { 2, 7, 3 }, { 1, 6, -4 }, { 0, -8, 7 } };
		System.out.println("mảng a");
		 printArr(a);
		System.out.println("mảng b");
		printArr(b);
		System.out.println("mảng a + b");
		printArr(add(a, b));

	}
}
