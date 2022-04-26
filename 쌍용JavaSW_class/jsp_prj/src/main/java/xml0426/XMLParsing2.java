package xml0426;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLParsing2 {

	public XMLParsing2() throws JDOMException, IOException {
		SAXBuilder sb = new SAXBuilder();
		
		
		//xml������ Dociment��ü ����
		URL url = new URL("http://localhost/jsp_prj/xml0425/create_data.xml");
		System.out.println("URLŬ������ ����� �������� �����Ͽ� ���������� �����ϴ� XML�Ľ�");
		Document doc=sb.build(url);
		System.out.println(doc);
		
		//c�ֻ��� ���
		Element rootNode=doc.getRootElement();
		System.out.println(rootNode);
		
		/*
		 * //�ڽĳ�� ��� Element nameNode=rootNode.getChild("name");
		 * System.out.println(nameNode);
		 */
		
		//�ڽĳ�� ��
		List<Element> subNode= rootNode.getChildren();
		System.out.println("�ڽĳ�� ��:"+subNode.size());
		
		//5. �Ľ��� �ڽĳ�� �ݺ�
		Element nameNode=null;
		for(int i=0; i<subNode.size(); i++) {
			nameNode=subNode.get(i);
			System.out.println("����: "+nameNode.getName()+", ��尪: "+nameNode.getText());
		}
	}
	
	
	public static void main(String[] args) {

		try {
			new XMLParsing2();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
