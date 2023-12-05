package Employ;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class EmData extends AbstractTableModel {
	private List<EmInfo> list;
	private String[] headers = {"ȸ���","ä�������","������","�����ڰ�","�����","������"};
	public EmData() {
		updateList();
	}
	
	public String getColumnName(int cell) { //���̺� ���Ӹ� �̸� ���ϴ� �Լ�
		return headers[cell];
	}
	
	public void updateList() { //���̺��� ���� �����ϴ� �Լ�
		list = new ArrayList<>();
		try {
		
		Scanner sc = new Scanner(new File("./data.csv"));
		for(int i = 0;sc.hasNextLine();i++) {
			String[] data = sc.nextLine().split(",");
			if(i!=0) {
			EmInfo e = new EmInfo();
			EmInfoBuilder eb = new EmInfoBuilder(e);
			
			e = eb //ä������ ��� �� �Ҵ�
					.companyName(data[0])
					.Title(data[1])
					.Task(data[2])
					.Requirements(data[3])
					.startDate(data[4])
					.endDate(data[5])
					.emInfo();
			 
			list.add(e); //����Ʈ �迭�� �߰�
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
		return 6;
	}

	@Override
	public Object getValueAt(int row, int col) { //���̺� �� ã�� �Լ�
		// TODO Auto-generated method stub
		switch(col) {
		case 0:
			return list.get(row).getCompanyName();
		case 1:
			return list.get(row).getTitle();
		case 2:
			return list.get(row).getDescription();
		case 3:
			return list.get(row).getRequirements();
		case 4:
			return list.get(row).getStartDate();
		case 5:
			return list.get(row).getEndDate();
		}
		return null;
	}



}