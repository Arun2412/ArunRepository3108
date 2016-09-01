package com.arun.killme.service;

import java.util.List;

import com.arun.killme.model.AddItem;

public interface AddItemService 
{
	void addMyItem(AddItem addItem);
	List<AddItem> viewItems();
	void deleteItem(int id);
	void updateItem(AddItem addItem);
	AddItem getItemById(int id);
}
