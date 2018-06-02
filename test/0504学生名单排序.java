//Contest1019 - Java上机练习 自动化16 #5 (课后)
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);

		ArrayList<Long> num = new ArrayList<Long>();
		ArrayList<String> name = new ArrayList<String>();
		ArrayList<String> xin = new ArrayList<String>();
		while (scan.hasNext()) {
			num.add(scan.nextLong());
			name.add(scan.next());
			xin.add(scan.next());
		}
		
		long temp;
		String temp1;
		int lenth=num.size();
		for (int i = 0; i < lenth - 1; i++) {
			for (int j = 0; j < lenth - i - 1; j++) {
				if (num.get(j) > num.get(j+1)) {
					temp = num.get(j);
					num.set(j, num.get(j+1))  ;
					num.set(j+1,temp);
					
					temp1 = name.get(j);
					name.set(j, name.get(j+1))  ;
					name.set(j+1,temp1);
					
					temp1 = xin.get(j);
					xin.set(j, xin.get(j+1))  ;
					xin.set(j+1,temp1);
				}
			}
		}
		for(int i=0;i<lenth;i++) {
			System.out.println(num.get(i)+" "+name.get(i)+" "+xin.get(i));
		}
		
		scan.close();
	}
}
