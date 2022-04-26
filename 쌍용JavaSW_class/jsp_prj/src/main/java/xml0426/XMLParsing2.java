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
		
		
		//xml문서를 Dociment객체 저장
		URL url = new URL("http://localhost/jsp_prj/xml0425/create_data.xml");
		System.out.println("URL클래스를 사용한 웹서버에 접속하여 웹서버에서 동작하는 XML파싱");
		Document doc=sb.build(url);
		System.out.println(doc);
		
		//c최상위 노드
		Element rootNode=doc.getRootElement();
		System.out.println(rootNode);
		
		/*
		 * //자식노드 얻기 Element nameNode=rootNode.getChild("name");
		 * System.out.println(nameNode);
		 */
		
		//자식노드 수
		List<Element> subNode= rootNode.getChildren();
		System.out.println("자식노드 수:"+subNode.size());
		
		//5. 파싱할 자식노드 반복
		Element nameNode=null;
		for(int i=0; i<subNode.size(); i++) {
			nameNode=subNode.get(i);
			System.out.println("노드명: "+nameNode.getName()+", 노드값: "+nameNode.getText());
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
