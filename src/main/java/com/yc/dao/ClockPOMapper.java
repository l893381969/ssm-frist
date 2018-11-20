package com.yc.dao;

import com.yc.po.ClockPO;

/**
 * 签到接口
 * @author 38929
 *
 */
public interface ClockPOMapper {

	//打卡
	public boolean insert(ClockPO clockPO);
}
