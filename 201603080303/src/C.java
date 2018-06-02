import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 * 
 */

/**
 * @author shagody
 *
 */
public class C {

	/**
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// ArrayList<StudentSubmission> list = new ArrayList<StudentSubmission>();
		String shangjiFile = "上机情况.csv";
		// 打开文件
		BufferedReader readshangjifile = new BufferedReader(new InputStreamReader(new FileInputStream(shangjiFile)));
		String a;
		a = readshangjifile.readLine();// ignore first line
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd HH:mm"); // 2018/5/18 0:40

		Date date = null;

		TreeMap<String, Calendar> calendarMap = new TreeMap<String, Calendar>();

		while ((a = readshangjifile.readLine()) != null) {
			String s[] = a.split(",");
			try {
				Calendar calen = Calendar.getInstance();
				date = format.parse(s[7]);
				calen.setTime(date);
				calendarMap.put(s[0], calen);
			} catch (ParseException e) {
				System.out.println(e.getMessage());
			}
			// System.out.println(calen.getTimeInMillis());
		}

		int i = 1;
		Long timePoint = calendarMap.firstEntry().getValue().getTimeInMillis();
		ArrayList<Integer> count = new ArrayList<Integer>();
		count.add(0);
		count.add(0);
		for (Map.Entry<String, Calendar> entry : calendarMap.entrySet()) {
			// System.out.println(entry.getKey()+" "+entry.getValue());
			Long nowTime = entry.getValue().getTimeInMillis();
			if (nowTime <= (timePoint + 3600000 * i)) {
				int nowCount = count.get(i) + 1;
				count.set(i, nowCount);
			} else {
				i++;
				count.add(1);
			}
		}
		int len = count.size();
		for (int j = 1; j < len; j++) {
//			System.out.println("第 " + j + " 小时： " + count.get(j) + " 次");
			System.out.println(j +"\t"+  count.get(j));
		}
		readshangjifile.close();
	}
}
