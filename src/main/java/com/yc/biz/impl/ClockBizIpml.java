package com.yc.biz.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yc.biz.IClockBiz;
import com.yc.dao.ClockPOMapper;
import com.yc.po.ClockPO;


@Repository("clockbiz")
public class ClockBizIpml implements IClockBiz {

	@Autowired
	private ClockPOMapper clockPOMapper;
	@Override
	
	public boolean insert(ClockPO clockPO) {
		return clockPOMapper.insert(clockPO);
	}
}
