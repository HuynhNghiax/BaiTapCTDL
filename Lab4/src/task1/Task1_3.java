package task1;

public class Task1_3 {
	public static void insertionSort(int[] array) {
		for (int i = 1; i < array.length; i++) {
			int j = i - 1;
			int t = array[i];
			while (j >= 0 && t > array[j]) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = t;
		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 3, 2, 7, 8, 1, 2 };
		insertionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println( arr[i]);
		}
	}
}
