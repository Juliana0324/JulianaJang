package homework0308;

import java.sql.SQLException;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class Homework0308Main extends JFrame{
	private JTextArea carinfo;
	private JScrollPane jspJtaOutput;
	public Homework0308Main() {
		String model = JOptionPane.showInputDialog("����������");
		carinfo = new JTextArea();
		searchCar(model);
		
		jspJtaOutput=new JScrollPane(carinfo);
		jspJtaOutput.setBorder(new TitledBorder("��ȸ ���"));
		add(jspJtaOutput);
		
		setBounds(100,100,600,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void searchCar(String model) {
		CarDAO cdao = CarDAO.getInstance();
		try {
			List<CarVO> list = cdao.searchCar(model);
			
			StringBuilder output= new StringBuilder();
			output.append("������\t ������\t �𵨸�\t ����\t ����\t �ɼ�\n");
			CarVO cVO=null;
			for(int i=0; i<list.size();i++) {
				cVO=list.get(i);
				output
				.append(cVO.getCountry()).append("\t")
				.append(cVO.getMaker()).append("\t")
				.append(cVO.getModel()).append("\t")
				.append(cVO.getCarYear()).append("\t")
				.append(cVO.getPrice()).append("\t")
				.append(cVO.getCarOption()).append("\n");
			}
			if(list.isEmpty()) {
				output.append("������ �������� �ʽ��ϴ�.");
			}
			carinfo.setText(output.toString());
		}catch (SQLException e) {
			// TODO: handle exception
		}
	}
	
	public static void main(String[] args) {
		new Homework0308Main();
	}
}
