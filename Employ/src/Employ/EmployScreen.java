package Employ;

import java.awt.*;
import java.awt.event.*;


import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.JTableHeader;





@SuppressWarnings("serial")
public class EmployScreen extends JFrame {



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployScreen frame = new EmployScreen(); //채용정보 부문 프레임 열기
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	/**
	 * Create the frame.
	 */
	public EmployScreen() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane(); 
		setBounds(100, 100, 1189, 559);
		
		EmPanel em = new EmPanel();//컨탠트팬에 채용정보 패널 추가
		c.add(em);
		em.setVisible(true);
		
		
	}
	class EmPanel extends JPanel{
		private JPanel contentPane; //컨탠트팬
		private JTable emTable; //채용정보 테이블
		private JTable policyTable;
		private JTextField tfHour;
		private JTextField tfRate;
		
		public EmPanel() {
		
			EmData td = new EmData();
			PolicyData pd = new PolicyData();
			
			setTitle("취준생 맞춤형 커뮤니티");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon img = new ImageIcon("./image/workicon.png");
			setIconImage(img.getImage());
			
			setBounds(100, 100, 1189, 559);
			contentPane = new JPanel(); //새로운패널로 컨탠트 팬을 만듦
			contentPane.setBackground(new Color(255, 251, 245)); //배경색
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane); //컨탠트 팬 설정
			contentPane.setLayout(null);
			
			
			
			JPanel emPanel = new JPanel(); //고용정보 패널
			emPanel.setBounds(10, 10, 1149, 310);
			contentPane.add(emPanel); //컨탠트팬에 추가
			emPanel.setLayout(null);
			
			
			
			emTable = new JTable(td); //채용정보 테이블
			emTable.setBounds(12, 12, 1115, 270);
			emTable.setRowHeight(30);
			emTable.setPreferredScrollableViewportSize(new Dimension(1115,250)); //스크롤바 
			JScrollPane scrollPane = new JScrollPane(emTable); //스크롤바 추가
			scrollPane.setBounds(16, 5, 1117, 278);
			emPanel.add(scrollPane);  //패널에 테이블 추가
			emPanel.setOpaque(false);
			MyMouseListener listener = new MyMouseListener(); 
			emTable.addMouseListener(listener); //마우스 리스너 추가
			
			JButton btnMain = new JButton("메인화면"); //메인화면 버튼
			btnMain.setFont(new Font("굴림", Font.PLAIN, 17));
			btnMain.setBounds(950, 440, 156, 56);
			contentPane.add(btnMain); //컨탠트팬에 추가
			
			JButton btnCalc = new JButton("주휴수당"); //주휴수당 버튼
			btnCalc.setFont(new Font("굴림", Font.PLAIN, 17));
			btnCalc.setBounds(29, 440, 156, 56);
			contentPane.add(btnCalc); //컨탠트팬에 추가
			
			JTableHeader header = emTable.getTableHeader(); //채용정보 테이블 헤더
			header.setBackground(new Color(247, 239, 229));
			header.setForeground(new Color(0,0,0));
			header.setFont(new Font("Sansserif",Font.BOLD,15));
			
			JPanel calPanel = new JPanel(); // 주휴수당 패널
			calPanel.setVisible(false); //패널 숨김
			calPanel.setBackground(new Color(247, 239, 229)); // 배경색
			calPanel.setForeground(new Color(0, 0, 0));
			calPanel.setBounds(215, 10, 741, 277);
			contentPane.add(calPanel);
			calPanel.setLayout(null);
			
			JLabel calcText = new JLabel("주휴수당 계산기"); //계산기 레이블
			calcText.setFont(new Font("굴림", Font.BOLD, 20));
			calcText.setBounds(267, 9, 151, 41);
			calPanel.add(calcText); //계산패널에 추가
			
			JLabel hour = new JLabel("일주일간 일한시간");
			hour.setFont(new Font("굴림", Font.BOLD, 20));
			hour.setBounds(49, 62, 211, 33);
			calPanel.add(hour); //계산패널에 추가
			
			JLabel hourly_Rate = new JLabel("시급");
			hourly_Rate.setFont(new Font("굴림", Font.BOLD, 20));
			hourly_Rate.setBounds(183, 119, 59, 33);
			calPanel.add(hourly_Rate); //계산패널에 추가
			
			tfHour = new JTextField();// 일한시간 텍스트필드
			tfHour.setBounds(267, 70, 178, 25);
			calPanel.add(tfHour); //계산패널에 추가
			tfHour.setColumns(10);
			
			tfRate = new JTextField(); //시급 텍스트필드
			tfRate.setColumns(10);
			tfRate.setBounds(267, 119, 178, 25);
			calPanel.add(tfRate); //계산패널에 추가
			
			JLabel result = new JLabel(""); // 계산결과 레이블
			result.setFont(new Font("굴림", Font.BOLD, 20));
			result.setBounds(262, 218, 206, 33);
			calPanel.add(result); //계산패널에 추가
			
			JButton btnAct = new JButton("계산하기"); //계산하기 버튼
			btnAct.setFont(new Font("굴림", Font.PLAIN, 16));
			btnAct.setBounds(297, 154, 112, 41);
			calPanel.add(btnAct); //계산패널에 추가
			
			JPanel policyPanel = new JPanel(); //고용정책 패널
			policyPanel.setVisible(false);
			policyPanel.setLayout(null);
			policyPanel.setOpaque(false);
			policyPanel.setBounds(10, 10, 1149, 310);
			contentPane.add(policyPanel); //컨탠트팬에 추가
			
			
			policyTable = new JTable(pd); //고용정책 테이블
			policyTable.setBounds(12, 12, 1115, 270);
			policyTable.setRowHeight(30); //행의 길이
			policyTable.setPreferredScrollableViewportSize(new Dimension(1115,250));
			JScrollPane scrollPane_1 = new JScrollPane(policyTable);
			scrollPane_1.setBounds(16, 5, 1117, 278);
			policyPanel.add(scrollPane_1); //패널에 테이블 추가
			policyPanel.setOpaque(false);
			
			policyTable.addMouseListener(listener); //마우스리스너 추가
			
			JTableHeader policyHeader = policyTable.getTableHeader();
			policyHeader.setBackground(new Color(247, 239, 229));
			policyHeader.setForeground(new Color(0,0,0));
			policyHeader.setFont(new Font("Sansserif",Font.BOLD,15));
			

			
			JButton btnPolicy = new JButton("고용정책"); //고용정책 버튼
			btnPolicy.setFont(new Font("굴림", Font.PLAIN, 17));
			btnPolicy.setBounds(269, 440, 156, 56);
			contentPane.add(btnPolicy);
			
			JButton btnEm = new JButton("채용정보"); // 체용정보 버튼
			btnEm.setFont(new Font("굴림", Font.PLAIN, 16));
			btnEm.setBounds(516, 440, 150, 56);
			contentPane.add(btnEm);
			
			btnPolicy.addActionListener(new ActionListener() { //고용정책 버튼 액션리스너
				public void actionPerformed(ActionEvent e) {
					emPanel.setVisible(false);
					calPanel.setVisible(false);
					policyPanel.setVisible(true);
				}
			});
			
			btnEm.addActionListener(new ActionListener() { //채용정보 버튼 액션리스너 (패널전환)
				public void actionPerformed(ActionEvent e) {
					calPanel.setVisible(false);
					policyPanel.setVisible(false);
					emPanel.setVisible(true);
				}
			});
			
			btnCalc.addActionListener(new ActionListener() { //주휴수당 버튼 액션리스너 (패널전환)
				public void actionPerformed(ActionEvent e) {
					emPanel.setVisible(false);
					policyPanel.setVisible(false);
					calPanel.setVisible(true);
				}
			});
			btnAct.addActionListener(new ActionListener() { //계산하기 버튼 액션리스너 (주휴수당 계산)
				public void actionPerformed(ActionEvent e) {
					try {
					 String s1 = tfHour.getText();
					 String s2 = tfRate.getText();
					
					
					 int hours = Integer.parseInt(s1); //문자열을 정수로
					 int money = Integer.parseInt(s2);
					
					 int result1 = (int) (hours * money * 0.2); //계산
					 String result2 = Integer.toString(result1);
					 result2 = result2 + "원";
					 result.setText(result2); //계산값 적용
					}
					catch(Exception e1) {result.setText("숫자를 입력해주세요");} //입력오류일때
					finally {}
					
				}
			});
		}
		class MyMouseListener extends MouseAdapter { // 마우스 리스너 (표를 클릭했을때 새로운 창을 생성)
			@Override
			public void mouseClicked(MouseEvent e) { //마우스 클릭할때 공사중 창을 생성


				Const frame1 = new Const();
				frame1.setVisible(true);
				
			}
			

		}
		
	}
}
