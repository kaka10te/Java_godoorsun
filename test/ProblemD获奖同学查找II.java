import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	        while(scan.hasNext()){
	            int n=scan.nextInt();
	            ArrayList<Integer> list = new ArrayList<Integer>();
	            
	            for(int i=0;i<n;i++){
	            	list.add(scan.nextInt());
	            }
	            
	            int m=scan.nextInt();
	            for(int j=0;j<m;j++){
	            	int x=scan.nextInt();
	            	if(list.contains(x))
	            		System.out.println(true);
	            	else 
	            		System.out.println(false);
	            }
	            
	        }
	        scan.close();
	} 
}
