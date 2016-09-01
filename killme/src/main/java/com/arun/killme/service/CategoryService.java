package com.arun.killme.service;

import java.util.List;

import com.arun.killme.model.AddItem;

public interface CategoryService
{
	List<AddItem> getElementByCategory(String category);

}
