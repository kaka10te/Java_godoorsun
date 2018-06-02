import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * K��ֵ�����㷨https://blog.csdn.net/xiaojimanman/article/details/51086879
 */
public class Kmeans {
	private List<StudentSubmission> dataArray;// �������ԭʼֵ
	private int K = 3;// ��Ҫ�ֳɵ�������
	private int maxClusterTimes = 500;// ����������
	private List<List<StudentSubmission>> clusterList;// ����Ľ��
	private List<StudentSubmission> clusterCenter;// ����

	public List<StudentSubmission> getDataArray() {
		return dataArray;
	}

	public void setDataArray(List<StudentSubmission> dataArray) {
		this.dataArray = dataArray;
	}

    /** 
     * @param size 
     * @return 
     * @Author:lulei   
     * @Description: ��ʼ��һ�������� 
     */  
    private List<List<StudentSubmission>> getListStudentSubmission(int size) {  
        List<List<StudentSubmission>> list = new ArrayList<List<StudentSubmission>>(size);  
        for (int i = 0; i < size; i++) {  
            list.add(new ArrayList<StudentSubmission>());  
        }  
        return list;  
    }  
    
	private void clustering(List<StudentSubmission> preCenter,int times) {
		List<List<StudentSubmission>> clusterList= getListStudentSubmission(K);
		if(preCenter==null||preCenter.size()<2)
			return ;
		for(StudentSubmission temp:dataArray) {
			//Ѱ�������Ƶ����� 
			int min=0;
			long distance=Math.abs(temp.getSubmitTimems()-clusterCenter.get(0).getSubmitTimems());
			for(int i=1;i<clusterCenter.size();i++) {
				long distance2=Math.abs(temp.getSubmitTimems()-clusterCenter.get(i).getSubmitTimems());
				if(distance>distance2) {
					distance=distance2;
					min=i;
				}
			}
			clusterList.get(min).add(temp);
		}
        //���㱾�ξ�����ÿ������������ 
        List<StudentSubmission> newCenter = new ArrayList<StudentSubmission> ();  
        for (List<StudentSubmission> list : clusterList) {  
            newCenter.add(getCenter(list));  
        }  
        //�Ƿ�ﵽ����������  
        if (times >= this.maxClusterTimes || preCenter.size() < this.K) {  
            this.setClusterList(clusterList);  
            return;  
        }
        this.clusterCenter = newCenter;  
        //�ж������Ƿ����ƶ������û���ƶ����������ξ��࣬���������һ��  
        if (isCenterChange(preCenter, newCenter)) {  
            clusterList.clear();  
            clustering(newCenter, times + 1);  
        } else {  
            this.setClusterList(clusterList);  
        }
	}
	
	private boolean isCenterChange(List<StudentSubmission> preCenter, List<StudentSubmission> newCenter) {
		
		for(int i=0;i<preCenter.size();i++) {
			if(preCenter.get(i).getSubmitTimems()!=newCenter.get(i).getSubmitTimems())
				return false;
		}
		return true;
	}

	public void execute() {
		// ��ʼ��K������
		clusterCenter = new ArrayList<StudentSubmission>(K);
		// �����ݽ��д���
		Collections.shuffle(dataArray);
		for (int i = 0; i < K; i++) {
			clusterCenter.add(dataArray.get(i));
		}
		clustering(clusterCenter,K);
		
		for(List<StudentSubmission> list:clusterList) {
			for(StudentSubmission stu:list){
				System.out.println(stu.getUser()+"\t"+stu.getSubmitTimems());
			}
			System.out.println("��������������������������������");
			System.out.println("\n\n");
		}
		
		System.out.println("OK");

	}
    /** 
     * @param list 
     * @return 
     * @Author:lulei   
     * @Description: ��һ�����ݵ����� 
     */  
    public StudentSubmission getCenter(List<StudentSubmission> list) {
    	long xms=0;
    	StudentSubmission stu=new StudentSubmission();
    	for (StudentSubmission x : list) {  
            xms+=x.getSubmitTimems();
        }  
    	xms = xms / list.size();
    	stu.setSubmitTimems(xms);
    	return stu;
	}

	public List<List<StudentSubmission>> getClusterList() {
		return clusterList;
	}

	public void setClusterList(List<List<StudentSubmission>> clusterList) {
		this.clusterList = clusterList;
	}
}
