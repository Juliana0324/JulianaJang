package day0516.assembly;

import day0516.dao.DAO;
import day0516.dao.MySqlDAO;
import day0516.dao.OracleDAO;
import day0516.service.Service;
import day0516.service.ServiceImpl;

/**
 * Service�� DAO�� ���踦 �����ϴ���
 * @author user
 *
 */
public class Assembly {
	public Service getBean() {
		//1. ������ ������ Ŭ���� ����
		//DAO dao= new OracleDAO();
		DAO dao= new OracleDAO();
		
		//2. ������ ���Թ��� Ŭ������ �����ϰ�, ������ ���� ����
		Service service = new ServiceImpl(dao);
		
		//3. ������ ���Թ��� Ŭ���� ��ȯ
		return service;
	}
}
