
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
		int prime[]=new int[n];
		
//		long startTime = System.currentTimeMillis(); // 获取开始时间
		for (int i = 0; i < n + 1; i++)//
				flags[i] = 0;
//		long endTime = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("程序运行时间1： " + (endTime - startTime) + "ms");
		
//		startTime = System.currentTimeMillis(); // 获取开始时间
		
		int cnt=0;
		for (int i = 2; i<= n; i++)  
	    {  
	        if (flags[i]==0)  
	            prime[cnt++] = i;  
	        for (int j = 0; j < cnt && i * prime[j] < n+1; j++)  
	        {  
	        	flags[i*prime[j]] = 1;  
	            if (i%prime[j] == 0)//关键  每一个筛选数，只被一个数乘以它的最小素因子，如果i % prime[j] == 0，则证明 i中含有prime[j]这个素因子，所以prime[j + 1] 至 prime[prime.size()-1]都不是最小素因子  
	                break;  
	        }  
	    } 
//		endTime = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("程序运行时间2： " + (endTime - startTime) + "ms");

//		startTime = System.currentTimeMillis(); // 获取开始时间
		int result = 0;
		for (int i = 2; i < n + 1; i++) {
			if (flags[i] == 0) {
				result++;
				flags[i] = result;
			}
			else
				flags[i]=flags[i-1];//如果非素数，等于前面的数
		}
//		endTime = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("程序运行时间3： " + (endTime - startTime) + "ms");

	}

	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis(); // 获取开始时间
		init();
//		long endTime = System.currentTimeMillis(); // 获取结束时间
//		System.out.println("init程序运行时间： " + (endTime - startTime) + "ms");

		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
//			startTime = System.currentTimeMillis(); // 获取开始时间
			
			int i = scan.nextInt();
			System.out.println(printPrimeNumber(i, flags));
			
//			endTime = System.currentTimeMillis(); // 获取结束时间
//			System.out.println("chazhao程序运行时间： " + (endTime - startTime) + "ms");
		}
		scan.close();
	}
}
