import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;

/**
 * @author Tomato https://blog.csdn.net/CYXLZZS/article/details/7416491
 */
public class E {

	private static ArrayList<StudentSubmission> ReadFile() throws Exception {
		String shangjiFile = "上机情况.csv";
		// 打开文件
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm"); 
		ArrayList<StudentSubmission> dataSet = new ArrayList<StudentSubmission>();
		BufferedReader readshangjifile = 
				new BufferedReader(new InputStreamReader(new FileInputStream(shangjiFile)));
		String a;
		Date date = null;
		a = readshangjifile.readLine();// ignore first line
		while ((a = readshangjifile.readLine()) != null) {
			StudentSubmission stu = new StudentSubmission();
			String s[] = a.split(",");
			stu.setUser(s[1]);
			stu.setSubmitTime(s[7]);
			
			Calendar calen = Calendar.getInstance();
			date = format.parse(s[7]);
			calen.setTime(date);
			stu.setSubmitTimems(calen.getTimeInMillis());
			dataSet.add(stu);
		}
		readshangjifile.close();
		return dataSet;
	}

	private static void test2() throws Exception {
		Kmeans k=new Kmeans();
		k.setDataArray(ReadFile());
		k.execute();
	}

	public static void main(String[] args) throws Exception {
		test2();

	}
}