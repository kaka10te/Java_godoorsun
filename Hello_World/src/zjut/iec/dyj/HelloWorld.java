package zjut.iec.dyj;

import java.util.Scanner;

//zjutoj.nat123.cc
//Scanner cin = new Scanner(System.in);
//while(cin.hasNext()){}多行输入

//只能创造一个对象

public class HelloWorld {
	static int flag;//???static
	
	public static void isPrime_1(int num) {//根号法
		int tmp=(int)Math.sqrt(num);
		flag = 0;//是素数
		for(int i=2;i<=tmp;i++) {
			if(0==num%i)
				flag = 1;//不是素数
		}
	}
	
//	public static void isPrime_2(int num) {//六倍速法
//		flag=0;//是素数
//		if(num==4) {//判断小于6的数
//			flag=1;
//			continue;
//		}
//		if(num%6!=1||num%6!=5) {//判断是否在6倍数的附近
//			flag=1;
//			continue;
//		}
//		int tmp=(int) Math.sqrt(num);
//		for(int i=5;i<=tmp;i+=6)
//	}
	
	public static void main(String []args) {
		Scanner cin = new Scanner(System.in);
		while(cin.hasNext()){
			int a = cin.nextInt();
			for(int i=4;i<=a;i++) {
				isPrime_1(i);
				if(flag==0) {
					isPrime_1(i-2);
					if(flag==0)
						System.out.println((i-2)+" "+i);
				}
				
			}
			System.out.println("Done");
		}
		cin.close();
	}
}
