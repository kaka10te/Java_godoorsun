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

	public boolean Hash_Search(int[]bl,int kx,int p) {
		int h;
		if(bl[kx%p]==kx)
			return true;
		for(int q=0;q<=(p-1)/2;q++) {
			h=(kx+q*q)%p;
			if(bl[h]==kx)
				return true;
			h=(kx-q*q)%p;
			if(bl[h]==kx)
				return true;
		}
		return false;
	}
	
	public void Init(int []base,int n) {//顺序存储方法
		Scanner scan = new Scanner(System.in);
		for(int i=0;i<n;i++){
			base[i]=scan.nextInt();
        }
		scan.close();
	}
	
	public static void main(String[] args) {
		Main a=new Main();
		Scanner scan = new Scanner(System.in);
	        while(scan.hasNext()){
	            int n=scan.nextInt();
	            int []base=new int [n] ;
	            int p=100000;//取余
//	            a.Init(base,n);//顺序存储方法
	            
//	            for(int i=0;i<n;i++){//顺序存储
//	    			base[i]=scan.nextInt();
//	            }
	            
	            for(int i=0;i<n;i++){//哈希存储
	            	base[i%p]=scan.nextInt();
	            }
	            
	            int m=scan.nextInt();
	            int x;
	            for(int j=0;j<m;j++){
	            	x=scan.nextInt();
//	            	if(a.Binary_Search(base,x))
//	            		System.out.println(true);
//	            	else System.out.println(false);
	            	if(a.Hash_Search(base, x, p))
	            		System.out.println(true);
	            	else System.out.println(false);
	            }
	        }
	        scan.close();
	} 
}
