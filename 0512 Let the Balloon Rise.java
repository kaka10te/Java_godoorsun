import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			int n = scan.nextInt();
			if(n==0)break;
			HashMap<String, Integer> h = new HashMap<String, Integer>();
			for (int i = 0; i < n; i++) {
				String ballon = scan.next();
				if (h.containsKey(ballon)) {
					int count = h.get(ballon) + 1;
					h.put(ballon, count);
				} else
					h.put(ballon, 1);
			}
			Iterator<String> iter = h.keySet().iterator();
			int max = 1;
			String flag = null;
			while (iter.hasNext()) {
				Object key = iter.next();
				if (h.get(key) >= max) {
					max = h.get(key);
					flag = key.toString();
				}
			}
			System.out.println(flag);
		}
		scan.close();
	}
}
