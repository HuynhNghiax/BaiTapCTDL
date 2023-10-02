package task1;

public class Task1_1 {
	// 1
	public static int getSn1(int n) {
		if (n == 1) {
			return 1;
		} else {
			int count = (int) (n * Math.pow(-1, n + 1));
			return getSn1(n - 1) + count;
		}
	}

	// 2
	public static int getSn2(int n) {
		if (n == 1) {
			return 1;
		} else {
			int giaithua = 1;
			for (int i = 1; i < n + 1; i++) {
				giaithua *= i;
			}
			return getSn2(n - 1) + giaithua;
		}
	}

	// 3
	public static int getSn3(int n) {
		if (n == 1) {
			return 1;
		} else {
			int count = (int) Math.pow(n, 2);
			return getSn3(n - 1) + count;
		}
	}

	// 4
	public static double getSn4(int n) {
		if (n == 0) {
			return 1;
		}
		double cthucchung = 1 / mauSn4(n);
		return getSn4(n - 1) + cthucchung;
	}

	public static double mauSn4(int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return 2;
		} else {
			return (mauSn4(n - 1) * 2 * n);
		}
	}

	public static void main(String[] args) {

		System.out.println(getSn1(3));
		System.out.println(getSn2(3));
		System.out.println(getSn3(3));
		System.out.println(getSn4(4));
	}
}
