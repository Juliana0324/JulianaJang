package xml0425;

import java.io.FileOutputStream;
import java.io.IOException;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

/**
 * 파서를 사용한 XML생성
 * @author user
 *
 */
public class UseXMLParser {
	
	public UseXMLParser() {
		
	}
	
	public void createXML() throws IOException {
		//1. XML문서 생성
		Document document = new Document();
		
		//2. 최상위 부모노드 생성
		Element rootNode= new Element("root"); //<root>
		
		//3. 자식 노드 생성
		Element subNode= new Element("name"); //<name>
		
		//자식 노드에 값 설정
		subNode.setText("장정우");
		
		//3.자식노드ㅡㄹ 부모노드 배치
		rootNode.addContent(subNode); //<root><name>장정우</name></root>
		
		//4. 부모노드를 문서객체 배치
		document.addContent(rootNode);
	
		//5. 출력
//		XMLOutputter xOut= new XMLOutputter();
//		XMLOutputter xOut= new XMLOutputter(Format.getCompactFormat());
		XMLOutputter xOut= new XMLOutputter(Format.getPrettyFormat());
		
		//출력할 객체와 스트림을 넣어 출력
		xOut.output(document, System.out); //out.stream을 넣어 console로 출력
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
