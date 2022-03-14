package day0314;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

public class ZipcodeView extends JFrame implements ActionListener {

	/**
	 *  03-14-2022
	 */
	private static final long serialVersionUID = 1285468668584200439L;

	private JTextField jtfDong;
	private DefaultTableModel dtmZipcode;
	private JTable jtZipcode;
	private JScrollPane jspZipcode;
	private JButton jbtnSearch;
	
	public ZipcodeView() {
		super("우편번호 검색");
		jtfDong=new JTextField(10);
		
		String[] columnNames= {"우편번호","주소"};
		dtmZipcode=new DefaultTableModel(columnNames, 0);
		jtZipcode=new JTable( dtmZipcode );
		jtZipcode.setRowHeight(20);
		jtZipcode.getColumnModel().getColumn(0).setPreferredWidth(70);
		jtZipcode.getColumnModel().getColumn(1).setPreferredWidth(530);
		
		jspZipcode=new JScrollPane( jtZipcode );
		jspZipcode.setBorder(new TitledBorder("조회결과"));
		
		
		jbtnSearch=new JButton("조회");
		
		JPanel jpNorth=new JPanel();
		jpNorth.add(new JLabel("동 입력)"));
		jpNorth.add(jtfDong);
		jpNorth.add(jbtnSearch);
		jpNorth.setBorder(new TitledBorder("동 이름만 입력"));

		add("North", jpNorth);
		add("Center",jspZipcode);
		
		jbtnSearch.addActionListener(this);
		
		setBounds(100,100,600,400);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}//ZipcodeView
	
	/**
	 * Default table 모델에 조회된 우편번호를 설정하는일
	 */
	private void setZipcode() {
		String dong = jtfDong.getText().trim();
		
		if("".equals(dong)) {
			JOptionPane.showMessageDialog(this, "동은 필수 입력");
			jtfDong.requestFocus();
			return;
		}
		
		ZipcodeDAO zDAO= ZipcodeDAO.getInstance();
		try {
			List<ZipcodeVO> listZip=zDAO.selectPreparedStatement(dong);
			//defaultTableModel에 넣기
			//테이블의 레코드를 초기화
			dtmZipcode.setRowCount(0);
			
			//조회된 데이터를 DefaultTableMdel에 설정하ㅣㄱ 위한 배열선언
			Object[] rowData=null;
			StringBuilder sbAddr = new StringBuilder();
			for(ZipcodeVO zVO:listZip) {
				rowData=new Object[2]; //우편번호, 주소(시도,구군,동,번지 로 구성)
				rowData[0]=zVO.getZipcode();
				
				sbAddr.append(zVO.getSido()).append(" ")
				.append(zVO.getGugun()).append(" ").append(zVO.getDong()).append(" ")
				.append(zVO.getBunji());
				rowData[1]=sbAddr.toString();
				
				//설정된 우편번호와 주소를 가진 배열을 DefaultTableModel설정
				dtmZipcode.addRow(rowData);
				sbAddr.delete(0, sbAddr.length());
			}
			
			if(listZip.isEmpty()) {
				rowData=new Object[2];
				rowData[0]="";
				rowData[1]=dong+"은 존재하지 않습니다.";
				dtmZipcode.addRow(rowData);
			}
			jtfDong.setText("");
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent ae) {
		setZipcode();
	}//actionPerformed

	public static void main(String[] args) {
		new ZipcodeView();
	}//main

}//class
