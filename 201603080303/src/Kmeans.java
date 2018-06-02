import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * K均值聚类算法https://blog.csdn.net/xiaojimanman/article/details/51086879
 */
public class Kmeans {
	private List<StudentSubmission> dataArray;// 待分类的原始值
	private int K = 3;// 将要分成的类别个数
	private int maxClusterTimes = 500;// 最大迭代次数
	private List<List<StudentSubmission>> clusterList;// 聚类的结果
	private List<StudentSubmission> clusterCenter;// 质心

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
     * @Description: 初始化一个聚类结果 
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
			//寻找最相似的质心 
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
        //计算本次聚类结果每个类别的新质心 
        List<StudentSubmission> newCenter = new ArrayList<StudentSubmission> ();  
        for (List<StudentSubmission> list : clusterList) {  
            newCenter.add(getCenter(list));  
        }  
        //是否达到最大迭代次数  
        if (times >= this.maxClusterTimes || preCenter.size() < this.K) {  
            this.setClusterList(clusterList);  
            return;  
        }
        this.clusterCenter = newCenter;  
        //判断质心是否发生移动，如果没有移动，结束本次聚类，否则进行下一轮  
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
		// 初始化K个质心
		clusterCenter = new ArrayList<StudentSubmission>(K);
		// 对数据进行打乱
		Collections.shuffle(dataArray);
		for (int i = 0; i < K; i++) {
			clusterCenter.add(dataArray.get(i));
		}
		clustering(clusterCenter,K);
		
		for(List<StudentSubmission> list:clusterList) {
			for(StudentSubmission stu:list){
				System.out.println(stu.getUser()+"\t"+stu.getSubmitTimems());
			}
			System.out.println("————————————————");
			System.out.println("\n\n");
		}
		
		System.out.println("OK");

	}
    /** 
     * @param list 
     * @return 
     * @Author:lulei   
     * @Description: 求一组数据的质心 
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
