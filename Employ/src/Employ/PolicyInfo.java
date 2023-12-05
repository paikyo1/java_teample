package Employ;

public class PolicyInfo { //채용정보 클래스
    private String policyName; //회사명
    private String policyIntro; //채용공고명
    private String Service;  //담당업무
    private String Address;  //지원자격

	public String getPolicyName() {
		return policyName;
	}
	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}
	public String getPolicyIntro() {
		return policyIntro;
	}
	public void setPolicyIntro(String policyIntro) {
		this.policyIntro = policyIntro;
	}
	public String getService() {
		return Service;
	}
	public void setService(String service) {
		Service = service;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	

}
  