package xml0426;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLParsing {

	public XMLParsing() throws JDOMException, IOException {
		SAXBuilder sb = new SAXBuilder();
		
		
		//xml������ Dociment��ü ����
		File file = new File("E:/dev/workspace/jsp_prj/src/main/webapp/xml0425/create_data.xml");
		
		if(file.exists()) {
			Document doc=sb.build(file);
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
	}
	
	
	public static void main(String[] args) {

		try {
			new XMLParsing();
		} catch (JDOMException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
