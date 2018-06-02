import java.util.Scanner;

public class Main {

	private static final String NUM = "零壹贰叁肆伍陆柒捌玖";
	private static final String NUM1 = "拾佰仟";
	private static final String NUM2 = "万亿";
	private static final String unit = "元角分";

	private static String dotToBig(String dotPart) {
		// 得到转换后的大写（小数部分）
		String strdec = "";
		for (int i = 0; i < dotPart.length() && i < 2; i++) {
			int num;
			if ((num = Integer.parseInt(dotPart.substring(i, i + 1))) != 0)
				strdec += NUM.substring(num, num + 1) + unit.substring(i + 1, i + 2);
		}
		return strdec;
	}

	private static String IntegerToBig(String intpart) {
		// 得到转换后的大写（整数部分）
		int len=intpart.length();
		int g=len/4+1;//每四位一部分
		String strint = "";
		int end=len-(g-1)*4;
		String a=new String();//当前部分的数字，小于等于四位数
		
		for (int i = g; i>0 ; i--) {
			if(i==g)
				a= intpart.substring(0, end);//当前部分的数字，小于等于四位数
			else
				a= intpart.substring(end+(g-i-1)*4,end+(g-i)*4);
				
			int lena=a.length();
			for(int j=0;j<lena;j++) {//当前部分的数字中的第j+1个数
				int b =Integer.parseInt(a.substring(j, j+1));
				if(j==lena-1) {
					strint+=NUM.substring(b, b + 1);
					if(g!=1&&g!=4)
						strint+=NUM2.substring(g-1, g);//万，亿，万亿
					if(g==4)strint+="万亿";
				}
				else {
					strint+=NUM.substring(b, b + 1)+NUM1.substring(lena-j-1, lena-j);
				}
			}
			
			
		}
		return strint;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			String oof = scan.next();
			String[] cash = oof.split(".");
			int len = cash.length;// 有无小数
			cash[0].length();
			cash[1].length();

		}
		scan.close();
	}
}
