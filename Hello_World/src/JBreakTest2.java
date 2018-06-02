

public class JBreakTest2 {
	public static void main(String []args) {
		int index=0;
		tag:{
			while(index<=100) {
				index+=10;
				if(index==40)
					break tag;
				System.out.println("The index is "+index);
			}
			System.out.println("break the tag!");
		}
	}
}
