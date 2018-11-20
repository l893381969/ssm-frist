package com.yc.controller;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.mchange.v1.util.Sublist;
import com.yc.biz.IClockBiz;
import com.yc.biz.IItemBiz;
import com.yc.biz.IPlanBiz;
import com.yc.biz.impl.PlanBizImpl;
import com.yc.po.ClockPO;
import com.yc.po.ItemPO;
import com.yc.po.PlanPO;

@Controller
public class PlanController {
	
	private static final String SUCCESS = "success";
	
	@Autowired
	private IPlanBiz biz;
	@Autowired
	private IClockBiz cbiz;
	@Autowired
	private IItemBiz itemBiz;
	
	@RequestMapping("/selectplan/{tel}")
	@ResponseBody
	public List<PlanPO> selectplan(@PathVariable String tel) throws Exception{				
		PlanPO planPO = new PlanPO();	
		planPO.setUtel(tel);
		List<PlanPO> list = biz.selectPlan(planPO);
		ClockPO clockPO = new ClockPO();
		clockPO.setUtel(tel);
		boolean a = cbiz.insert(clockPO );
		//System.out.println(a);
		//System.out.println(list);
		return list;
	}
	
	@RequestMapping("/upload")
	@ResponseBody
	public String methodTest(@RequestParam("upfile") CommonsMultipartFile file) throws Exception{
		 System.out.println("fileName："+file.getOriginalFilename());	 
		 //上传的Excel表格存入指定盘中
	     String path="D://ExcelTestPlan";         
	     File filea= new File(path);		
			//如果没有就创建一个
			if(!filea.exists()){
				filea.mkdir();
			}
		 //生成新的文件名
		 String eName = new Date().getTime() +"-"+file.getOriginalFilename();
		 String fPath = path +"//"+eName;
		 String iid = eName.split("-")[0];
		 System.out.println(iid);
		 //生成新文件
	     File newFile=new File(fPath);
	     List<PlanPO> list = biz.readExcelFile(file);
	     System.out.println("exc"+list);
	     ItemPO itemPO = new ItemPO();
	     itemPO.setIid(iid);
	     itemPO.setIname(file.getOriginalFilename());
	    //判断是否获取Excel表中数据
		if(list != null && !list.isEmpty()){
			//通过CommonsMultipartFile的方法直接写文件（注意这个时候） 	    
			file.transferTo(newFile); 
			for(PlanPO po :list){
				po.setIid(iid);
			}
			System.out.println("po:"+list);
			//插入考试安排详情
			boolean flag2 = itemBiz.insert(itemPO);
			boolean flag1 = biz.insert(list);
			System.out.println(flag2);
			if(flag1 == true && flag2 == true){
				System.out.println("插入成功");
			}
		}else{
			System.out.println("Excel文件读取失败！");
		}
	     return SUCCESS;		
	}
	
	@RequestMapping("/findAll")
	@ResponseBody
	private List<PlanPO> findAll(PlanPO planPO) throws Exception{
		System.out.println(planPO);	
		List<PlanPO> list = biz.selectPlan(planPO);
		System.out.println(list);
		return list;
	}
}
