package lab.web.mail;

import java.io.UnsupportedEncodingException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class SMTPAuth extends Authenticator{
	
	protected PasswordAuthentication getPasswordAuthentication() {
		return new PasswordAuthentication("chiang324@naver.com", "julin324##");
	}	
	public static boolean sendEmail(String from, String name, String subject, String content) {
		Properties pro = new Properties();
		pro.put("mail.smtp.host", "smtp.naver.com");
		pro.put("mail.smtp.port", "465");
		pro.put("mail.smtp.auth", "true");
		pro.put("mail.smtp.ssl.enable", "true");
		pro.put("mail.smtp.starttls.enable", "true");
		try {
			SMTPAuth auth=new SMTPAuth();
			Session session = Session.getInstance(pro,auth);
			MimeMessage msg= new MimeMessage(session);
			msg.setSubject(subject);
			Address froms =new InternetAddress(from,name);
			msg.setFrom(froms);
			Address tos= new InternetAddress("chiang324@naver.com");
			msg.addRecipient(Message.RecipientType.TO, tos);
			msg.setContent("������ ��:" +from+"<br>����: "+name+
					"<br>"+content, "text/html;charset=UTF-8");
			Transport.send(msg);
					
		}catch(AddressException e) {
			e.printStackTrace();
			throw new RuntimeException("�ּҰ� �߸��Ǿ����ϴ�. �ܼ� Ȯ��");
		}catch(MessagingException | UnsupportedEncodingException e){
			e.printStackTrace();
			throw new RuntimeException("������ ������ ������ ������ ������ϴ�. �ܼ�Ȯ��");
		}
		return true;
	}
	

}
