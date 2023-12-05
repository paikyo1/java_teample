package Employ;

public class PolicyInfoBuilder { //채용정보클래스의 멤버를 쉽게 갱신하기위해 만들어진 클래스
	private PolicyInfo p;
	public PolicyInfoBuilder(PolicyInfo p) {
		this.p = p;
	}

	public PolicyInfoBuilder policyName(String policyName) {
		p.setPolicyName(policyName);
		return this;
	}
	
	public PolicyInfoBuilder policyIntro(String policyIntro) {
		p.setPolicyIntro(policyIntro);
		return this;
	}
	
	public PolicyInfoBuilder Service(String Service) {
		p.setService(Service);
		return this;
	}
	
	public PolicyInfoBuilder Address(String Address) {
		p.setAddress(Address);
		return this;
	}
	public PolicyInfo policyInfo() { // 갱신한 PolicyInfo 객체를 반환
		return p;
	}
}
	

