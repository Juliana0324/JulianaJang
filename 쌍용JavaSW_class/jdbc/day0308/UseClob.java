package day0308;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import kr.co.sist.dao.DbConnection;

/**
 * Clob������ ó��
 * @author user
 *
 */
public class UseClob {

	public List<ClobVO> useClob() throws SQLException, IOException{
		List<ClobVO> list = new ArrayList<ClobVO>();
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs = null;
		BufferedReader br = null;
		
		DbConnection dc = DbConnection.getInstance();

		try {
			conn= dc.getConn();
			
			conn.setAutoCommit(false);
			System.out.println("Autocommit: "+conn.getAutoCommit());
			StringBuilder selectTestClob= new StringBuilder();
			selectTestClob.append("SELECT subject, content,to_char(input_date,'mm-dd-yyyy') as input_date ")
			.append("FROM test_clob");
			
			pstmt=conn.prepareStatement(selectTestClob.toString());
			rs=pstmt.executeQuery();
			
			ClobVO cVO=null;
			String temp="";
			StringBuilder content = new StringBuilder();//g���� �о���� CLOB�� �����ϱ� ���� ����
			while(rs.next()) {
				cVO=new ClobVO();
				cVO.setSubject(rs.getString("subject"));
				//cVO.setContent(rs.getString("content"));//clob
				//clob �������¤����
				br=new BufferedReader(rs.getClob("content").getCharacterStream());
				
				while((temp=br.readLine())!=null) {
					content.append(temp).append("\n");
				}//end
				cVO.setContent(content.toString());
				cVO.setInputDate(rs.getString("input_date"));

				//Ȯ���ϰ� �ݾ���
				br.close();
				//����Ʈ �ʱ�ȭ
				content.delete(0, content.length());
				
				list.add(cVO);
			}
			
		}finally {
			if(br!=null) {br.close();}
			dc.close(rs, pstmt, conn);
		}
		
		return list;
	}
	public static void main(String[] args) {
		try {
			//System.out.println(new UseClob().useClob());
			UseClob uc= new UseClob();
			List<ClobVO> list= uc.useClob();
			ClobVO cVO=null;
			for(int i=0; i<list.size();i++) {
				cVO=list.get(i);
				System.out.printf("%d�� \n����: %s\n�ۼ���: %s\n����: %s\n", 
						i+1, cVO.getSubject(), cVO.getInputDate(),cVO.getContent());
				System.out.println();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
