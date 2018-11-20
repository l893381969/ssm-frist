package com.yc.test;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yc.biz.IItemBiz;
import com.yc.po.ItemPO;

public class ItemBizTest {

	private ApplicationContext ctx;
	private IItemBiz biz;
	
	{
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		biz = (IItemBiz) ctx.getBean("itemBiz");
	}
	
	@Test
	public void test(){
		System.out.println(biz);
	}
	
	@Test
	public void testSelect() throws Exception{
		ItemPO itemPO = new ItemPO();
		List<ItemPO> list = biz.select(itemPO);
		System.out.println(list);
	}
	
	@Test
	public void testInsert() throws Exception{
		ItemPO itemPO = new ItemPO();
		itemPO.setIid("123");
		itemPO.setIname("世界那么大");
		boolean flag = biz.insert(itemPO);
		System.out.println(flag);
	}
}
