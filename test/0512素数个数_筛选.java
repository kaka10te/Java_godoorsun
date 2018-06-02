import java.util.Scanner;

public class Main {
	private static int flags[] = null;// 欧拉筛选
	private static int n = 10000000;//n极限数据大小
	
	private static int printPrimeNumber(int x, int[] flags) {
		for (int i = x; i > 2; i--) {
			if (flags[i] != 0) {
				return flags[i];
			}
		}
		return 0;
	}

	private static void init() {//初始化表flags，直接存
		flags = new int[n + 1];
		for (int i = 0; i < n + 1; i++)//
			flags[i] = 1;
		for (int i = 2; i < n + 1; i++) {// 欧拉筛选法
			int count = n / i;
			if (flags[i] == 1) {// if false,after all false
				for (int j = 2; j <= count; j++) {
					if (flags[i * j] == 1) {
						flags[i * j] = 0;
					}
				}
			}
		}

		int result = 0;
		for (int i = 2; i < n + 1; i++) {
			if (flags[i] == 1) {
				result++;
				flags[i] = result;
			}
			else
				flags[i]=flags[i-1];//如果非素数，等于前面的数
		}
	}

	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis(); // 获取开始时间
		init();
//		long endTime = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("程序运行时间： " + (endTime - startTime) + "ms");

		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
//			startTime = System.currentTimeMillis(); // 获取开始时间
			
			int i = scan.nextInt();
			System.out.println(printPrimeNumber(i, flags));
			
//			endTime = System.currentTimeMillis(); // 获取结束时间
//			System.out.println("程序运行时间： " + (endTime - startTime) + "ms");
		}
		scan.close();
	}
}
