package homework0304;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;


@SuppressWarnings("serial")
public class Homework0304Menu extends JFrame implements ActionListener{
	HomeworkDAO dao;
	JLabel jlblModel;
	JTextField jtfModel;
	JButton search, carList;
	JTextArea info;
	
	public Homework0304Menu() {
		jlblModel=new JLabel("�𵨸�");
		jtfModel= new JTextField();
		search= new JButton("�˻�");
		carList = new JButton("�������");
		info= new JTextArea();
		JScrollPane jsp = new JScrollPane(info);
		
		setLayout(null);
		add(jlblModel);
		add(jtfModel);
		add(search);
		add(carList);
		add(jsp);
		
		search.addActionListener(this);
		carList.addActionListener(this);
		
		jlblModel.setBounds(10,10, 50,50);
		jtfModel.setBounds(60,20, 100,30);
		search.setBounds(170, 20, 80,30);
		carList.setBounds(270, 20, 100,30);
		jsp.setBounds(10,60, 400,170);
		setSize(450, 300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		new Homework0304Menu();
		
	}
	
	public void seachAll() {
		dao= new HomeworkDAO();
		try {
			List<CarVO> carList=dao.searchAllVO();
			
			StringBuilder outputData = new StringBuilder();
			outputData.append("��ü �� ��ȸ\n");
			outputData.append("MAKER\t MODEL\n");
			
			if(carList.isEmpty()) {
				outputData.append("��ȸ�� �� ������ �����ϴ�.");
			}
			
			//����Ʈ�� �ݺ����� ��������� ����Ѵ�
			for(CarVO selectAllVO:carList) {
				//��¥ó��
				outputData
				.append(selectAllVO.getMaker()).append("\t")
				.append(selectAllVO.getModel()).append("\n");
			}

			int cnt= carList.size();
			JTextArea jta= new JTextArea(outputData.toString(),15,60);
			JScrollPane jsp= new JScrollPane(jta);
			jsp.setBorder(new TitledBorder("��ü �� ���� ��ȸ"));
			JOptionPane.showMessageDialog(null, jsp);
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		}
	}
	
	public void searchOneCar(String model) {
		dao=new HomeworkDAO();
		try {
			CarVO selectOneVO=dao.selectOneCar(model);
			StringBuilder inputData=new StringBuilder();
			if(selectOneVO==null) {
				inputData.append("��ȸ�� ������ �����ϴ�.");
			}else {
			inputData.append("�𵨸�\t ����\t����\t����\t�̹���\t����\n")
			.append(selectOneVO.getModel()).append("\t")
			.append(selectOneVO.getCar_year()).append("\t")
			.append(selectOneVO.getPrice()).append("\t")
			.append(selectOneVO.getCc()).append("\t")
			.append(selectOneVO.getCar_img()).append("\t")
			.append(selectOneVO.getHiredate()).append("\n")
			.append("�ɼ�\n")
			.append(selectOneVO.getCar_option());
			}
			info.setText(inputData.toString());
		}catch(SQLException se) {
			JOptionPane.showMessageDialog(null, "���������� ��ȸ�� �� �����ϴ�.");
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==search) {
			System.out.println("���� ���� ��ȸ");
			searchOneCar(jtfModel.getText());
		}
		if(e.getSource()==carList) {
			System.out.println("���������ȸ");
			seachAll();
		}
	}
}
