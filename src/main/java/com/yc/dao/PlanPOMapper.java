package com.yc.dao;

import java.util.List;

import com.yc.po.PlanPO;

/**
 * 监考详情
 * @author 38929
 *
 */
public interface PlanPOMapper {
	
	//发布考试计划
	public boolean insert(List<PlanPO> planPOs);
	
	//查询监考详情
	public List<PlanPO> selectPlan(PlanPO planPO);
	
	//修改监考详情
	public boolean update(PlanPO planPOs);
}
