import java.io.BufferedReader;
import java.util.ArrayList;
import java.util.TreeMap;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;

/**
 * @author Tomato https://blog.csdn.net/CYXLZZS/article/details/7416491
 */
public class E {
//	private static void test1() {
//		// ��ʼ��һ��Kmean���󣬽�k��Ϊ10
//		Kmeans k = new Kmeans(10);
//		ArrayList<float[]> dataSet = new ArrayList<float[]>();
//
//		dataSet.add(new float[] { 1, 2 });
//		dataSet.add(new float[] { 3, 3 });
//		dataSet.add(new float[] { 3, 4 });
//		dataSet.add(new float[] { 5, 6 });
//		dataSet.add(new float[] { 8, 9 });
//		dataSet.add(new float[] { 4, 5 });
//		dataSet.add(new float[] { 6, 4 });
//		dataSet.add(new float[] { 3, 9 });
//		dataSet.add(new float[] { 5, 9 });
//		dataSet.add(new float[] { 4, 2 });
//		dataSet.add(new float[] { 1, 9 });
//		dataSet.add(new float[] { 7, 8 });
//		// ����ԭʼ���ݼ�
//		k.setDataSet(dataSet);
//		// ִ���㷨
//		k.execute();
//		// �õ�������
//		ArrayList<ArrayList<float[]>> cluster = k.getCluster();
//		// �鿴���
//		for (int i = 0; i < cluster.size(); i++) {
//			k.printDataArray(cluster.get(i), "cluster[" + i + "]");
//		}
//	}

	private static ArrayList<StudentSubmission> ReadFile() throws Exception {
		String shangjiFile = "�ϻ����.csv";
		// ���ļ�
		ArrayList<StudentSubmission> dataSet = new ArrayList<StudentSubmission>();
		BufferedReader readshangjifile = 
				new BufferedReader(new InputStreamReader(new FileInputStream(shangjiFile)));
		String a;
		a = readshangjifile.readLine();// ignore first line
		while ((a = readshangjifile.readLine()) != null) {
			StudentSubmission stu = new StudentSubmission();
			String s[] = a.split(",");
			stu.setUser(s[1]);
			stu.setSubmitTime(s[7]);
			dataSet.add(stu);
		}
		readshangjifile.close();
		return dataSet;
	}

	private static void test2() {
		Kmeans k = new Kmeans(10);
		ArrayList<StudentSubmission> dataSet = new ArrayList<StudentSubmission>();
		dataSet=ReadFile();

		k.setDataSet(dataSet);
		// ִ���㷨
		k.execute();
		// �õ�������
		ArrayList<ArrayList<StudentSubmission>> cluster = k.getCluster();
		// �鿴���
		for (int i = 0; i < cluster.size(); i++) {
			k.printDataArray(cluster.get(i), "cluster[" + i + "]");
		}
	}

	public static void main(String[] args) {
//		test1();
		test2();

	}
}