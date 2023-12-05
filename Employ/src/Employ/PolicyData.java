package Employ;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class PolicyData extends AbstractTableModel {
	private List<PolicyInfo> list;
	private String[] headers = {"��å��","��å�Ұ�","���񽺸���","Ȩ������"};
	public PolicyData() {
		updateList();
	}
	
	public String getColumnName(int cell) { //���̺� ���Ӹ� �̸� ���ϴ� �Լ�
		return headers[cell];
	}
	
	public void updateList() { //���̺��� ���� �����ϴ� �Լ�
		list = new ArrayList<>();
		try {
		
		Scanner sc = new Scanner(new File("./policydata.csv"));
		for(int i = 0;sc.hasNextLine();i++) {
			String[] data = sc.nextLine().split(",");
			if(i!=0) {
			PolicyInfo p = new PolicyInfo();
			PolicyInfoBuilder pb = new PolicyInfoBuilder(p);
			
			p = pb //ä������ ��� �� �Ҵ�
					.policyName(data[0])
					.policyIntro(data[1])
					.Service(data[2])
					.Address(data[3])
					.policyInfo();
			 
			list.add(p); //����Ʈ �迭�� �߰�
			}
		  }
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	@Override
	public int getRowCount() { //���� ���� ��������
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() { //���� ���� ��������
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int row, int col) { //���̺� �� ã�� �Լ�
		// TODO Auto-generated method stub
		switch(col) {
		case 0:
			return list.get(row).getPolicyName();
		case 1:
			return list.get(row).getPolicyIntro();
		case 2:
			return list.get(row).getService();
		case 3:
			return list.get(row).getAddress();
		}
		return null;
	}
}