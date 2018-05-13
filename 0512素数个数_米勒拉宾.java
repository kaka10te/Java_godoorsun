import java.util.Scanner;

public class Main {
//	private static int mod = 1000000000 + 7;
	private static int a[]={0,
			78498,
			148933,
			216816,
			283146,
			348513,
			412849,
			476648,
			539777,
			602489,
			664579};
//	private static int t,n,ans;
	
	private static int qpow(int x,int y,int mod)//快速幂
	{
	    int ans=1,a=x;
	    while(y==1)
	    {
	        if((y&1)==1) ans=ans*a%mod;
	        a=a*a%mod;
	        y>>=1;
	    }
	    return ans;
	}
	
	private static boolean MR_prime(int a,int n)//米勒拉宾
	{
	    int r=0,d=n-1;
	    if((n%a)==0)return false;//倍数必为合数
	    while(~(d&1))//找到奇数
	    {
	        d>>=1;
	        r++;
	    }
	    int k=qpow(a,d,n);
	    if(k==1) return true;//同余1
	    for(int i=0;i<r;i++,k=k*k%n) if(k==n-1) return true;//同余-1
	    return false;
	}
	
	private static boolean check_prime(int n)
	{
	    if(n==2||n==3||n==7||n==61) return true;
	    if((!(n&1))||(n%3==0)||n==1) return false;//删掉大量已知情况
	    if(MR_prime(2,n)&&MR_prime(7,n)&&MR_prime(61,n)) return true;
	    return false;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int n;
		while (scan.hasNext()) {
			n=scan.nextInt();
			int ans=a[n/1000000];
			for(int i=1+n/1000000*1000000;i<=n;i++)
	    		if(check_prime(i)) ans++;
		    System.out.println(ans);
		}
		scan.close();
	}
}
