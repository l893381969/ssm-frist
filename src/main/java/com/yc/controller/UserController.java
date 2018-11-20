package com.yc.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yc.biz.IUserBiz;
import com.yc.biz.impl.UserBizImpl;
import com.yc.po.UserPO;

@Controller
public class UserController {
	
	@Autowired
	IUserBiz biz;
	
	@RequestMapping("/UserLogin/{value}")
	@ResponseBody
	public int testUserLogin(@PathVariable String value,HttpServletRequest request){
		System.out.println(value);
		String [] values = value.split("-");
		UserPO userPO = new UserPO();
		userPO.setUname(values[1]);
		userPO.setUpwd(values[2]);
		
		UserPO user = biz.login(userPO);
		if(user!=null){
			request.getSession().setAttribute("user",user);
			return 1;
		}else{
			return 0;
		}
	}
	

}
