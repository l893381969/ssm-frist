package com.yc.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.biz.IPlanBiz;
import com.yc.dao.PlanPOMapper;
import com.yc.po.PlanPO;

public class PlanTest {
	
	private ApplicationContext ctx;
	private IPlanBiz biz;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		biz = (IPlanBiz) ctx.getBean("planBiz");
	}
	
	@Test
	public void testselectPlan(){
		ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSessionFactory= (SqlSessionFactory) atx.getBean("sqlSessionFactory");
		SqlSession session = sqlSessionFactory.openSession(true);
		PlanPOMapper mapper = session.getMapper(PlanPOMapper.class);
		
		PlanPO Plan = new PlanPO();
		Plan.setUtel("2222");
		List<PlanPO> list = mapper.selectPlan(Plan);
		System.out.println(list);
	}
	
	@Test
	public void testTelectPlan() throws Exception{
		PlanPO planPO = new PlanPO();
		//planPO.setTime("09:00~11:00");
		planPO.setDate("2018-7-2");
		//planPO.setUname("aa");
		//planPO.setUtel("5555");
		List<PlanPO> list = biz.selectPlan(planPO);
		System.out.println(list);
	}
	
	
}
