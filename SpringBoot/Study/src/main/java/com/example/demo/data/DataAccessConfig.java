package com.example.demo.data;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

@Configuration
//1개 이상의 bean을 등록한다는것을 명시
@MapperScan(basePackages = "com.example.demo.repository") 
//dao역할을하는 repo의 경로를 적어야한다

public class DataAccessConfig {
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSourse) throws Exception{
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSourse);
		sessionFactory.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources("classpath:mapper/*.xml"));
		return sessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSF) {
		return new SqlSessionTemplate(sqlSF);
	}
	
/*	@Bean으로 등록했으니 @Configuration으로 올리는거고

	@MapperScan 으로 나중에 Mapper쪽을 바라보게 하는거다.

	모르면 몰라도 된다 여기서 중요한건

	classpath:mapper/*.xml  <--이놈인데 이건 좀따 xml파일 연결할때 알게될꺼다.
*/
}
