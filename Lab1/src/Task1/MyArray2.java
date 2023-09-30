package Task1;

import java.util.LinkedHashSet;

public class MyArray2 {
	int array[];

	public MyArray2(int[] array) {
		super();
		this.array = array;
	}

	// 1.2
	public static void removeDuplicates(int a[]) {
		LinkedHashSet<Integer> set = new LinkedHashSet<Integer>();
		for (int i = 0; i < a.length; i++)
			set.add(a[i]);
		System.out.print(set);
	}
	public static void main(String[] args) {

		int a[] = { 1, 3, 5, 1, 3, 7, 9, 8 };
		removeDuplicates(a);
	}
}
