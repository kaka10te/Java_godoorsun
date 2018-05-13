import java.util.Scanner;

public class Main {
	private static int printPrimeNumber(int n){//欧拉筛选法
	    //用每个位false0 and true1来分别表示合数和素数  
		boolean flags[]= null;
		//room for time
		if(n<2)
			return 0;
		else {
			flags = new boolean[n+1];
			for(int i=0;i<n+1;i++)//初始化全是素数
				flags[i]=true;
			for(int i=2;i<n+1;i++) {
				int count=n/i;
				if(flags[i]) {//if false,after all false
					for(int j=2;j<=count;j++) {
						if(flags[i*j]) {
							flags[i*j]= false;
						}
					}
				}
			}
		}
		
		int result=0;
		for(int i=2;i<n+1;i++) {
			if(flags[i]) {
				result++;
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		while (scan.hasNext()) {
			long startTime=System.currentTimeMillis();   //获取开始时间  
			
			int i=scan.nextInt();
			System.out.println(printPrimeNumber(i));
			
			long endTime=System.currentTimeMillis(); //获取结束时间  
			System.out.println("程序运行时间： "+(endTime-startTime)+"ms"); 
		}
		scan.close();
	}
}
