package com.yc.biz;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yc.po.PlanPO;

public interface IPlanBiz {

	/**
	 * 查询考试安排
	 * @param planPO
	 * @return
	 */
	public List<PlanPO> selectPlan(PlanPO planPO)throws Exception;
	
	
	/**
	 * 发布考试计划
	 * @param planPOs
	 * @return
	 * @throws Exception
	 */
	public boolean insert(List<PlanPO> planPOs)throws Exception;
				
	/**
	 * 修改监考详情
	 * @param planPOs
	 * @return
	 * @throws Exception
	 */
	public boolean update(PlanPO planPOs)throws Exception;
	
	/**
	 * 读取Excel中的数据，生成list
	 * @param file
	 * @return
	 */
	public List<PlanPO> readExcelFile(MultipartFile file)throws Exception;
}
