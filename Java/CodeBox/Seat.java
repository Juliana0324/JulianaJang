package CodeBox;

public class Seat {
    // ���⿡ �ڵ带 �ۼ��ϼ���.
	
	//������ �̸����
	private String name;
	
	//������ �̸� ����
	public String getName() {
		return name;
	}
	
	//������ �̸� ����
	public void reserve(String name) {
		this.name = name;
	}
	
	//����� �̸� �����ֱ� name = null
	public void cancel() {
		this.name = null;
	}
	
	//�̹� ����� �ڸ����� Ȯ��
	public boolean isOccupied() {
		if(name !=null) return true;	
		else return false;
	}
	
	//checkName�̶�� �̸����� ����� �ڸ����� Ȯ���ϰ�, �Ҹ����� �������ݴϴ�.
	public boolean match(String checkName) {
		if(checkName.equals(name)) return true;
		return false;
	}
	
	
}