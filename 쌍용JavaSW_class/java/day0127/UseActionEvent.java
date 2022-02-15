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
		super("��ư������ �߻��ϴ� �̺�Ʈ");
		//2. ������Ʈ ����
		// �Ϲ�������Ʈ - �������
		JLabel jlblName = new JLabel("�̸�");
		jtfName = new JTextField(10);	//�ν��Ͻ� ������ ����
		jbtnAdd = new JButton("�߰�");	//�ν��Ͻ� ������ ����
		jtaNameDisp = new JTextArea();	//�ν��Ͻ� ������ ����
		JButton jbtnList = new JButton("����");
		
		System.out.println(jtfName);
		System.out.println(jbtnAdd);
		
		// �����̳� ������Ʈ(FlowLayout) �Ϲ� ������Ʈ�� ��ġ
		JPanel jpNorth = new JPanel();
		
		//E- 4: ������Ʈ�� �̺�Ʈ�� �߻���ų �� �ֵ��� �̺�Ʈ�� ��Ͻ�ų �� ����
		jbtnAdd.addActionListener(this); //��ưŬ��
		jtfName.addActionListener(this); //enter�� ������! ����
		jbtnList.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println(arr);
				
			}
		});
		
		//3. ��ġ
		jpNorth.add(jlblName);
		jpNorth.add(jtfName);
		jpNorth.add(jbtnAdd);
		jpNorth.add(jbtnList);
		
		
		//������ ������Ʈ(BorderLayout) ��ġ
		add("North", jpNorth);
		add("Center", jtaNameDisp);
		
		//4.������ ũ�⼳��+����ȭ
		setSize(400,400);		
		setVisible(true);
		//5. �����̺�Ʈ
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	}
	
	//�߻�żҵ� �������̵�
	@Override
	public void actionPerformed(ActionEvent e) {
		//E-3�̺�Ʈ�� �߻������� ����ڿ��� ������ �ڵ�
		// ��ư�� ������ JTextField���� ���ͼ�
		//TextArea�� �ִ´�
		String name = jtfName.getText();

		//getSource : �̺�Ʈ�� �߻���Ų ��ü �ڽ�
//		System.out.println("�̺�Ʈ �߻� ��ü: "+e.getSource());
		String source ="";
		//��ư���� ���ȴ°�?
		if(e.getSource() == jbtnAdd) {
			source = "��ư";
		}//textfield���� �ƴ°�?
		if(e.getSource() == jtfName) {
			source = "�ؽ�Ʈ �ʵ�";
		}
		
		//setText: ������ ���� ����� ���� ������
		//jtaNameDisp.setText(name);
		jtaNameDisp.append(source+" : "+name+"\n");
		arr.add(name);
		JOptionPane.showMessageDialog(null, "����Ʈ�� �߰��Ǿ����ϴ�.");
		
		//JTextfield�� ���� ����
		jtfName.setText("");
	}
	
	public static void main(String[] args) {
		new UseActionEvent();
	}

}
