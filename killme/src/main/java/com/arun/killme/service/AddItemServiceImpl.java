package com.arun.killme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.killme.dao.AddItemDao;
import com.arun.killme.model.AddItem;
@Service
public class AddItemServiceImpl implements AddItemService 
{
	@Autowired
	AddItemDao addItemDao;

	public void addMyItem(AddItem addItem) 
	{
		addItemDao.addMyItem(addItem);
	}

	public List<AddItem> viewItems() {
		List<AddItem> list = addItemDao.viewItems();
		return list;
	}
	public void deleteItem(int id)
	{
		addItemDao.deleteItem(id);
	}
	public AddItem getItemById(int id) 
	{
		return addItemDao.getItemById(id);
	}
	public void updateItem(AddItem addItem)
	{
		addItemDao.updateItem(addItem);
	}
}
