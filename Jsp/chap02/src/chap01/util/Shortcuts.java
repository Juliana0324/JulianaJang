package chap01.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Shortcuts {
	//���߿� ���ϰ� �������� �����س��� �ڹ� �Լ� ����
	public static String getCurrentTime(String format) {
		SimpleDateFormat fmt=new SimpleDateFormat(format);
		return fmt.format(new Date());

	}
}
