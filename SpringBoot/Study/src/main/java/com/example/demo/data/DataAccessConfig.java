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
//1�� �̻��� bean�� ����Ѵٴ°��� ���
@MapperScan(basePackages = "com.example.demo.repository") 
//dao�������ϴ� repo�� ��θ� ������Ѵ�

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
	
/*	@Bean���� ��������� @Configuration���� �ø��°Ű�

	@MapperScan ���� ���߿� Mapper���� �ٶ󺸰� �ϴ°Ŵ�.

	�𸣸� ���� �ȴ� ���⼭ �߿��Ѱ�

	classpath:mapper/*.xml  <--�̳��ε� �̰� ���� xml���� �����Ҷ� �˰Եɲ���.
*/
}
