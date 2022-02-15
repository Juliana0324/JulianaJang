package day0127;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class TestEvent extends JFrame implements ActionListener{
	//이벤트 처리관련 컴포넌트 선언
	private JButton jbtn,jbtn2;
	private int cnt=0;
	
	public TestEvent() {
		super("is a Event 처리시행 방법");
		//3. 컴포넌트 객체화
		jbtn = new JButton("종료");
		jbtn2 = new JButton("추가");
		
		//4. 컴포넌트의 이벤트 등록
		jbtn.addActionListener(this); //버튼에서 이벤트가 발생하면 this에서 구현한 method가 호출
		jbtn2.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				cnt++;
				System.out.println(cnt);
			}
		}); //버튼에서 이벤트가 발생하면 method 내에서 호출
		
		//5. 5 배치
		JPanel jp = new JPanel();
		jp.add(jbtn); //버튼이 고유크기를 가지고 패널에 배치		
		jp.add(jbtn2); //버튼이 고유크기를 가지고 패널에 배치
		add("Center", jp);

		//6. 윈도우 
		setSize(300,300);
		setVisible(true);
		//7. 종료처리
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}
	
	//8. 추상메소드 오버라이딩
	public void actionPerformed(ActionEvent ae) {
		//9. 이벤트가 발생시 사용자에게 제공할 코드
		System.out.println("버튼이 눌렸음");
		//종료 이벤트 처리
		dispose();
	}
	
	public static void main(String[] args) {
		new TestEvent();
	}

}
