import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.TreeMap;

public class D {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String shangjiFile = "上机情况.csv";
		// 打开文件
		BufferedReader readshangjifile = new BufferedReader(new InputStreamReader(new FileInputStream(shangjiFile)));
		TreeMap<String,String> idUserMap=new TreeMap<String,String>();
		ArrayList<String> listUser = new ArrayList<String>();
		ArrayList<String> listProblem = new ArrayList<String>();
		ArrayList<String> listCopyID = new ArrayList<String>();
		String a = readshangjifile.readLine();// ignore first line
		while ((a = readshangjifile.readLine()) != null) {
			String s[]=a.split(",");
			idUserMap.put(s[0], s[1]);
			if(s[3].startsWith("*Accepted")) {
				listUser.add(s[1]);
				listProblem.add(s[2]);
				listCopyID.add(s[3].substring(9, 13));
			}
		}
		
		int len = listUser.size();
		//各个问题抄袭人数
		int countProblem[]= {0,0,0,0, 0,0,0,0};
//		int len = listUser.size();
		for(int i=0;i<len;i++) {
			char c[] = listProblem.get(i).toCharArray();
			int problem= (int)c[0]-(int)('A')+1;
			countProblem[problem]++;
		}
		for(int i=1;i<8;i++)
			System.out.println(countProblem[i]);
		
		ArrayList<String> copyList = new ArrayList<String>();
		for(int i=0;i<len;i++) {
			copyList.add(idUserMap.get(listCopyID.get(i)));
		}
		for(int i=0;i<len;i++) {
			System.out.println(listUser.get(i)+"\t"+copyList.get(i));
		}
		readshangjifile.close();
	}

}
