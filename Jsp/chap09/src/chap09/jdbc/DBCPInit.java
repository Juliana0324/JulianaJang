package chap09.jdbc;

import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.apache.commons.dbcp2.DriverManagerConnectionFactory;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.PoolingDriver;
import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;

public class DBCPInit extends HttpServlet{
	// DB connection pool (DBCP)
	// - DB�� Connection�� �̸� �����صҤ����ν� �ڿ��� �����ϴ� ���
	// - ���ϴ� ��ŭ �̸� �����ص� Connection�� �̸� Pool�� ������ �д�
	// - ����ڰ� DBCP���� Connection�� �䱸�ϸ� Connection�� ����ڿ��� �����Ѵ�
	// - Pool�� �̸� ������ ��� Connection�� ������̶�� ��å�� ���� ���ο�  Connection�� �����ϱ⵵ �ϰ�
	// 		�����ߴ� Connection�� ��ȯ�Ҷ� ���� ����ڸ� ��� ��Ű�⵵ �Ѵ�
	// - �� ����� Connection�� close() �ϴ� ��ſ� Pool�� ��ȯ�ϰ� ��밡���� ���·� �����Ѵ�.
	
	// ������ DBCP��
	// - Apache Commons DBCP, HikariCP, BoneCP,
	
	@Override
	public void init() throws ServletException {
		//DB Connection Pool �ʱ�ȭ����
		String uri="jdbc:oracle:thin:scott/TIGER@localhost:1521:XE";
		String user="scott";
		String pass="TIGER";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//�ʿ��Ҷ� ���� Ŀ�ؼ��� ������ �� �ִ� ConnectionFactory�� 
			//DB���� ���ῡ �ʿ��� ������ �����ؾ� �ν��Ͻ��� ������ �� �ִ�
			DriverManagerConnectionFactory connFactory=
				new DriverManagerConnectionFactory(uri, user, pass);
		
			//Pooling�� �� �ִ� ��ü�� �����ϴ� ��==> Pool�� �̿��� �� �ִ� ��ü�� ����
			PoolableConnectionFactory poolableConnFactory=
					new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("SELECT 1 FROM dual");
			
			//Ŀ�ؼ� Ǯ������ ����
			// maxTotal : �ִ� Ŀ�ؼ� ����
			// maxIdle : Ŀ�ؼ� Ǯ�� �ݳ��Ҷ� �ִ�� ������ �� �ִ� ��� Ŀ�ؼ� ����
			// minIdle : �ּҷ������� �� �ִ� ��� Ŀ�ؼ� ����(default = 0)
			// maxActive:  ���ÿ� ����� �� �ִ� �ִ� Ŀ�ؼ� ����(default = 8)
			// initialSIze: Ŀ�ؼ� Ǯ ���� �����ÿ� ä������ Ŀ�ؼ� ��(default=0)
			// setTestWhileIdle: ���� �����϶� �׽�Ʈ ���θ� �����Ѵ�
			
			GenericObjectPoolConfig poolConfig =new GenericObjectPoolConfig();
			poolConfig.setMaxIdle(10);		//���ٰ� ������ 10�������� �����ϰ� �ְڴ�
			poolConfig.setMinIdle(5);		//�ƹ��� ������ ��� 5���� �̸� �����ϰڴ�
			poolConfig.setMaxTotal(20); 	//�ƹ��� ������ ���Ƶ� 20�� �̻� ������ �ʰڴ�
			poolConfig.setTestWhileIdle(true);
			
			// ������ �ð����� ��� Ŀ�ؼ��� �����ϰڴ�(5��)
			poolConfig.setTimeBetweenEvictionRunsMillis(1000*60*5);
			
			// ������ ���丮�� ������ ������ Ŀ�ؼ� Ǯ�� �����Ѵ�
			GenericObjectPool<PoolableConnection> connectionPool=
					new GenericObjectPool<>(poolableConnFactory,poolConfig);
			
			poolableConnFactory.setPool(connectionPool);
			
			//Ǯ�� ����̹��ε�
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = 
					(PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("mydbcp", connectionPool);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("getDriver ����");
		}
		
	}
}
