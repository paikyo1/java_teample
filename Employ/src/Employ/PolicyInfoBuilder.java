package Employ;

public class PolicyInfoBuilder { //ä������Ŭ������ ����� ���� �����ϱ����� ������� Ŭ����
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
	public PolicyInfo policyInfo() { // ������ PolicyInfo ��ü�� ��ȯ
		return p;
	}
}
	

