package chap01.util;

import java.util.Date;
import java.text.SimpleDateFormat;

public class Shortcuts {
	//나중에 편하게 쓰기위해 정의해놓은 자바 함수 예시
	public static String getCurrentTime(String format) {
		SimpleDateFormat fmt=new SimpleDateFormat(format);
		return fmt.format(new Date());

	}
}
