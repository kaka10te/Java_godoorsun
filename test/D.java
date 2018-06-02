import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner scan = new Scanner(System.in);
	        while(scan.hasNext()){
	        	int n = scan.nextInt();
	        	int m = scan.nextInt();
	        	int a[]=new int[n];
	        	int b[]=new int[m];
	        	for(int i=0;i<n;i++) {
	        		a[i]=scan.nextInt();
	        	}
	        	for(int i=0;i<m;i++) {
	        		b[i]=scan.nextInt();
	        	}
	        	int k=scan.nextInt();
	        	int x = 0;//weizhi
	        	int flag=0;//
	        	
	        	for(int i=0;i<n;i++) {
	        		if(a[i]==k)
	        			x=i;
	        	}
	        	
	        	
				tag:
	        		for(int i=0;i<x;i++) {
		        		for(int j=0;j<m;j++) {
		        			if(a[i]==b[j])
		        				break;
		        			else if(j==m-1)
		        				flag=1;
		        			break tag;
		        		}
	        	}
	        	
	        	if(flag==1)
	        		System.out.println("NO");
	        	else System.out.println("YES");
	        
	        } 
	        scan.close();
}
}
