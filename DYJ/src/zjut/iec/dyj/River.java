package zjut.iec.dyj;

public class River {//���˹�������
	private int merchants;//��������
	private int servants;//�������
	private static int capacity=4;//С������
	private static int [][]a=new int [6][6];//����״̬Ϊ1��������Ϊ0
	private static int [][]b=new int [30][2];//���������������
	

	public River() {//Ĭ�ϣ�5����5���
		merchants=5;
		servants=5;
	}
	public River(int servants,int merchants) {
		this.merchants=merchants; 
		this.servants=servants;
	}
	
	public void allowstate() {//����״̬����
		System.out.println("�����״̬����:");
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
	
	public void allowdec() {//������߼���
		System.out.println("����ľ��߼���:u��ʾ���ˣ�v��ʾ���");
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
		int x=merchants;//ĳһ��������
		int y=servants;//ĳһ�������
		int count = 1;
		while(x!=0||y!=0) {
			int xmove = (int)Math.random();
			int ymove = (int)Math.random();
			
		}
		if(x==0&&y==0)
			System.out.println("0,0");
	}
	public static void main(String[] args) {//������
		River boat1= new River();
		boat1.allowstate();
		boat1.allowdec();
		boat1.crossriver();
	}
}
