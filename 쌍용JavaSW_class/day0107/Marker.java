package day0107;

/**
 * Marker���� �߻�ȭ�Ͽ� ������ Ŭ����
 * ����� Ư¡ : �Ѳ�, ��ü, ��
 * ������ Ư¡ : ����
 * @author user
 *
 */
public class Marker {
	private int cap;
	private int body;
	private String color;
	
	/**
	 * ĥ�ǿ� ������ ��ī�� ��ü�� ����Ͽ� "�ȳ��ϼ���?"�� ���� ��
	 * @return message
	 */
	public String write() {
		return "�Ѳ� "+ cap +"�� "+body +"�� "+ color +"���� ��ī������ \"�ȳ��ϼ���?\"�� ĥ�ǿ� ����";
	}
	
	/**
	 * ĥ�ǿ� ������ ��ī�� ��ü�� ����Ͽ� �Էµ� �޼����� ���� ��
	 * @return msg
	 */
	public String write(String msg) {
		return color +"���� ��ī������ \""+msg+"\"�� ĥ�ǿ� ����";
	}

	/**
	 * ������ ��ī�� ��ü�� �Ѳ��� ������ �����ϴ���
	 * @param cap ������ �Ѳ��� ����
	 */
	public void setCap(int cap) {
		this.cap = cap;
	}

	/**
	 * ������ ��ī�� ��ü�� �Ѳ��� ���� ��ȯ�ϴ� ��
	 * @return �Ѳ��� ����
	 */
	public int getCap() {
		return cap;
	}
	
	
	/** 
	 * ������ ��ī�� ��ü�� ��ü�� ���� ����
	 * @param body 
	 */
	public void setBody(int body) {
		this.body = body;
	}

	/** 
	 * ������ ��ī�� ��ü�� ��ü�� ���� ��ȯ
	 * @return body 
	 */
	public int getBody() {
		return body;
	}



	/**
	 * ������ ��ī���� ���� ����
	 * @param color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * ������ ��ī���� ���� ��ȯ
	 * @return color
	 */
	public String getColor() {
		return color;
	}

	
}
