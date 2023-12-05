package Employ;

public class EmInfo { //채용정보 클래스
    private String companyName; //회사명
    private String Title; //채용공고명
    private String Task;  //담당업무
    private String Requirements;  //지원자격
    private String startDate;  //등록일
    private String endDate; //마감일
	

	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getDescription() {
		return Task;
	}
	public void setDescription(String description) {
		Task = description;
	}
	public String getRequirements() {
		return Requirements;
	}
	public void setRequirements(String requirements) {
		Requirements = requirements;
	}
	
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
    


	
	

}
