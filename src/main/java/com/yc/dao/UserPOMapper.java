package com.yc.dao;

import java.util.List;

import org.springframework.stereotype.Service;

import com.yc.po.UserPO;

/**
 * 用户管理接口
 * @author 38929
 *
 */
public interface UserPOMapper {

	//添加
	public boolean insert(List<UserPO> userPOs);
	
	//修改
	public boolean update(UserPO userPO);
	
	//删除
	public boolean delete(UserPO userPO);
	
	//查询
	public List<UserPO> select(UserPO userPO);
	
	//登录
	public UserPO login(UserPO userPO);
}
