package kr.co.sist.service;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;

import org.apache.tomcat.util.codec.binary.Base64;

import kr.co.sist.dao.LoginDAO;
import kr.co.sist.util.cipher.DataDecrypt;
import kr.co.sist.util.cipher.DataEncrypt;
import kr.co.sist.vo.LoginVO;

//업무로직 처리
public class LoginService {
	
	 
	   public String loginProcess(LoginVO lv) {
	      String name = "";
	      
	      // 비밀번호 MD5로 일방향 해쉬로 암호화
	      lv.setPass(sha( lv.getPass()));
	      // DB작업 수행
	      LoginDAO lDAO = LoginDAO.getInstance();
	      try {
	         name = lDAO.selectMember(lv);
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      name = decrypt(name);
	      System.out.println(name);
	      return name;
	      
	   } // loginProcess
	   
	   public String decrypt(String name) {
		   
		try {
			DataDecrypt dd = new DataDecrypt("test123412341234");
			name=dd.decryption(name);
					
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (GeneralSecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return name;
	   }
	   
	   public String sha(String password) {
	      String data = "";
	      try {
	         data = DataEncrypt.messageDigest("MD5", password);
	      } catch (NoSuchAlgorithmException e) {
	         e.printStackTrace();
	      }
	      return data;
	   } // sha


}
