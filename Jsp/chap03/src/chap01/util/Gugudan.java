package chap01.util;

public class Gugudan {
	public static String getHtmlGugudan() {
		StringBuilder gugudan=new StringBuilder();
	for(int i=2;i<10;i++) {
		gugudan.append("<h3>"+i+"</h3>");
		for(int j=1;j<10;j++) {
			gugudan.append(String.format("<p>%d x %d =%d</p>", i,j,i*j));	
		}
	}
	return gugudan.toString();
	}

}
