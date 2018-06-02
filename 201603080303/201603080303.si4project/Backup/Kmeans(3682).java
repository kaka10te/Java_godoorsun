import java.util.ArrayList;
import java.util.Random;

/**
 * K��ֵ�����㷨
 */
public class Kmeans {
	private int k;// �ֳɶ��ٴ�
	private int m;// ��������
	private int dataSetLength;// ���ݼ�Ԫ�ظ����������ݼ��ĳ���
	private ArrayList<StudentSubmission> dataSet;// ���ݼ�����
	private ArrayList<ArrayList<StudentSubmission>> center;// ��������
	private ArrayList<ArrayList<StudentSubmission>> cluster; // ��
	private ArrayList<Float> jc;// ���ƽ���ͣ�kԽ�ӽ�dataSetLength�����ԽС
	private Random random;

	/**
	 * ����������ԭʼ���ݼ�
	 * 
	 * @param dataSet
	 */
	public void setDataSet(ArrayList<StudentSubmission> dataSet) {
			this.dataSet = dataSet;
		}

	/**
	 * ��ȡ�������
	 * 
	 * @return �����
	 */

	public ArrayList<ArrayList<StudentSubmission>> getCluster() {
		return cluster;
	}

	/**
	 * ���캯����������Ҫ�ֳɵĴ�����
	 * 
	 * @param k
	 *            ������,��k<=0ʱ������Ϊ1����k��������Դ�ĳ���ʱ����Ϊ����Դ�ĳ���
	 */
	public Kmeans(int k) {
		if (k <= 0) {
			k = 1;
		}
		this.k = k;
	}

	/**
	 * ��ʼ��
	 */
	private void init() {
		m = 0;
		random = new Random();
		if (dataSet == null || dataSet.size() == 0) {
			initDataSet();
		}
		dataSetLength = dataSet.size();
		if (k > dataSetLength) {
			k = dataSetLength;
		}
		center = initCenters();
		cluster = initCluster();
		jc = new ArrayList<Float>();
	}

	/**
	 * ���������δ��ʼ�����ݼ���������ڲ��������ݼ�
	 */
	private void initDataSet() {
		dataSet = new ArrayList<StudentSubmission>();
		// ����{6,3}��һ���ģ����Գ���Ϊ15�����ݼ��ֳ�14�غ�15�ص���Ϊ0
		float[][] dataSetArray = new float[][] { { 8, 2 }, { 3, 4 }, { 2, 5 }, { 4, 2 }, { 7, 3 }, { 6, 2 }, { 4, 7 },
				{ 6, 3 }, { 5, 3 }, { 6, 3 }, { 6, 9 }, { 1, 6 }, { 3, 9 }, { 4, 1 }, { 8, 6 } };

		for (int i = 0; i < dataSetArray.length; i++) {
			dataSet.add(dataSetArray[i]);
		}
	}

	/**
	 * ��ʼ���������������ֳɶ��ٴؾ��ж��ٸ����ĵ�
	 * 
	 * @return ���ĵ㼯
	 */
	private ArrayList<StudentSubmission> initCenters() {
		ArrayList<StudentSubmission> center = new ArrayList<StudentSubmission>();
		int[] randoms = new int[k];
		boolean flag;
		int temp = random.nextInt(dataSetLength);
		randoms[0] = temp;
		for (int i = 1; i < k; i++) {
			flag = true;
			while (flag) {
				temp = random.nextInt(dataSetLength);
				int j = 0;
				// �����forѭ������j�޷���1
				// for(j=0;j<i;++j)
				// {
				// if(temp==randoms[j]);
				// {
				// break;
				// }
				// }
				while (j < i) {
					if (temp == randoms[j]) {
						break;
					}
					j++;
				}
				if (j == i) {
					flag = false;
				}
			}
			randoms[i] = temp;
		}

		// ����������������
		// for(int i=0;i<k;i++)
		// {
		// System.out.println("test1:randoms["+i+"]="+randoms[i]);
		// }

		// System.out.println();
		for (int i = 0; i < k; i++) {
			center.add(dataSet.get(randoms[i]));// ���ɳ�ʼ����������
		}
		return center;
	}

	/**
	 * ��ʼ���ؼ���
	 * 
	 * @return һ����Ϊk�صĿ����ݵĴؼ���
	 */
	private ArrayList<ArrayList<StudentSubmission>> initCluster() {
		ArrayList<ArrayList<StudentSubmission>> cluster = new ArrayList<ArrayList<StudentSubmission>>();
		for (int i = 0; i < k; i++) {
			cluster.add(new ArrayList<StudentSubmission>());
		}

		return cluster;
	}

	/**
	 * ����������֮��ľ���
	 * 
	 * @param element
	 *            ��1
	 * @param center
	 *            ��2
	 * @return ����
	 */
	private float distance(float[] element, float[] center) {
		float distance = 0.0f;
		float x = element[0] - center[0];
		float y = element[1] - center[1];
		float z = x * x + y * y;
		distance = (float) Math.sqrt(z);

		return distance;
	}

	/**
	 * ��ȡ���뼯������С�����λ��
	 * 
	 * @param distance
	 *            ��������
	 * @return ��С�����ھ��������е�λ��
	 */
	private int minDistance(float[] distance) {
		float minDistance = distance[0];
		int minLocation = 0;
		for (int i = 1; i < distance.length; i++) {
			if (distance[i] < minDistance) {
				minDistance = distance[i];
				minLocation = i;
			} else if (distance[i] == minDistance) // �����ȣ��������һ��λ��
			{
				if (random.nextInt(10) < 5) {
					minLocation = i;
				}
			}
		}

		return minLocation;
	}

	/**
	 * ���ģ�����ǰԪ�طŵ���С����������صĴ���
	 */
	private void clusterSet() {
		float[] distance = new float[k];
		for (int i = 0; i < dataSetLength; i++) {
			for (int j = 0; j < k; j++) {
				distance[j] = distance(dataSet.get(i), center.get(j));
				// System.out.println("test2:"+"dataSet["+i+"],center["+j+"],distance="+distance[j]);

			}
			int minLocation = minDistance(distance);
			// System.out.println("test3:"+"dataSet["+i+"],minLocation="+minLocation);
			// System.out.println();

			cluster.get(minLocation).add(dataSet.get(i));// ���ģ�����ǰԪ�طŵ���С����������صĴ���

		}
	}

	/**
	 * ���������ƽ���ķ���
	 * 
	 * @param element
	 *            ��1
	 * @param center
	 *            ��2
	 * @return ���ƽ��
	 */
	private float errorSquare(float[] element, float[] center) {
		float x = element[0] - center[0];
		float y = element[1] - center[1];

		float errSquare = x * x + y * y;

		return errSquare;
	}

	/**
	 * �������ƽ����׼��������
	 */
	private void countRule() {
		float jcF = 0;
		for (int i = 0; i < cluster.size(); i++) {
			for (int j = 0; j < cluster.get(i).size(); j++) {
				jcF += errorSquare(cluster.get(i).get(j), center.get(i));

			}
		}
		jc.add(jcF);
	}

	/**
	 * �����µĴ����ķ���
	 */
	private void setNewCenter() {
		for (int i = 0; i < k; i++) {
			int n = cluster.get(i).size();
			if (n != 0) {
				float[] newCenter = { 0, 0 };
				for (int j = 0; j < n; j++) {
					newCenter[0] += cluster.get(i).get(j)[0];
					newCenter[1] += cluster.get(i).get(j)[1];
				}
				// ����һ��ƽ��ֵ
				newCenter[0] = newCenter[0] / n;
				newCenter[1] = newCenter[1] / n;
				center.set(i, newCenter);
			}
		}
	}

	/**
	 * ��ӡ���ݣ�������
	 * 
	 * @param dataArray
	 *            ���ݼ�
	 * @param dataArrayName
	 *            ���ݼ�����
	 */
	public void printDataArray(ArrayList<StudentSubmission> dataArray, String dataArrayName) {
		for (int i = 0; i < dataArray.size(); i++) {
			System.out.println(
					"print:" + dataArrayName + "[" + i + "]={" + dataArray.get(i)[0] + "," + dataArray.get(i)[1] + "}");
		}
		System.out.println("===================================");
	}

	/**
	 * Kmeans�㷨���Ĺ��̷���
	 */
	private void kmeans() {
		init();

		// ѭ�����飬ֱ������Ϊֹ
		while (true) {
			clusterSet();
			countRule();

			// �����ˣ��������
			if (m != 0) {
				if (jc.get(m) - jc.get(m - 1) == 0) {
					break;
				}
			}

			// ��Ȼ�����
			setNewCenter();

			m++;
			cluster.clear();
			cluster = initCluster();
		}

		System.out.println("note:the times of repeat:m= " + m);// �����������
	}


	/**
	 * ִ���㷨
	 */
	public void execute() {
		kmeans();
	}
}
