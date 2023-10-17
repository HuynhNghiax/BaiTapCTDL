package task1;

public class Task1_1 {
	public static void selectionSort(int[] array) {
		for (int i = 0; i < array.length + 1; i++) {
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] > array[i]) {
					int max=j;
					int y= array[max];
					array[max]=array[i];
					array[i]=y;
				}
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = { 5, 3, 2, 7, 8, 1, 2 };
		selectionSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.println("selectionSort" + arr[i]);
		}

	}
}
