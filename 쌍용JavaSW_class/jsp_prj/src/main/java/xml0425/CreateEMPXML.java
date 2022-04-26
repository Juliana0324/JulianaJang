package xml0425;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

import day0418.empDAO;
import day0418.empVO;

public class CreateEMPXML {
	
	/**입력된 데이터를 사용하여 XML생성
	 * @param empData
	 * @return
	 */
	public Document createEmpXml(List<empVO> empData) {
		
		//1. 문서 객체 생성
		Document doc= new Document();
		
		//2. 최상위 부모노드 생성
		Element rootNode= new Element("emps");
		
		//3. 자식노드
		//생산정보에 대한 노드
		Element pubDateNode = new Element("pubDate");
		pubDateNode.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

		Element descNode = new Element("description");
		descNode.setText("조회된 사원정보 제공");

		Element langNode = new Element("language");
		langNode.setText("ko");
		
		Element resultNode = new Element("resultFlag");
		resultNode.setText(String.valueOf(empData!=null && !empData.isEmpty()));
		
		rootNode.addContent(pubDateNode);
		rootNode.addContent(descNode);
		rootNode.addContent(langNode);
		rootNode.addContent(resultNode);

		if(empData!=null && !empData.isEmpty()) {
			//조회 데이터(반복)
			Element empNode=null;
			Element empNoNode=null;
			Element empNameNode=null;
			Element jobNode=null;
			Element salNode=null;
			Element hiredateNode=null;
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd EEEE HH:mm:ss");
			for(empVO eVO:empData) {
				empNode=new Element("emp");
				empNoNode= new Element("empno");
				//xml은 문자열로 받기때문에 다 변경
				empNoNode.setText(String.valueOf(eVO.getEmpno()));
				
				empNameNode= new Element("ename");
				empNameNode.setText(eVO.getEname());

				jobNode= new Element("job");
				jobNode.setText(eVO.getJob());
				
				salNode= new Element("sal");
				salNode.setText(String.valueOf(eVO.getSal()));

				hiredateNode= new Element("hiredate");
				hiredateNode.setText(sdf.format(eVO.getHiredate()));
				
				//w자식노드를 empNode에 배치
				empNode.addContent(empNoNode);
				empNode.addContent(empNameNode);
				empNode.addContent(jobNode);
				empNode.addContent(salNode);
				empNode.addContent(hiredateNode);
				
				//자식노드를 가진 emp node를 최상위 부모(emps) 배치
				rootNode.addContent(empNode);
			}//end for
			
			//모든 데이터를 가진 최상위 부모노드를 문서객체 배치
			doc.addContent(rootNode);
		}
			
		
		
		return doc;
	}
	
	/**
	 * 생성된 xml을 사용하여 File생성
	 * @param doc
	 * @throws IOException
	 */
	public void createFileEmpXML(Document doc, String fileName) throws IOException{
		XMLOutputter xOut= new XMLOutputter(Format.getPrettyFormat());
		//파일에 저장
		File saveDir= new File("E:/dev/workspace/jsp_prj/src/main/webapp/xml0425");
		if(!saveDir.exists()) {
			saveDir.mkdirs();
		}		
		FileOutputStream fos=null;
		try {
			fos=new FileOutputStream(saveDir.getAbsolutePath()+"/"+fileName);
			xOut.output(doc, fos);
		}finally {
			if(fos!=null) {fos.close();}
		}
		
	}
	
	public static void main(String[] args) throws SQLException, IOException {
		empDAO d = new empDAO();
		CreateEMPXML c= new CreateEMPXML();
		Document doc = c.createEmpXml(d.selectAllEmp());
		
		c.createFileEmpXML(doc, "emp.xml");
	}
}
