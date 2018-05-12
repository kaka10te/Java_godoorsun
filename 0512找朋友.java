import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			TreeMap<String,String> chlid=new TreeMap<String,String>();
			TreeMap<Long,String> num=new TreeMap<Long,String>();
			for(int i=0;i<n;i++) {
				chlid.put(scan.next(), "0");
			}
			for(int i=0;i<n;i++) {
				num.put(scan.nextLong(), "0");
			}
			Iterator<String> iter1 = chlid.keySet().iterator();
			Iterator<Long> iter2 = num.keySet().iterator();
			while (iter1.hasNext()) {
				Object ch = iter1.next();
				Object no = iter2.next();
//				chlid.put(chlid.get(ch), no.toString());
				System.out.println(ch.toString()+' '+no.toString());
			}
		}
		scan.close();
	}
}
