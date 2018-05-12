import java.math.BigInteger;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String n = scan.nextLine();
			String a[]=n.split("\\+");
			BigInteger sum=new BigInteger("0");
			for(int i=0;i<a.length;i++) {
				BigInteger temp=new BigInteger(a[i]);
				sum=sum.add(temp);
			}
			System.out.println(sum);
		}
		scan.close();
	}
}
