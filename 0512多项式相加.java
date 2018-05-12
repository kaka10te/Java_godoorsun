import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		while (scan.hasNext()) {
			TreeMap<Integer, Integer> tree=new TreeMap<Integer, Integer>(Collections.reverseOrder());//Collections.reverseOrder()反序treemap
			int m=scan.nextInt();
			int n=scan.nextInt();
			for(int i=0;i<m;i++) {
				int a=scan.nextInt();//系数value
				int b=scan.nextInt();//指数key
				if(a==0)continue;//跳过系数为0
				tree.put(b, a);
			}
			for(int i=0;i<n;i++) {
				int x=scan.nextInt();//系数
				int y=scan.nextInt();//指数
				if(x==0)continue;//跳过系数为0
				if(tree.containsKey(y)) {
					tree.put(y, tree.get(y)+x);
				}
				else
					tree.put(y, x);
			}
			Iterator<Integer> iter = tree.keySet().iterator();
			while(iter.hasNext()){
				Object key = iter.next();
				if(tree.get(key)==0)continue;
				System.out.println(tree.get(key)+" "+key.toString());
			}
		}
		scan.close();
	}
}
