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
		String model = JOptionPane.showInputDialog("차량제조사");
		carinfo = new JTextArea();
		searchCar(model);
		
		jspJtaOutput=new JScrollPane(carinfo);
		jspJtaOutput.setBorder(new TitledBorder("조회 결과"));
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
			output.append("제조국\t 제조명\t 모델명\t 연식\t 가격\t 옵션\n");
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
				output.append("정보가 존재하지 않습니다.");
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
