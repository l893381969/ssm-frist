package com.yc.biz;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.yc.po.UserPO;

/**
 * 监考接口
 * @author 38929
 *
 */
public interface IUserBiz {

	//注册
	public boolean insert(List<UserPO> userPOs);
	
	//修改
	public boolean update(UserPO userPO);
	
	//删除
	public boolean delete(UserPO userPO);
	
	//登陆
	public List<UserPO> select(UserPO userPO);
	
	//登录
	public UserPO login(UserPO userPO);
	
}
