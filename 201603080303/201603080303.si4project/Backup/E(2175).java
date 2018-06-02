import java.util.ArrayList;

/**
 * @author Tomato https://blog.csdn.net/CYXLZZS/article/details/7416491
 */
public class E {
	private static void test1() {
		// 初始化一个Kmean对象，将k置为10
		Kmeans k = new Kmeans(10);
		ArrayList<float[]> dataSet = new ArrayList<float[]>();

		dataSet.add(new float[] { 1, 2 });
		dataSet.add(new float[] { 3, 3 });
		dataSet.add(new float[] { 3, 4 });
		dataSet.add(new float[] { 5, 6 });
		dataSet.add(new float[] { 8, 9 });
		dataSet.add(new float[] { 4, 5 });
		dataSet.add(new float[] { 6, 4 });
		dataSet.add(new float[] { 3, 9 });
		dataSet.add(new float[] { 5, 9 });
		dataSet.add(new float[] { 4, 2 });
		dataSet.add(new float[] { 1, 9 });
		dataSet.add(new float[] { 7, 8 });
		// 设置原始数据集
		k.setDataSet(dataSet);
		// 执行算法
		k.execute();
		// 得到聚类结果
		ArrayList<ArrayList<float[]>> cluster = k.getCluster();
		// 查看结果
		for (int i = 0; i < cluster.size(); i++) {
			k.printDataArray(cluster.get(i), "cluster[" + i + "]");
		}
	}

	private static void test2() {
		Kmeans k = new Kmeans(10);
		ArrayList<StudentSubmission> dataSet = new ArrayList<StudentSubmission>();
		String shangjiFile = "上机情况.csv";
		// 打开文件
		BufferedReader readshangjifile = new BufferedReader(new InputStreamReader(new FileInputStream(shangjiFile)));

		TreeMap<String, Integer> errorTimesMap = new TreeMap<String, Integer>();
		String a;
		a = readshangjifile.readLine();// ignore first line
		while ((a = readshangjifile.readLine()) != null) {
			StudentSubmission stu = new StudentSubmission();
			String s[] = a.split(",");
			stu.setRunID(s[0]);
			stu.setUser(s[1]);
			stu.setProblem(s[2]);
			stu.setResult(s[3]);
			stu.setSubmitTime(s[7]);
			list.add(stu);
			if (s[3].equals("Accepted")) {
				if (!errorTimesMap.containsKey(s[1])) {
					errorTimesMap.put(s[1], 0);
				}
				continue;
			}
			if (errorTimesMap.containsKey(s[1])) {// build errorTimesMap<User,errorTimes>
				int times = errorTimesMap.get(s[1]);
				errorTimesMap.put(s[1], times + 1);
			} else {
				errorTimesMap.put(s[1], 1);
			}
		}

		k.setDataSet(dataSet);
		// 执行算法
		k.execute();
		// 得到聚类结果
		ArrayList<ArrayList<float[]>> cluster = k.getCluster();
		// 查看结果
		for (int i = 0; i < cluster.size(); i++) {
			k.printDataArray(cluster.get(i), "cluster[" + i + "]");
		}
	}

	public static void main(String[] args) {
		test1();
		test2();

	}
}