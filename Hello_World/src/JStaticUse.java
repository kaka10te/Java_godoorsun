

public class JStaticUse {
	static int a=2;
	static int b;
	
	static {
		b=a*a;
		a=3;
	}
	
	public static void main(String args[]) {
		new JStaticUse();
		System.out.println("b��ֵΪ "+b);
		new JStaticUse();
		System.out.println("b��ֵ����Ϊ "+b);
		
	}

}
