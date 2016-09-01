package com.arun.killme.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.arun.killme.dao.CategoryDao;
import com.arun.killme.model.AddItem;

@Service
public class CategoryServiceImpl implements CategoryService
{

	@Autowired
	CategoryDao categoryDao;
	public List<AddItem> getElementByCategory(String category) 
	{
		List<AddItem> list = categoryDao.getElementByCategory(category);
		return list;
	}

}
