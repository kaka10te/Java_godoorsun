import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class StudentSubmission {
	String runID;
	String User;
	String problem;
	String result;
	


	public String getRunID() {
		return runID;
	}

	public void setRunID(String runID) {
		this.runID = runID;
	}

	public String getUser() {
		return User;
	}

	public void setUser(String user) {
		User = user;
	}

	public String getProblem() {
		return problem;
	}

	public void setProblem(String problem) {
		this.problem = problem;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public static void main(String[] args) {
		try {
			Map<String, StudentSubmission> shangji = new TreeMap<String, StudentSubmission>();
			StudentSubmission stu=new StudentSubmission();
			
			String shangjiFile = "上机情况.csv";
			// 打开文件
			BufferedReader readshangjifile = new BufferedReader(
					new InputStreamReader(new FileInputStream(shangjiFile)));

			
			String a;
			a = readshangjifile.readLine();
			while ((a = readshangjifile.readLine()) != null) {
				String s[] = a.split(",");
				stu.setUser(s[1]);
				stu.setProblem(s[2]);
				stu.setRunID(s[0]);
				
				shangji.put(s[1],stu );
			}

			// 迭代输出
			Iterator<String> iter = shangji.keySet().iterator();
			while (iter.hasNext()) {
				Object key = iter.next();
				
			}
			readshangjifile.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
