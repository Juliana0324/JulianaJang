<%@page import="java.net.URLEncoder"%>
<%@page import="java.io.OutputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="application/octet-stream"
    pageEncoding="UTF-8"
    info="요청받은 파일을 무줙건 다운로드(application/octet-stream)" %>

<%
	String fileName=request.getParameter("filename");

	if(fileName==null || "".equals(fileName)){
		response.sendRedirect("file_list.jsp");
		return;
	}
	//입력된 파일명으로 다운로드파일생성
	//한글 encodeing URLEncoder.encode(fileName, "UTF-8")
	response.setHeader("Content-Disposition", "attachement;fileName="+URLEncoder.encode(fileName, "UTF-8"));
	
	
	
	//입력된 파일명으로 파일정보 얻기
	File infoFile = new File("E:/dev/workspace/jsp_prj/src/main/webapp/upload/"+fileName);
	if(infoFile.exists()){ //파일이 존재하면
		//파일을 스트림으로
		FileInputStream fis=null; //다운받을 파일에 연결하기 위한 Stream
		OutputStream ps= null; //접속자 컴퓨터로 파일를 보내기 위함 stream
		
		try{
			fis=new FileInputStream(infoFile.getAbsolutePath());
			
			//읽어드릴 파일의 내용을 저장할 배열 생성
			byte[] readData= new byte[(int)infoFile.length()];
			
			int tempData = 0;
			int i=0;
			
			while((tempData=fis.read()) !=-1){
				readData[i] = (byte)tempData;
				i++;
			}//end while
			
			//HTML을 출력하는 기능의 초기화
			out.clear();
			
			//설정된 응답 header로 출력스트림 재설정
			out =pageContext.pushBody();
			
			//응답 객체로부터 출력 스트림 연결
			ps=response.getOutputStream();
			
			//파일 출력
			ps.write(readData);
			
			//스트림의 내용을 목적지로 분출
			ps.flush();
		}finally{
			if(fis!=null){fis.close();}
			if(ps !=null){ps.close();}
			
		}
		
	}
%>