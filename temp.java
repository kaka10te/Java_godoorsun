import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		
			ArrayList<String> a = new ArrayList<String>();
			while(scan.hasNext()){
				a.add(scan.nextLine());
			}
			scan.close();
			
			int c[]=new int[100];
			for(int i=0;i<a.size();i++){
				c[i]=Integer.parseInt(a.get(i).substring(7, 12));
			}
			
			int cc[]=new int[100];
			cc[0]=0;
			for(int i=0;i<a.size();i++){
				for(int j=0;j<a.size();j++){
					if(c[j]>c[j+1]&&c[j]>c[cc[i]])
						cc[j]=j+1;
				}
			}
			for(int i=0;i<a.size();i++){
				System.out.println(a.get(cc[i]));
			}

		
		

	}
}
