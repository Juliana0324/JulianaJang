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
	// - DB와 Connection을 미리 생성해둠ㅁ으로써 자원을 절약하는 방식
	// - 원하는 만큼 미리 생성해둔 Connection을 미리 Pool에 저장해 둔다
	// - 사용자가 DBCP에게 Connection을 요구하면 Connection을 사용자에게 제공한다
	// - Pool에 미리 생성된 모든 Connection이 사용중이라면 정책에 따라 새로운  Connection을 생성하기도 하고
	// 		제공했던 Connection이 반환할때 까지 사용자를 대기 시키기도 한다
	// - 다 사용한 Connection은 close() 하는 대신에 Pool에 반환하고 사용가능한 상태로 변경한다.
	
	// 유명한 DBCP들
	// - Apache Commons DBCP, HikariCP, BoneCP,
	
	@Override
	public void init() throws ServletException {
		//DB Connection Pool 초기화설정
		String uri="jdbc:oracle:thin:scott/TIGER@localhost:1521:XE";
		String user="scott";
		String pass="TIGER";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//필요할때 마다 커넥션을 생성할 수 있는 ConnectionFactory에 
			//DB와의 연결에 필요한 정보를 전달해야 인스턴스를 생성할 수 있다
			DriverManagerConnectionFactory connFactory=
				new DriverManagerConnectionFactory(uri, user, pass);
		
			//Pooling할 수 있는 객체를 생성하는 것==> Pool을 이용할 수 있는 객체를 생성
			PoolableConnectionFactory poolableConnFactory=
					new PoolableConnectionFactory(connFactory, null);
			poolableConnFactory.setValidationQuery("SELECT 1 FROM dual");
			
			//커넥션 풀에대한 정보
			// maxTotal : 최대 커넥션 개수
			// maxIdle : 커넥션 풀에 반납할때 최대로 유지할 수 있는 노는 커넥션 개수
			// minIdle : 최소로유지할 수 있는 노는 커넥션 개수(default = 0)
			// maxActive:  동시에 사용할 수 있는 최대 커넥션 개수(default = 8)
			// initialSIze: 커넥션 풀 최초 생성시에 채워넣을 커넥션 수(default=0)
			// setTestWhileIdle: 유휴 상태일때 테스트 여부를 결정한다
			
			GenericObjectPoolConfig poolConfig =new GenericObjectPoolConfig();
			poolConfig.setMaxIdle(10);		//쓰다가 남으면 10개까지는 유지하고 있겠다
			poolConfig.setMinIdle(5);		//아무리 연결이 없어도 5개는 미리 유지하겠다
			poolConfig.setMaxTotal(20); 	//아무리 연결이 많아도 20개 이상 만들지 않겠다
			poolConfig.setTestWhileIdle(true);
			
			// 설정한 시간동안 노는 커넥션을 제거하겠다(5분)
			poolConfig.setTimeBetweenEvictionRunsMillis(1000*60*5);
			
			// 생성한 팩토리와 설정을 전달해 커넥션 풀을 생성한다
			GenericObjectPool<PoolableConnection> connectionPool=
					new GenericObjectPool<>(poolableConnFactory,poolConfig);
			
			poolableConnFactory.setPool(connectionPool);
			
			//풀링 드라이버로드
			Class.forName("org.apache.commons.dbcp2.PoolingDriver");
			PoolingDriver driver = 
					(PoolingDriver)DriverManager.getDriver("jdbc:apache:commons:dbcp:");
			driver.registerPool("mydbcp", connectionPool);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch(SQLException e) {
			System.out.println("getDriver 에러");
		}
		
	}
}
