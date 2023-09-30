package Task1;

import java.util.ArrayList;
import java.util.List;

public class MyArray3 {

	public static int[] findMissingNumbers(int[] array) {
		int min = findMin(array);
		int max = findMax(array);

		List<Integer> missingNumbers = new ArrayList<>();

		for (int num = min + 1; num < max; num++) {
			if (!contains(array, num)) {
				missingNumbers.add(num);
			}
		}

		int[] result = new int[missingNumbers.size()];

		for (int i = 0; i < missingNumbers.size(); i++) {
			result[i] = missingNumbers.get(i);
		}

		return result;
	}

	public static int findMin(int[] array) {
		int min = Integer.MAX_VALUE;
		for (int num : array) {
			if (num < min) {
				min = num;
			}
		}
		return min;
	}

	public static int findMax(int[] array) {
		int max = Integer.MIN_VALUE;
		for (int num : array) {
			if (num > max) {
				max = num;
			}
		}
		return max;
	}

	public static boolean contains(int[] array, int target) {
		for (int num : array) {
			if (num == target) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[] inputArray = { 10, 11, 12, 13, 14, 16, 17, 19, 20 };
		int[] missingNumbers = findMissingNumbers(inputArray);

		System.out.print("Output: ");
		for (int num : missingNumbers) {
			System.out.print(num + " ");
		}
	}
}
