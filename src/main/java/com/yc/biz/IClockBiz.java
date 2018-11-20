package com.yc.biz;

import com.yc.po.ClockPO;

/**
 * 签到接口
 * @author 38929
 *
 */
public interface IClockBiz {

	//打卡
	public boolean insert(ClockPO clockPO)throws Exception;
}
