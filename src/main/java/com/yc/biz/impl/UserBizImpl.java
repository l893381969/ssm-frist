package com.yc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yc.biz.IUserBiz;
import com.yc.dao.UserPOMapper;
import com.yc.po.UserPO;

@Repository("iuserBiz")
public class UserBizImpl implements IUserBiz{

	@Autowired
	private UserPOMapper userPOMapper;
	
	@Override
	public boolean insert(List<UserPO> userPOs) {
		return userPOMapper.insert(userPOs);
	}

	@Override
	public boolean update(UserPO userPO) {		
		return userPOMapper.update(userPO);
	}

	@Override
	public boolean delete(UserPO userPO) {
		return userPOMapper.delete(userPO);
	}

	@Override
	public List<UserPO> select(UserPO userPO) {
		return userPOMapper.select(userPO);
	}

	@Override
	public UserPO login(UserPO userPO) {
		return userPOMapper.login(userPO);
	}

	
}
