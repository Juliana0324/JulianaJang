package kr.co.sist.service;

import java.util.ArrayList;
import java.util.List;

/**
 * 업무로직(business logic)을 처리하는 코드.
 * @author user
 */
public class DataService {

   public List<String> searchData() {
      List<String> list = new ArrayList<String>();
      
      list.add("JSP");
      list.add("JavaScript");
      list.add("Python");
      list.add("C/C++");
      
      return list;
   }
   
}