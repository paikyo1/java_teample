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
					EmployScreen frame = new EmployScreen(); //ä������ �ι� ������ ����
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
		
		EmPanel em = new EmPanel();//����Ʈ�ҿ� ä������ �г� �߰�
		c.add(em);
		em.setVisible(true);
		
		
	}
	class EmPanel extends JPanel{
		private JPanel contentPane; //����Ʈ��
		private JTable emTable; //ä������ ���̺�
		private JTable policyTable;
		private JTextField tfHour;
		private JTextField tfRate;
		
		public EmPanel() {
		
			EmData td = new EmData();
			PolicyData pd = new PolicyData();
			
			setTitle("���ػ� ������ Ŀ�´�Ƽ");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			ImageIcon img = new ImageIcon("./image/workicon.png");
			setIconImage(img.getImage());
			
			setBounds(100, 100, 1189, 559);
			contentPane = new JPanel(); //���ο��гη� ����Ʈ ���� ����
			contentPane.setBackground(new Color(255, 251, 245)); //����
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

			setContentPane(contentPane); //����Ʈ �� ����
			contentPane.setLayout(null);
			
			
			
			JPanel emPanel = new JPanel(); //������� �г�
			emPanel.setBounds(10, 10, 1149, 310);
			contentPane.add(emPanel); //����Ʈ�ҿ� �߰�
			emPanel.setLayout(null);
			
			
			
			emTable = new JTable(td); //ä������ ���̺�
			emTable.setBounds(12, 12, 1115, 270);
			emTable.setRowHeight(30);
			emTable.setPreferredScrollableViewportSize(new Dimension(1115,250)); //��ũ�ѹ� 
			JScrollPane scrollPane = new JScrollPane(emTable); //��ũ�ѹ� �߰�
			scrollPane.setBounds(16, 5, 1117, 278);
			emPanel.add(scrollPane);  //�гο� ���̺� �߰�
			emPanel.setOpaque(false);
			MyMouseListener listener = new MyMouseListener(); 
			emTable.addMouseListener(listener); //���콺 ������ �߰�
			
			JButton btnMain = new JButton("����ȭ��"); //����ȭ�� ��ư
			btnMain.setFont(new Font("����", Font.PLAIN, 17));
			btnMain.setBounds(950, 440, 156, 56);
			contentPane.add(btnMain); //����Ʈ�ҿ� �߰�
			
			JButton btnCalc = new JButton("���޼���"); //���޼��� ��ư
			btnCalc.setFont(new Font("����", Font.PLAIN, 17));
			btnCalc.setBounds(29, 440, 156, 56);
			contentPane.add(btnCalc); //����Ʈ�ҿ� �߰�
			
			JTableHeader header = emTable.getTableHeader(); //ä������ ���̺� ���
			header.setBackground(new Color(247, 239, 229));
			header.setForeground(new Color(0,0,0));
			header.setFont(new Font("Sansserif",Font.BOLD,15));
			
			JPanel calPanel = new JPanel(); // ���޼��� �г�
			calPanel.setVisible(false); //�г� ����
			calPanel.setBackground(new Color(247, 239, 229)); // ����
			calPanel.setForeground(new Color(0, 0, 0));
			calPanel.setBounds(215, 10, 741, 277);
			contentPane.add(calPanel);
			calPanel.setLayout(null);
			
			JLabel calcText = new JLabel("���޼��� ����"); //���� ���̺�
			calcText.setFont(new Font("����", Font.BOLD, 20));
			calcText.setBounds(267, 9, 151, 41);
			calPanel.add(calcText); //����гο� �߰�
			
			JLabel hour = new JLabel("�����ϰ� ���ѽð�");
			hour.setFont(new Font("����", Font.BOLD, 20));
			hour.setBounds(49, 62, 211, 33);
			calPanel.add(hour); //����гο� �߰�
			
			JLabel hourly_Rate = new JLabel("�ñ�");
			hourly_Rate.setFont(new Font("����", Font.BOLD, 20));
			hourly_Rate.setBounds(183, 119, 59, 33);
			calPanel.add(hourly_Rate); //����гο� �߰�
			
			tfHour = new JTextField();// ���ѽð� �ؽ�Ʈ�ʵ�
			tfHour.setBounds(267, 70, 178, 25);
			calPanel.add(tfHour); //����гο� �߰�
			tfHour.setColumns(10);
			
			tfRate = new JTextField(); //�ñ� �ؽ�Ʈ�ʵ�
			tfRate.setColumns(10);
			tfRate.setBounds(267, 119, 178, 25);
			calPanel.add(tfRate); //����гο� �߰�
			
			JLabel result = new JLabel(""); // ����� ���̺�
			result.setFont(new Font("����", Font.BOLD, 20));
			result.setBounds(262, 218, 206, 33);
			calPanel.add(result); //����гο� �߰�
			
			JButton btnAct = new JButton("����ϱ�"); //����ϱ� ��ư
			btnAct.setFont(new Font("����", Font.PLAIN, 16));
			btnAct.setBounds(297, 154, 112, 41);
			calPanel.add(btnAct); //����гο� �߰�
			
			JPanel policyPanel = new JPanel(); //�����å �г�
			policyPanel.setVisible(false);
			policyPanel.setLayout(null);
			policyPanel.setOpaque(false);
			policyPanel.setBounds(10, 10, 1149, 310);
			contentPane.add(policyPanel); //����Ʈ�ҿ� �߰�
			
			
			policyTable = new JTable(pd); //�����å ���̺�
			policyTable.setBounds(12, 12, 1115, 270);
			policyTable.setRowHeight(30); //���� ����
			policyTable.setPreferredScrollableViewportSize(new Dimension(1115,250));
			JScrollPane scrollPane_1 = new JScrollPane(policyTable);
			scrollPane_1.setBounds(16, 5, 1117, 278);
			policyPanel.add(scrollPane_1); //�гο� ���̺� �߰�
			policyPanel.setOpaque(false);
			
			policyTable.addMouseListener(listener); //���콺������ �߰�
			
			JTableHeader policyHeader = policyTable.getTableHeader();
			policyHeader.setBackground(new Color(247, 239, 229));
			policyHeader.setForeground(new Color(0,0,0));
			policyHeader.setFont(new Font("Sansserif",Font.BOLD,15));
			

			
			JButton btnPolicy = new JButton("�����å"); //�����å ��ư
			btnPolicy.setFont(new Font("����", Font.PLAIN, 17));
			btnPolicy.setBounds(269, 440, 156, 56);
			contentPane.add(btnPolicy);
			
			JButton btnEm = new JButton("ä������"); // ü������ ��ư
			btnEm.setFont(new Font("����", Font.PLAIN, 16));
			btnEm.setBounds(516, 440, 150, 56);
			contentPane.add(btnEm);
			
			btnPolicy.addActionListener(new ActionListener() { //�����å ��ư �׼Ǹ�����
				public void actionPerformed(ActionEvent e) {
					emPanel.setVisible(false);
					calPanel.setVisible(false);
					policyPanel.setVisible(true);
				}
			});
			
			btnEm.addActionListener(new ActionListener() { //ä������ ��ư �׼Ǹ����� (�г���ȯ)
				public void actionPerformed(ActionEvent e) {
					calPanel.setVisible(false);
					policyPanel.setVisible(false);
					emPanel.setVisible(true);
				}
			});
			
			btnCalc.addActionListener(new ActionListener() { //���޼��� ��ư �׼Ǹ����� (�г���ȯ)
				public void actionPerformed(ActionEvent e) {
					emPanel.setVisible(false);
					policyPanel.setVisible(false);
					calPanel.setVisible(true);
				}
			});
			btnAct.addActionListener(new ActionListener() { //����ϱ� ��ư �׼Ǹ����� (���޼��� ���)
				public void actionPerformed(ActionEvent e) {
					try {
					 String s1 = tfHour.getText();
					 String s2 = tfRate.getText();
					
					
					 int hours = Integer.parseInt(s1); //���ڿ��� ������
					 int money = Integer.parseInt(s2);
					
					 int result1 = (int) (hours * money * 0.2); //���
					 String result2 = Integer.toString(result1);
					 result2 = result2 + "��";
					 result.setText(result2); //��갪 ����
					}
					catch(Exception e1) {result.setText("���ڸ� �Է����ּ���");} //�Է¿����϶�
					finally {}
					
				}
			});
		}
		class MyMouseListener extends MouseAdapter { // ���콺 ������ (ǥ�� Ŭ�������� ���ο� â�� ����)
			@Override
			public void mouseClicked(MouseEvent e) { //���콺 Ŭ���Ҷ� ������ â�� ����


				Const frame1 = new Const();
				frame1.setVisible(true);
				
			}
			

		}
		
	}
}
