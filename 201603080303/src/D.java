import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class D {

	static String shangjiFile = "�ϻ����.csv";
	static HashMap<StudentSubmission, String> copyMap = new HashMap<StudentSubmission, String>();
	//copyMap<��Ϯ���ύ��¼StudentSubmission,��Ϯ������User>
	static TreeMap<String, String> idUserMap = new TreeMap<String, String>();
	//idUserMap<�ύ���RunID,�ύ������User>
	static TreeMap<String, Integer> userMap = new TreeMap<String, Integer>();
	//���а�����Ϯ����Ϯ�û�userMap<User,�ڼ���>
	static TreeMap<String, Integer> problemMap = new TreeMap<String, Integer>();
	//�������ⳭϮ����problemMap<problem,amount>
	
	public static void main(String[] args) throws Exception {
		BufferedReader readshangjifile = new BufferedReader(new InputStreamReader(new FileInputStream(shangjiFile)));
		D d = new D();
		d.readFile(readshangjifile);
		
		// ���а�����Ϯ����Ϯ�û�userMap
		int x = 0;//һ��������
		for (Map.Entry<StudentSubmission, String> entry : copyMap.entrySet()) {
			StudentSubmission Key = entry.getKey();
			String copyer=Key.getUser();//��Ϯ��
			String copyed = idUserMap.get(Key.getCopyID());//����Ϯ��
			if (copyed == null)
				continue;// ɾ��NULL��һ������
			if (!userMap.containsKey(copyed)) {//add ����Ϯ��
				userMap.put(copyed, x++);
			}
			if (!userMap.containsKey(copyer)) {//add ��Ϯ��
				userMap.put(copyer, x++);
			}
		}

//		d.printGephiNodes();
//		d.printGephiLine();
		d.printCopyAmount();
		d.printCopyTrace();
//		d.printD3jsNodes();
//		d.printD3jsLine();
		readshangjifile.close();
	}

	@SuppressWarnings("unused")
	private void printGephiLine() {
		Iterator<Entry<StudentSubmission, String>> iter = copyMap.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<StudentSubmission, String> entry = iter.next();
			String copyedUser=idUserMap.get(entry.getKey().getCopyID());
			if(copyedUser==null)continue;// ����NULL��һ������
			String copyer=entry.getValue();
			System.out.println(userMap.get(copyer)+","+userMap.get(copyedUser));
		}
	}
	@SuppressWarnings("unused")
	private void printGephiNodes() {
		Iterator<Entry<String, Integer>> iter= userMap.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<String, Integer> entry = iter.next();
			System.out.println(entry.getValue()+","+entry.getKey());
		}
	}
	private void readFile(BufferedReader readshangjifile) {
		String a;
		try {
			a = readshangjifile.readLine();// ignore first line
			while ((a = readshangjifile.readLine()) != null) {// ��Ϯlist����copyMap��
				String s[] = a.split(",");
				idUserMap.put(s[0], s[1]);
				StudentSubmission stu = new StudentSubmission();
				if (s[3].startsWith("*Accepted")) {
					stu.setProblem(s[2]);
					stu.setUser(s[1]);
					stu.setCopyID(s[3].substring(9, 13));//��Ϯ����ı��
					copyMap.put(stu, s[1]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unused")
	private void printCopyAmount() {// ����������ⳭϮ����problemMap<problem,amount>
		Iterator<StudentSubmission> iter1 = copyMap.keySet().iterator();
		
		while (iter1.hasNext()) {
			StudentSubmission key = iter1.next();
			String problem = key.getProblem();
			if (problemMap.containsKey(problem)) {
				problemMap.put(problem, problemMap.get(problem) + 1);
			} else {
				problemMap.put(problem, 1);
			}
		}
		for (Map.Entry<String, Integer> entry : problemMap.entrySet()) {
			System.out.println(entry.getKey() + "\t" + entry.getValue());
		}
	}

	@SuppressWarnings("unused")
	private void printCopyTrace() {// ��� ��Ϯ�� ����Ϯ��
		for (Map.Entry<StudentSubmission, String> entryCopy : copyMap.entrySet()) {
			StudentSubmission submitKey = entryCopy.getKey();
			String copyed = idUserMap.get(submitKey.getCopyID());
			if (copyed == null)
				continue;// ɾ��NULL��һ������
			System.out.println(submitKey.getUser() + "\t" + copyed);
		}
	}

	@SuppressWarnings("unused")
	private void printD3jsNodes() {// ���d3js�Ľڵ�
		System.out.print("var nodes = [ ");
		int i = 0;
		for (Map.Entry<String, Integer> entry : userMap.entrySet()) {
			System.out.print("{ name: " + "\"" + entry.getKey() + "\"" + " }");
			if (i != userMap.size() - 1)
				System.out.print(",");
			if ((i + 1) % 4 == 0)
				System.out.println("");
			i++;
		}
		System.out.println("];");
	}

	@SuppressWarnings("unused")
	private void printD3jsLine() {// ���d3jsͼ�������
		System.out.print("var edges = [ ");
		int i = 0;
		int len = copyMap.size();
		for (Map.Entry<StudentSubmission, String> entryCopy : copyMap.entrySet()) {
			StudentSubmission submitKey = entryCopy.getKey();
			String copyer = idUserMap.get(submitKey.getCopyID());
			if (copyer == null) {
				i++;
				continue;// ɾ��NULL��һ������
			}
			System.out.print("{ source : ");
			System.out.print(userMap.get(submitKey.getUser()) + ", target:" + userMap.get(copyer));
			System.out.print("} ");
			if (i != len - 1)
				System.out.print(",");
			if ((i + 1) % 4 == 0)
				System.out.println("");
			i++;
		}
		System.out.println("];");
	}
}
