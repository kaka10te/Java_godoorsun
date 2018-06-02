package zjut.iec.dyj;

public class River {//商人过河问题
	private int merchants;//商人总数
	private int servants;//随从总数
	private static int capacity=4;//小船容量
	private static int [][]a=new int [6][6];//允许状态为1，不允许为0
	private static int [][]b=new int [30][2];//允许决策坐船方案
	

	public River() {//默认：5商人5随从
		merchants=5;
		servants=5;
	}
	public River(int servants,int merchants) {
		this.merchants=merchants; 
		this.servants=servants;
	}
	
	public void allowstate() {//允许状态集合
		System.out.println("允许的状态集合:");
		for(int i=0;i<=merchants;i++) {
			for(int j=0;j<=servants;j++)
				if(i==0) {
					System.out.print("("+i+","+j+")");
					a[i][j]=1;
				}
				else if(i==merchants){
					System.out.print("("+i+","+j+")");
					a[i][j]=1;
				}
				else if(i==j){
					System.out.print("("+i+","+j+")");
					a[i][j]=1;
				}
		}
		System.out.println("");
	}
	
	public void allowdec() {//允许决策集合
		System.out.println("允许的决策集合:u表示商人，v表示随从");
		System.out.println("1<=u+v<="+capacity);
		int count=0;
		for(int i=0;i<=capacity;i++)
			for(int j=0;j<=capacity;j++)
				if((i+j)<=capacity&&(i+j)!=0) {
					b[count][0]=i;
					b[count][1]=j;
					System.out.println(b[count][0]+" "+b[count][1]);
					count++;
				}
	}
	
	public void crossriver() {
		int x=merchants;//某一岸的商人
		int y=servants;//某一岸的随从
		int count = 1;
		while(x!=0||y!=0) {
			int xmove = (int)Math.random();
			int ymove = (int)Math.random();
			
		}
		if(x==0&&y==0)
			System.out.println("0,0");
	}
	public static void main(String[] args) {//主方法
		River boat1= new River();
		boat1.allowstate();
		boat1.allowdec();
		boat1.crossriver();
	}
}
