package com.yc.biz.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.yc.biz.IPlanBiz;
import com.yc.dao.PlanPOMapper;
import com.yc.po.PlanPO;
import com.yc.util.ReadExcel;

@Repository("planBiz")
public class PlanBizImpl implements IPlanBiz {

	@Autowired
	private PlanPOMapper planPOMapper;
	
	@Override
	public List<PlanPO> selectPlan(PlanPO planPO) {
		ApplicationContext atx = new ClassPathXmlApplicationContext("applicationContext.xml");
		SqlSessionFactory sqlSessionFactory = (SqlSessionFactory) atx.getBean("sqlSessionFactory");
		SqlSession session = sqlSessionFactory.openSession(true);
		PlanPOMapper mapper = session.getMapper(PlanPOMapper.class);
		return mapper.selectPlan(planPO);
	}
	
	@Override
	public List<PlanPO> readExcelFile(MultipartFile file) {
		//创建处理Excel的类
		ReadExcel readExcel = new ReadExcel();
		//解析Excel  获取上传的事件单
		List<PlanPO> list = readExcel.getExcelInfo(file);
		System.out.println(list);
		//至此已将Excel中数据转换到list里，然后操作list,进行保存数据或其他		
		return list;
	}
	
	@Override
	public boolean insert(List<PlanPO> planPOs) throws Exception {
		return planPOMapper.insert(planPOs);
	}

	@Override
	public boolean update(PlanPO planPO) throws Exception {
		return planPOMapper.update(planPO);
	}

}
