package Task1;

public class Task1_3 {
	public static int[][] multiply(int[][] a, int[][] b) {
		if (a[0].length == b.length) {
			int[][] result = new int[a.length][b[0].length];
			int index = 0;
			for (int i = 0; i < result.length; i++) {
				if (index >= result[i].length) {
					index = 0;
				}
				while (index < result[i].length) {
					for (int j = 0; j < a[i].length; j++) {
						result[i][index] += a[i][j] * b[j][index];
					}
					index++;
				}
			}
			return result;
		} else

		{
			return null;
		}
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
		System.out.println("mảng e");
		int[][] e = { { 2, 1 }, { -1, 3 }, { 1, 8 } };
		printArr(e);
		System.out.println("mảng f");
		int[][] f = { { 2, 7, 3 }, { 1, 6, -4 } };
		printArr(f);
		System.out.println("mảng e nhân f");
		printArr(multiply(e, f));
	}

}
