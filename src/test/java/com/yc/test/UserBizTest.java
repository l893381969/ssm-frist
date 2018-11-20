package com.yc.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.biz.IUserBiz;
import com.yc.po.UserPO;

public class UserBizTest {
	
	private ApplicationContext ctx;
	private IUserBiz biz;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		biz = (IUserBiz) ctx.getBean("iuserBiz");
	}

	@Test
	public void testInsert() {
		List<UserPO> userPOs = new ArrayList<UserPO>();		
		userPOs.add(new UserPO("cc","a","监考员","4444"));
		boolean flag = biz.insert(userPOs);
		System.out.println(flag);
	}

	@Test
	public void testUpdate() {
		UserPO userPO = new UserPO();	
		userPO.setUid(3);
		userPO.setUtel("5555");
		userPO.setUpwd("b");
		biz.update(userPO);
	}

	@Test
	public void testDelete() {
		UserPO userPO = new UserPO();	
		userPO.setUid(4);
		biz.delete(userPO);
	}

	@Test
	public void testSelect() {
		UserPO userPO = new UserPO();	
		List<UserPO> list = biz.select(userPO);
		System.out.println(list);
	}

	@Test
	public void test() {
		
		System.out.println(biz);
	}
}
