<%@page import="org.json.simple.JSONArray"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="day0406.TestVO"%>
<%@page import="java.util.List"%>
<%@page import="org.json.simple.JSONObject"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
List<TestVO> list = new ArrayList<TestVO>();
list.add(new TestVO("권용현", "서울시 강남구 역삼동", 24));
list.add(new TestVO("서울시", "서울시 강서구 발산동", 23));
list.add(new TestVO("강현모", "서울시 구로구 도봉동", 25));
list.add(new TestVO("서지숙", "서울시 동대문구 동대문동", 22));


JSONObject jsonObj=new JSONObject();

//값할당
SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a HH:mm:ss");
jsonObj.put("pubDate", sdf.format(new Date()));

jsonObj.put("dataCnt", list.size());

jsonObj.put("resultFlag", list.isEmpty());

//값 할당
//2-1 JSONArr생성
JSONArray jsonArr= new JSONArray();

//2-2 JSONArray에 들어갈 JSONObject생성
JSONObject jsonTemp=new JSONObject();

//2-3 검색된 데이터를 사용하여 JSONObject 생성
for(TestVO tVO:list){
	jsonTemp=new JSONObject();
	jsonTemp.put("name", tVO.getName());
	jsonTemp.put("addr", tVO.getAddr());
	jsonTemp.put("age", tVO.getAge());
	
	//2-4 JSONObject를 JSONArray에 할당(N번)
	jsonArr.add(jsonTemp);
}	


//2-5.데이터를 가진 JSONArray를 JSONObject에 할당
jsonObj.put("data", jsonArr);



out.println(jsonObj.toJSONString());

%>