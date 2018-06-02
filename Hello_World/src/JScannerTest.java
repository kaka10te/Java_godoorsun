

import java.util.Scanner;

public class JScannerTest {
	public static void main(String []args)
	{
		Scanner scan=new Scanner(System.in);
		int a;
//		System.out.println("请输入数据：");
		a=scan.nextInt();
		System.out.println("输入的数据是："+a);
		scan.close();
	}
}
