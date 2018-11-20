package com.yc.biz;

import java.util.List;

import com.yc.po.ItemPO;

/**
 * 计划表
 * @author 38929
 *
 */
public interface IItemBiz {

	/**
	 * 查询计划表
	 * @param itemPO
	 */
	public List<ItemPO> select(ItemPO itemPO)throws Exception;
	
	/**
	 * 添加计划表
	 * @param itemPO
	 */
	public boolean insert(ItemPO itemPO)throws Exception;
}
