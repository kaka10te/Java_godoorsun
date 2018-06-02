
public class StudentSubmission {
	private String runID;
	private String User;
	private String problem;
	private String result;
	private String SubmitTime;
	private String CopyID;
	private Long SubmitTimems;
	public String getCopyID() {
		return CopyID;
	}

	public void setCopyID(String copyID) {
		CopyID = copyID;
	}

	public String getSubmitTime() {
		return SubmitTime;
	}

	public void setSubmitTime(String submitTime) {
		SubmitTime = submitTime;
	}

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

	public Long getSubmitTimems() {
		return SubmitTimems;
	}

	public void setSubmitTimems(Long submitTimems) {
		SubmitTimems = submitTimems;
	}
	
}