package com.yc.biz.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.yc.biz.IItemBiz;
import com.yc.dao.ItemPOMapper;
import com.yc.po.ItemPO;

@Repository("itemBiz")
public class ItemBizImpl implements IItemBiz {

	@Autowired
	private ItemPOMapper itemPOMapper;
	
	@Override
	public List<ItemPO> select(ItemPO itemPO) throws Exception {
		return itemPOMapper.select(itemPO);
	}

	@Override
	public boolean insert(ItemPO itemPO) throws Exception {
		return itemPOMapper.insert(itemPO);
	}

}
