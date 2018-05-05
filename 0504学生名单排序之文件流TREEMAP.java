import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.io.*;

public class Main {
	public static void main(String[] args) {

		try {
			Map<String, String> student = new TreeMap<String, String>();
			String sortFile = "班级名单-sorted.txt";
			DataOutputStream output = new DataOutputStream(new FileOutputStream(sortFile));
			String strFile = "./班级名单.txt";
			// 打开文件
			BufferedReader readfile = new BufferedReader(new InputStreamReader(new FileInputStream(strFile)));

			String b;
			while ((b = readfile.readLine()) != null) {
				String split[] = b.split("\t", 2);
				student.put(split[0], split[1]);
			}

			// 迭代输出
			Iterator<String> iter = student.keySet().iterator();
			while (iter.hasNext()) {
				Object key = iter.next();
				output.writeUTF(key.toString() + " " + student.get(key));
				// System.out.println("map key " + key.toString() + " value=" +
				// student.get(key));
			}

			// treemap查找
			Scanner scan = new Scanner(System.in);
			while (scan.hasNext()) {
				String no = scan.next();
				System.out.println(student.get(no));
			}
			scan.close();

			output.close();
			readfile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
