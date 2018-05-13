import java.util.Scanner;

public class Main {
	private static int printPrimeNumber1(int n) {// sundaram
		// 用每个位1 and 0来分别表示合数和素数
		boolean flags[] = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++)//初始化
			flags[i] = false;

		int m = (int) Math.sqrt(n / 2);
		for (int k = 1; k < m; k++) {
			if (flags[k])
				continue;
			int j = 2 * k + 1;
			int i = 2 * k * (k + 1);
			for (; i < n; i += j) {
				flags[i] = true;
			}
		}

		int count = 1;
		for (int i = 1; i < n / 2; i++) {
			if (!flags[i])
				count++;
		}
		return count;
	}

//	private static int printPrimeNumber2(int n) {// 欧拉筛选法
//		// 用每个位false0 and true1来分别表示合数和素数
//		boolean flags[] = null;
//		// room for time
//		if (n < 2)
//			return 0;
//		else {
//			flags = new boolean[n + 1];
//			for (int i = 0; i < n + 1; i++)// 初始化全是素数
//				flags[i] = true;
//
//			for (int i = 2; i < n + 1; i++) {
//				int count = n / i;
//				if (flags[i]) {// if false,after all false
//					for (int j = 2; j <= count; j++) {
//						if (flags[i * j]) {
//							flags[i * j] = false;
//						}
//					}
//				}
//			}
//		}
//
//		int result = 0;
//		for (int i = 2; i < n + 1; i++) {
//			if (flags[i]) {
//				result++;
//			}
//		}
//		return result;
//	}

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		while (scan.hasNext()) {
//			long startTime = System.currentTimeMillis(); // 获取开始时间
			int i = scan.nextInt();
			System.out.println(printPrimeNumber1(i+1));
//			long endTime = System.currentTimeMillis(); // 获取结束时间
//			System.out.println("程序运行时间1： " + (endTime - startTime) + "ms");

//			startTime = System.currentTimeMillis(); // 获取开始时间
//			System.out.println(printPrimeNumber2(i));
//			endTime = System.currentTimeMillis(); // 获取结束时间
//			System.out.println("程序运行时间2： " + (endTime - startTime) + "ms");
		}
		scan.close();
	}
}
