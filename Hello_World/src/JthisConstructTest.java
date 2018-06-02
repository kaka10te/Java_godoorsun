

public class JthisConstructTest {
	String name;
	int age;
	
	public JthisConstructTest() {
		name ="zhangsan";
		age =20;
	}
	
	public JthisConstructTest(String name,int age) {
		this();
//		System.out.println("name= "+name+" age= "+age);	//1	
		System.out.println("name= "+this.name+" age= "+this.age);	//2
	}
	
	public static void main(String args[]) {
		new JthisConstructTest("anima",233);
	}
}
