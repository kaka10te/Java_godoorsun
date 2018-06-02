import java.util.ArrayList; 

/**
 * @author Tomato
 *https://blog.csdn.net/CYXLZZS/article/details/7416491
 */
public class E {  
	private static void test1(){
		//��ʼ��һ��Kmean���󣬽�k��Ϊ10  
        Kmeans k=new Kmeans(10);  
        ArrayList<float[]> dataSet=new ArrayList<float[]>();  
          
        dataSet.add(new float[]{1,2});  
        dataSet.add(new float[]{3,3});  
        dataSet.add(new float[]{3,4});  
        dataSet.add(new float[]{5,6});  
        dataSet.add(new float[]{8,9});  
        dataSet.add(new float[]{4,5});  
        dataSet.add(new float[]{6,4});  
        dataSet.add(new float[]{3,9});  
        dataSet.add(new float[]{5,9});  
        dataSet.add(new float[]{4,2});  
        dataSet.add(new float[]{1,9});  
        dataSet.add(new float[]{7,8});  
        //����ԭʼ���ݼ�  
        k.setDataSet(dataSet);  
        //ִ���㷨  
        k.execute();
        //�õ�������  
        ArrayList<ArrayList<float[]>> cluster=k.getCluster();  
        //�鿴���  
        for(int i=0;i<cluster.size();i++)  
        {  
            k.printDataArray(cluster.get(i), "cluster["+i+"]");  
        }  
	}
	private static void test2(){
		Kmeans k=new Kmeans(10);
		ArrayList<float[]> dataSet=new ArrayList<float[]>();
		
		
		k.setDataSet(dataSet);  
        //ִ���㷨  
        k.execute();
        //�õ�������  
        ArrayList<ArrayList<float[]>> cluster=k.getCluster();  
        //�鿴���  
        for(int i=0;i<cluster.size();i++)  
        {  
            k.printDataArray(cluster.get(i), "cluster["+i+"]");  
        } 
	}
    public  static void main(String[] args)  
    {  
    	test1();
        test2();
          
    }  
}