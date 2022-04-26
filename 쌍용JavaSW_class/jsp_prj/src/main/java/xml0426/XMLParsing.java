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
		
		
		//xml문서를 Dociment객체 저장
		File file = new File("E:/dev/workspace/jsp_prj/src/main/webapp/xml0425/create_data.xml");
		
		if(file.exists()) {
			Document doc=sb.build(file);
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
