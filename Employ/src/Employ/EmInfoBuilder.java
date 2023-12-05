package Employ;

public class EmInfoBuilder { //채용정보클래스의 멤버를 쉽게 갱신하기위해 만들어진 클래스
	private EmInfo e;
	public EmInfoBuilder(EmInfo e) {
		this.e = e;
	}

	public EmInfoBuilder companyName(String companyName) {
		e.setCompanyName(companyName);
		return this;
	}
	
	public EmInfoBuilder Title(String Title) {
		e.setTitle(Title);
		return this;
	}
	
	public EmInfoBuilder Task(String Task) {
		e.setDescription(Task);
		return this;
	}
	
	public EmInfoBuilder Requirements(String Requirements) {
		e.setRequirements(Requirements);
		return this;
	}
	
	
	
	public EmInfoBuilder startDate(String startDate) {
		e.setStartDate(startDate);
		return this;
	}
	
	public EmInfoBuilder endDate(String endDate) {
		e.setEndDate(endDate);
		return this;
	}
	public EmInfo emInfo() { //갱신한 EmInfo 객체를 반환
		return e;
	}
}
