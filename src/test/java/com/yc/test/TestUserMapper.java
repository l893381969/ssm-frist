package com.yc.test;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.dao.UserPOMapper;
import com.yc.po.UserPO;

public class TestUserMapper {
	
	@Test
	public void testLogin(){
		ApplicationContext atx =new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) atx.getBean("sqlSessionFactory");
		SqlSession session = sqlSessionFactory.openSession(true);
		UserPOMapper mapper = session.getMapper(UserPOMapper.class);
		
		UserPO userPO = new UserPO();
		userPO.setUname("aa");
		userPO.setUpwd("a");
		UserPO user = mapper.login(userPO );
		System.out.println(user);
	}

}
