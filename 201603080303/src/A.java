import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class A {

	public static void main(String[] args) {
		try {
			// TODO Auto-generated method stub
			Map<String, String> student = new TreeMap<String, String>();
			Map<String, String> shangji = new TreeMap<String, String>();

			String stuFile = "ѧ������.csv";
			String shangjiFile = "�ϻ����.csv";
			// ���ļ�
			BufferedReader readstufile = new BufferedReader(
					new InputStreamReader(new FileInputStream(stuFile)));
			BufferedReader readshangjifile = new BufferedReader(
					new InputStreamReader(new FileInputStream(shangjiFile)));

			String b;
			while ((b = readstufile.readLine()) != null) {
				student.put(b, "");
			}
			String a;
			while ((a = readshangjifile.readLine()) != null) {
				String split[] = a.split(",");
				shangji.put(split[1], "");
			}

			// �������
			Iterator<String> iter = shangji.keySet().iterator();
			while (iter.hasNext()) {
				Object key = iter.next();
				if (student.containsKey(key.toString())) {
					continue;
				}
				System.out.println("xiaohao is :" + key.toString());
			}
			readshangjifile.close();
			readstufile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}