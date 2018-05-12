import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			ArrayList<String> chlid=new ArrayList<String>();
			TreeMap<Long,String> num=new TreeMap<Long,String>();
			for(int i=0;i<n;i++) {
				chlid.add(scan.next());
			}
			Collections.sort(chlid);//排序
			for(int i=0;i<n;i++) {
				num.put(scan.nextLong(), "0");
			}
			int len=chlid.size();
			Iterator<Long> iter2 = num.keySet().iterator();
			for(int i=0;i<len;i++) {
				Object no = iter2.next();
				System.out.println(chlid.get(i)+' '+no.toString());
			}
		}
		scan.close();
	}
}
