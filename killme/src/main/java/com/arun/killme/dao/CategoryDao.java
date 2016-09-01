package com.arun.killme.dao;

import java.util.List;

import com.arun.killme.model.AddItem;

public interface CategoryDao
{
	List<AddItem> getElementByCategory(String category);

}
