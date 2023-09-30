package Task1;

import java.util.Arrays;

public class MyArray {
	int array[];

	public MyArray(int[] array) {
		super();
		this.array = array;
	}
	public int[] mirror() {
		int[] mirroredArray = new int[array.length * 2];
		for (int i = 0; i < array.length; i++) {
			mirroredArray[i] = array[i];
		}
		for (int i = 0; i < array.length; i++) {
			mirroredArray[array.length + i] = array[array.length - i - 1];
		}

		return mirroredArray;
	}

	public static void main(String[] args) {
		int[] inputArray = { 1, 2, 3 };
		MyArray myArray = new MyArray(inputArray);
		int[] mirrored = myArray.mirror();
		System.out.println(Arrays.toString(mirrored));
	}
}