package day0127;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class UseActionEvent extends JFrame implements ActionListener{
	private JTextField jtfName ;
	private JTextArea jtaNameDisp;
	private JButton jbtnAdd; 
	private List<String> arr = new ArrayList<String>();
	
	public UseActionEvent() {
		super("버튼류에서 발생하는 이벤트");
		//2. 컴포넌트 생성
		// 일반컴포넌트 - 기능제공
		JLabel jlblName = new JLabel("이름");
		jtfName = new JTextField(10);	//인스턴스 변수의 생성
		jbtnAdd = new JButton("추가");	//인스턴스 변수의 생성
		jtaNameDisp = new JTextArea();	//인스턴스 변수의 생성
		JButton jbtnList = new JButton("보기");
		
		System.out.println(jtfName);
		System.out.println(jbtnAdd);
		
		// 컨테이너 컴포넌트(FlowLayout) 일반 컴포넌트를 배치
		JPanel jpNorth = new JPanel();
		
		//E- 4: 컴포넌트가 이벤트를 발생시킬 수 있도록 이벤트에 등록시킬 수 있음
		jbtnAdd.addActionListener(this); //버튼클릭
		jtfName.addActionListener(this); //enter가 눌려도! 가능
		jbtnList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(arr);
				
			}
		});
		
		//3. 배치
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnAdd);
		jpNorth.add(jbtnList);
		
		
		//윈도우 컴포넌트(BorderLayout) 배치
		add("North", jpNorth);
		add("Center", jtaNameDisp);
		
		//4.윈도우 크기설정+가시화
		setSize(400,400);		
		setVisible(true);
		//5. 종료이벤트
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//추상매소드 오버라이딩
	@Override
	public void actionPerformed(ActionEvent e) {
		//E-3이벤트가 발생했을때 사용자에게 제공할 코드
		// 버튼이 눌리면 JTextField값을 얻어와서
		//TextArea에 넣는다
		String name = jtfName.getText();

		//getSource : 이벤트를 발생시킨 객체 자신
//		System.out.println("이벤트 발생 객체: "+e.getSource());
		String source ="";
		//버튼으로 눌렸는가?
		if(e.getSource() == jbtnAdd) {
			source = "버튼";
		}//textfield에서 됐는가?
		if(e.getSource() == jtfName) {
			source = "텍스트 필드";
		}
		
		//setText: 기존의 값을 지우고 새로 설정함
		//jtaNameDisp.setText(name);
		jtaNameDisp.append(source+" : "+name+"\n");
		arr.add(name);
		JOptionPane.showMessageDialog(null, "리스트에 추가되었습니다.");
		
		//JTextfield의 값을 삭제
		jtfName.setText("");
	}
	
	public static void main(String[] args) {
		new UseActionEvent();
	}

}
