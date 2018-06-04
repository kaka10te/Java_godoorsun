import java.io.*;
import java.util.*;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class D {

	static String shangjiFile = "上机情况.csv";
	static HashMap<StudentSubmission, String> copyMap = new HashMap<StudentSubmission, String>();
	//copyMap<抄袭者提交记录StudentSubmission,抄袭者名字User>
	static TreeMap<String, String> idUserMap = new TreeMap<String, String>();
	//idUserMap<提交编号RunID,提交者名字User>
	static TreeMap<String, Integer> userMap = new TreeMap<String, Integer>();
	//所有包括抄袭被抄袭用户userMap<User,第几个>
	static TreeMap<String, Integer> problemMap = new TreeMap<String, Integer>();
	//各个问题抄袭人数problemMap<problem,amount>
	
	public static void main(String[] args) throws Exception {
		BufferedReader readshangjifile = new BufferedReader(new InputStreamReader(new FileInputStream(shangjiFile)));
		D d = new D();
		d.readFile(readshangjifile);
		
		// 所有包括抄袭被抄袭用户userMap
		int x = 0;//一共多少人
		for (Map.Entry<StudentSubmission, String> entry : copyMap.entrySet()) {
			StudentSubmission Key = entry.getKey();
			String copyer=Key.getUser();//抄袭者
			String copyed = idUserMap.get(Key.getCopyID());//被抄袭者
			if (copyed == null)
				continue;// 删掉NULL那一组数据
			if (!userMap.containsKey(copyed)) {//add 被抄袭者
				userMap.put(copyed, x++);
			}
			if (!userMap.containsKey(copyer)) {//add 抄袭者
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
			if(copyedUser==null)continue;// 过滤NULL那一组数据
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
			while ((a = readshangjifile.readLine()) != null) {// 抄袭list加入copyMap中
				String s[] = a.split(",");
				idUserMap.put(s[0], s[1]);
				StudentSubmission stu = new StudentSubmission();
				if (s[3].startsWith("*Accepted")) {
					stu.setProblem(s[2]);
					stu.setUser(s[1]);
					stu.setCopyID(s[3].substring(9, 13));//抄袭对象的编号
					copyMap.put(stu, s[1]);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@SuppressWarnings("unused")
	private void printCopyAmount() {// 输出各个问题抄袭人数problemMap<problem,amount>
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
	private void printCopyTrace() {// 输出 抄袭人 被抄袭人
		for (Map.Entry<StudentSubmission, String> entryCopy : copyMap.entrySet()) {
			StudentSubmission submitKey = entryCopy.getKey();
			String copyed = idUserMap.get(submitKey.getCopyID());
			if (copyed == null)
				continue;// 删掉NULL那一组数据
			System.out.println(submitKey.getUser() + "\t" + copyed);
		}
	}

	@SuppressWarnings("unused")
	private void printD3jsNodes() {// 输出d3js的节点
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
	private void printD3jsLine() {// 输出d3js图的有向边
		System.out.print("var edges = [ ");
		int i = 0;
		int len = copyMap.size();
		for (Map.Entry<StudentSubmission, String> entryCopy : copyMap.entrySet()) {
			StudentSubmission submitKey = entryCopy.getKey();
			String copyer = idUserMap.get(submitKey.getCopyID());
			if (copyer == null) {
				i++;
				continue;// 删掉NULL那一组数据
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
