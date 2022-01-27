package day0127;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.View;

@SuppressWarnings("serial")
public class UseTableModel extends JFrame{
	public UseTableModel() {
		super("MVC 패턴을 도입한 클래스");
		
		//스크롤바를 가져야 컬럼명을 보여줄 수 있다
		String[] columnNames = {"번호", "이름", "나이", "이메일"};
		String[][] rowData= {{"1","정인선", "24", "jung@test.com"},
							{"2","장정우", "25", "jang@test.com"},
							{"3","김진영", "26", "kim@test.com"}
							
		};
		DefaultTableModel dtm = new DefaultTableModel(rowData, columnNames);
		JTable jt = new JTable(dtm);
		JScrollPane jsp = new JScrollPane(jt);
		
		//data추가
		String[] data = {"4","김현우", "27", "kim@test.com"};
		dtm.addRow(data);
		
		//디자인을 변경시 뷰클래스를 사용
		jt.setRowHeight(25);
		jt.setGridColor(Color.red);
		jt.setFont(new Font("맑은 고딕", Font.PLAIN, 15));
		
		//컬럼의 넓이를 변경 (JTable의 컬럼정보를 가진 객체를 얻어서 변경)
		jt.getColumnModel().getColumn(0).setPreferredWidth(40);
		jt.getColumnModel().getColumn(1).setPreferredWidth(120);
		jt.getColumnModel().getColumn(2).setPreferredWidth(40);
		jt.getColumnModel().getColumn(3).setPreferredWidth(250);
		
		//BorderLayout의 Center에 컴포넌트 배치
		add("Center", jsp);
		
		setSize(500, 400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	
	public static void main(String[] args) {
		new UseTableModel();
	}
}
