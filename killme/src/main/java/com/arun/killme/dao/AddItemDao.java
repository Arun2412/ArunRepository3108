package com.arun.killme.dao;

import java.util.List;

import com.arun.killme.model.AddItem;

public interface AddItemDao {
	
	void addMyItem(AddItem addItem);
	List<AddItem> viewItems();
	void deleteItem(int id);
	void updateItem(AddItem addItem);
	AddItem getItemById(int id);
}
