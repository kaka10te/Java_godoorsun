import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Main {
	public void bubble_sort(ArrayList<String> num, ArrayList<String> name, int lenth) {//冒泡排序
		String temp0;
		String temp1;
		for (int i = 0; i < lenth - 1; i++) {
			for (int j = 0; j < lenth - i - 1; j++) {
				if (num.get(j).compareTo(num.get(j + 1)) >= 0) {
					temp0 = num.get(j);
					num.set(j, num.get(j + 1));
					num.set(j + 1, temp0);
					temp1 = name.get(j);
					name.set(j, name.get(j + 1));
					name.set(j + 1, temp1);
				}
			}
		}
	}

	public static void main(String[] args) {

		try {
			String sortFile = "班级名单-sorted.txt";
			DataOutputStream output = new DataOutputStream(new FileOutputStream(sortFile));

			String strFile = "./班级名单.txt";
			// 打开文件
			BufferedReader readfile = new BufferedReader(new InputStreamReader(new FileInputStream(strFile)));

			ArrayList<String> num = new ArrayList<String>();
			ArrayList<String> name = new ArrayList<String>();

			String b;
			while ((b = readfile.readLine()) != null) {
				String split[] = b.split("\t", 2);
				num.add(split[0]);
				name.add(split[1]);
			}
			// 冒泡排序
			int lenth = num.size();
			Main test = new Main();
			test.bubble_sort(num, name, lenth);

			// 输出排序好的名单
			for (int i = 0; i < lenth; i++) {
				output.writeUTF(num.get(i) + " " + name.get(i));
			}

			// 顺序查找
			Scanner scan = new Scanner(System.in);
			while (scan.hasNext()) {
				String no = scan.next();
				for (int j = 0; j < lenth; j++) {
					if (no.compareTo(num.get(j)) == 0)
						System.out.println(name.get(j));
				}
			}

			output.close();
			scan.close();
			readfile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
