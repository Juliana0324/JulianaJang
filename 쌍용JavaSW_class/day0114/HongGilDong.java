package day0114;

/**
 * ����� ���� Ư¡(��,��,��,�̸�, �Դ���)�� PersonŬ�������� ������ ����ϰ�
 * �ڽ�Ŭ����
 * 
 * �ο򷹺��� 1-10���� ���� 
 * ��� ������ �ο��� 3���� ����
 * @author user
 *
 */
public class HongGilDong extends Person{
	
	private int myLevel;
	
	public HongGilDong() {
		super();
		myLevel = 5;
	}//ȫ�浿
	
	public String fight(int yourLevel) {
		String resultMsg = "";
		
		if(myLevel <yourLevel) { //���°��
			resultMsg ="OTL �ο򿡼� ����";
			myLevel--;
			if(myLevel <1) {
				myLevel = 1;
			}//end if
			
		}else if(myLevel>yourLevel) { //�̱�� ���
			resultMsg ="V('.^)V �ο򿡼� �̰���";
			myLevel++;
			if(myLevel >10) {
				myLevel = 10;
			}//end if
			
		}else { //���°��
			resultMsg = "(�Ѥ�;;)����!";
			
		}//end if
	
		return resultMsg;
	}
	
	
}
