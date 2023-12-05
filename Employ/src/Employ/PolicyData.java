package Employ;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class PolicyData extends AbstractTableModel {
	private List<PolicyInfo> list;
	private String[] headers = {"정책명","정책소개","서비스목적","홈페이지"};
	public PolicyData() {
		updateList();
	}
	
	public String getColumnName(int cell) { //테이블 열머리 이름 구하는 함수
		return headers[cell];
	}
	
	public void updateList() { //테이블의 내용 갱신하는 함수
		list = new ArrayList<>();
		try {
		
		Scanner sc = new Scanner(new File("./policydata.csv"));
		for(int i = 0;sc.hasNextLine();i++) {
			String[] data = sc.nextLine().split(",");
			if(i!=0) {
			PolicyInfo p = new PolicyInfo();
			PolicyInfoBuilder pb = new PolicyInfoBuilder(p);
			
			p = pb //채용정보 멤버 값 할당
					.policyName(data[0])
					.policyIntro(data[1])
					.Service(data[2])
					.Address(data[3])
					.policyInfo();
			 
			list.add(p); //리스트 배열에 추가
			}
		  }
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	

	@Override
	public int getRowCount() { //행의 개수 가져오기
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public int getColumnCount() { //열의 개수 가져오기
		// TODO Auto-generated method stub
		return 4;
	}

	@Override
	public Object getValueAt(int row, int col) { //테이블 값 찾는 함수
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