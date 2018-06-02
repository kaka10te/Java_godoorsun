

public class JPassTest {
	float ptValue;
	
	public void changeInt(int value) {
		value=55;
	}
	
	public void changeStr(String value) {
		value=new String("world");
	}
	
	public void changeObjValue(JPassTest ref) {
		ref.ptValue=99.0f;
	}
	
}
