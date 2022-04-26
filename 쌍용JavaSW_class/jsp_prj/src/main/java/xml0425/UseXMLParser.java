package xml0425;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * �ļ��� ����� XML����
 * @author user
 *
 */
public class UseXMLParser {
	
	public UseXMLParser() {
		
	}
	
	public void createXML() throws IOException {
		//1. XML���� ����
		Document document = new Document();
		
		//2. �ֻ��� �θ��� ����
		Element rootNode= new Element("root"); //<root>
		
		//3. �ڽ� ��� ����
		Element subNode= new Element("name"); //<name>
		
		//�ڽ� ��忡 �� ����
		subNode.setText("������");
		
		//3.�ڽĳ��Ѥ� �θ��� ��ġ
		rootNode.addContent(subNode); //<root><name>������</name></root>
		
		//4. �θ��带 ������ü ��ġ
		document.addContent(rootNode);
	
		//5. ���
//		XMLOutputter xOut= new XMLOutputter();
//		XMLOutputter xOut= new XMLOutputter(Format.getCompactFormat());
		XMLOutputter xOut= new XMLOutputter(Format.getPrettyFormat());
		
		//����� ��ü�� ��Ʈ���� �־� ���
		xOut.output(document, System.out); //out.stream�� �־� console�� ���
		FileOutputStream fos=new FileOutputStream("E:/dev/workspace/jsp_prj/src/main/webapp/xml0425/create_data.xml");
		xOut.output(document, fos);
		
//		System.out.println(subNode.getText());
//		System.out.println(document);
//		System.out.println(rootNode);
//		System.out.println(subNode);
		
	}
	
	public static void main(String[] args) {
		try {
			new UseXMLParser().createXML();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
