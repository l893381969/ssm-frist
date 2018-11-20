package com.yc.dao;

import java.util.List;

import com.yc.po.ItemPO;

/**
 * 计划表
 * @author 38929
 *
 */
public interface ItemPOMapper {

	/**
	 * 查询计划表
	 * @param itemPO
	 */
	public List<ItemPO> select(ItemPO itemPO);
	
	/**
	 * 添加计划表
	 * @param itemPO
	 */
	public boolean insert(ItemPO itemPO);
}
