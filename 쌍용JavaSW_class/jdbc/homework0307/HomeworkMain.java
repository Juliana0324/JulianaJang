package homework0307;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.border.TitledBorder;


public class HomeworkMain extends JFrame implements ActionListener{
	JButton jbtnTable;
	JComboBox<String> tableList;
	JTextArea jtaSearch;
	JScrollPane jspOutput;
	public HomeworkMain() {
		super("숙제");
		jbtnTable = new JButton("테이블명");
		String[] tableType = {"user_tab_cols", "tab"};
		tableList=new JComboBox<String>(tableType);
		jtaSearch = new JTextArea();
		
		JPanel jpn= new JPanel();
		jpn.setBorder(new TitledBorder("모든테이블 조회"));
		
		jpn.add(jbtnTable);
		jpn.add(tableList);
		
		jbtnTable.addActionListener(this);
		jspOutput=new JScrollPane(jtaSearch);
		jspOutput.setBorder(new TitledBorder("조회 결과"));
		
		add("North", jpn);
		add("Center", jspOutput);
		
		setBounds(100,100,500,600);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		
	}
	
	
	public static void main(String[] args) {
		new HomeworkMain();
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		String selectJrb="user_tab_cols";
		
		if(tableList.getSelectedItem().equals("tab")) {
			selectJrb="tab";
		}
		
		searchData(selectJrb);
	}//actionPerformed

	
	public void searchData(String tableName) {
		switch ( JOptionPane.showConfirmDialog(this, tableName+"의 모든 테이블을 검색하시겠습니까?")){
		case JOptionPane.OK_OPTION:
			String name="user_tab_cols";
			TableNameDAO tdao = TableNameDAO.getInstance();
			
			if("tab".equals(tableName)) {
				name="tab";
				try {
					List<TableVO> list=tdao.selectAllTab(name);
					StringBuilder outputBuilder = new StringBuilder();
					
					outputBuilder.append("테이블명\tTabType\t\tClusterId\n");
					TableVO tvo=null;
					for(int i=0; i<list.size();i++) {
						tvo=list.get(i);
						outputBuilder.append(tvo.getTname()).append("\t")
						.append(tvo.getTabtype()).append("\t\t")
						.append(tvo.getClusterid()).append("\n");
					}
					if(list.isEmpty()) {
						outputBuilder.append("정보가 존재하지 않습니다.");
						
					}
					jtaSearch.setText(outputBuilder.toString());
					
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			try {
				List<TableVO> list=tdao.selectUTC(name);
				StringBuilder outputBuilder = new StringBuilder();
				
				outputBuilder.append("테이블명\t\t칼럼명\t\tdata_length\n");
				for(TableVO tvo: list) {
					outputBuilder.append(tvo.getTname()).append("\t")
					.append(tvo.getColumn_name()).append("\t")
					.append(tvo.getData_length()).append("\n");
				}
				if(list.isEmpty()) {
					outputBuilder.append("정보가 존재하지 않습니다.");
					
				}
				jtaSearch.setText(outputBuilder.toString());
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		
			
		}
		
	}
