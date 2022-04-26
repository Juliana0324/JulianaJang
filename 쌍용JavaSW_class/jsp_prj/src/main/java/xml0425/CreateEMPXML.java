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
	
	/**�Էµ� �����͸� ����Ͽ� XML����
	 * @param empData
	 * @return
	 */
	public Document createEmpXml(List<empVO> empData) {
		
		//1. ���� ��ü ����
		Document doc= new Document();
		
		//2. �ֻ��� �θ��� ����
		Element rootNode= new Element("emps");
		
		//3. �ڽĳ��
		//���������� ���� ���
		Element pubDateNode = new Element("pubDate");
		pubDateNode.setText(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));

		Element descNode = new Element("description");
		descNode.setText("��ȸ�� ������� ����");

		Element langNode = new Element("language");
		langNode.setText("ko");
		
		Element resultNode = new Element("resultFlag");
		resultNode.setText(String.valueOf(empData!=null && !empData.isEmpty()));
		
		rootNode.addContent(pubDateNode);
		rootNode.addContent(descNode);
		rootNode.addContent(langNode);
		rootNode.addContent(resultNode);

		if(empData!=null && !empData.isEmpty()) {
			//��ȸ ������(�ݺ�)
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
				//xml�� ���ڿ��� �ޱ⶧���� �� ����
				empNoNode.setText(String.valueOf(eVO.getEmpno()));
				
				empNameNode= new Element("ename");
				empNameNode.setText(eVO.getEname());

				jobNode= new Element("job");
				jobNode.setText(eVO.getJob());
				
				salNode= new Element("sal");
				salNode.setText(String.valueOf(eVO.getSal()));

				hiredateNode= new Element("hiredate");
				hiredateNode.setText(sdf.format(eVO.getHiredate()));
				
				//w�ڽĳ�带 empNode�� ��ġ
				empNode.addContent(empNoNode);
				empNode.addContent(empNameNode);
				empNode.addContent(jobNode);
				empNode.addContent(salNode);
				empNode.addContent(hiredateNode);
				
				//�ڽĳ�带 ���� emp node�� �ֻ��� �θ�(emps) ��ġ
				rootNode.addContent(empNode);
			}//end for
			
			//��� �����͸� ���� �ֻ��� �θ��带 ������ü ��ġ
			doc.addContent(rootNode);
		}
			
		
		
		return doc;
	}
	
	/**
	 * ������ xml�� ����Ͽ� File����
	 * @param doc
	 * @throws IOException
	 */
	public void createFileEmpXML(Document doc, String fileName) throws IOException{
		XMLOutputter xOut= new XMLOutputter(Format.getPrettyFormat());
		//���Ͽ� ����
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
