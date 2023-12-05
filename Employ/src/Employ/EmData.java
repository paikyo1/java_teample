package Employ;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.table.AbstractTableModel;
@SuppressWarnings("serial")
public class EmData extends AbstractTableModel {
	private List<EmInfo> list;
	private String[] headers = {"회사명","채용공고명","담당업무","지원자격","등록일","마감일"};
	public EmData() {
		updateList();
	}
	
	public String getColumnName(int cell) { //테이블 열머리 이름 구하는 함수
		return headers[cell];
	}
	
	public void updateList() { //테이블의 내용 갱신하는 함수
		list = new ArrayList<>();
		try {
		
		Scanner sc = new Scanner(new File("./data.csv"));
		for(int i = 0;sc.hasNextLine();i++) {
			String[] data = sc.nextLine().split(",");
			if(i!=0) {
			EmInfo e = new EmInfo();
			EmInfoBuilder eb = new EmInfoBuilder(e);
			
			e = eb //채용정보 멤버 값 할당
					.companyName(data[0])
					.Title(data[1])
					.Task(data[2])
					.Requirements(data[3])
					.startDate(data[4])
					.endDate(data[5])
					.emInfo();
			 
			list.add(e); //리스트 배열에 추가
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
		return 6;
	}

	@Override
	public Object getValueAt(int row, int col) { //테이블 값 찾는 함수
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