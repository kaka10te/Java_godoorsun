import java.util.Scanner;


public class Main {
	
	public boolean Binary_Search(int[]bl,int kx) {
		int low,high,mid;
//		int flag=0;
		low=1;high=bl.length-1;
		if(kx<bl[0]||kx>bl[high])
			return false;
		while(low<=high) {
			mid=(low+high)/2;
			if(kx<bl[mid])
				high=mid-1;
			else if(kx>bl[mid])
				low=mid+1;
			else {
//				flag=mid;
				break;
			}
		}
		return true;
//		return flag;//返回位置
	}

	public static void main(String[] args) {
		Main a=new Main();
		Scanner scan = new Scanner(System.in);
	        while(scan.hasNext()){
	            int n=scan.nextInt();
	            int []base=new int [n] ;
	            for(int i=0;i<n;i++){
	            	base[i]=scan.nextInt();
	            }
	            
	            int m=scan.nextInt();
	            int x;
	            for(int j=0;j<m;j++){
	            	x=scan.nextInt();
	            	if(a.Binary_Search(base,x))
	            		System.out.println(true);
	            	else System.out.println(false);
	            }
	        }
	        scan.close();
	} 
}
