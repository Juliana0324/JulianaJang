package kr.co.sist.service;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class AjaxService {
	
	public String createJSON() {
		String json="";
		
		String[] data= {"�ڹ�","�ڽ�", "HTML", "CSS", "Oracle DBMS"};
		
		//pubDate: ����ð�, lang:�迭�� ���� ,data[{name: "�ڹ�", ,,,,}]
		
		JSONObject jsonObj = new JSONObject();
		
		jsonObj.put("pubDate", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
		jsonObj.put("lang", String.valueOf(data.length));

		JSONArray ja = new JSONArray();
		JSONObject tempObj=null;
		for(String langName: data) {
			tempObj=new JSONObject();
			tempObj.put("name", langName);
			
			ja.add(tempObj);
		}
		
		jsonObj.put("data", ja);
		json = jsonObj.toJSONString();
		return json;
	}
	
	public static void main(String[] args) {
		System.out.println(new AjaxService().createJSON());
	}
}
