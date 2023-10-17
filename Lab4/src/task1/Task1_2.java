package task1;

public class Task1_2 {
	public static void bubbleSort(int[] array) {
		for (int i = 0; i < array.length+1; i++) {
			for (int j = i + 1; j < array.length ; j++) {
				if (array[i] < array[j]) {
					int t = array[i];
					array[i] = array[j];
					array[j] = t;
				}
			}
		}
	}
	public static void main(String[] args) {
		int arr[] = { 5, 3, 2, 7, 8, 1, 2 };
		bubbleSort(arr);
		for(int i=0;i<arr.length;i++) {
			System.out.println(arr[i]);
		}
	}
}
