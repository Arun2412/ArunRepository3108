package com.arun.killme.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import javax.validation.Valid;

import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.arun.killme.model.AddItem;
import com.arun.killme.model.Customer;
import com.arun.killme.service.AddItemService;
import com.arun.killme.service.CustomerService;

@Controller
public class AdminController {
	@Autowired
	CustomerService customerService;
	@Autowired
	AddItemService addItemService;
	@RequestMapping("/toAddItems")
	public ModelAndView disAddItem()
	{
		AddItem addItem = new AddItem();
		return new ModelAndView("addItem","addItemKey",addItem);	
	}
	@RequestMapping("/toSuccessAdd")
	public String disAdded(@Valid@ModelAttribute("addItemKey") AddItem addItem,@RequestParam("file") MultipartFile file, BindingResult bindingResult) throws IllegalStateException, IOException
	{
		if(bindingResult.hasErrors())
		{
			return "redirect:/toViewItems";
		}
		addItemService.addMyItem(addItem);
		MultipartFile itemImage = addItem.getFile();
		Path path = Paths.get("C://Users//hp//Downloads//killme//src//main//webapp//resources//images//"+addItem.getId()+".jpg");
		if(itemImage != null && !itemImage.isEmpty())
		{
			itemImage.transferTo(new File(path.toString()));
		}
		return "redirect:/toViewAllItems";
	}
	@RequestMapping("/toViewCustomers")
	public ModelAndView disCustomers() throws JsonGenerationException, JsonMappingException, IOException
	{
		List<Customer> list = customerService.viewCustomer();
		ObjectMapper mapper = new ObjectMapper();
		String listJSON = mapper.writeValueAsString(list);
		return new ModelAndView("ViewCustomers","allCustomers",listJSON);	
	}
	@RequestMapping("/toViewAllItems")
	public ModelAndView disItems() throws JsonGenerationException, JsonMappingException, IOException
	{
		List<AddItem> list = addItemService.viewItems();
		System.out.println("before object mapper");
		ObjectMapper mapper = new ObjectMapper();
		String listJSON = mapper.writeValueAsString(list);
		return new ModelAndView("ViewItems","allItems",listJSON);
	}
	@RequestMapping("toDeleteItem")
	public String disDeleteItem(@RequestParam("id") int id)
	{
		addItemService.deleteItem(id);
		return "redirect:/toViewAllItems";
	}
	@RequestMapping("toEditItem")
	public ModelAndView disUpdateItem(@RequestParam("id") int id)
	{
		AddItem addItem = addItemService.getItemById(id);
		return new ModelAndView("ItemEdit","editItemKey",addItem);
	}
	@RequestMapping("toUpdateItem")
	public String disViewItems(@RequestParam("id") String idUpdated,@RequestParam("name") String nameUpdated,@RequestParam("description") String descriptionUpdated,@RequestParam("category") String categoryUpdated,@RequestParam("price") String priceUpdated)
	{
		AddItem addItem = addItemService.getItemById(Integer.parseInt(idUpdated));
		addItem.setName(nameUpdated);
		addItem.setDescription(descriptionUpdated);
		addItem.setCategory(categoryUpdated);
		addItem.setPrice(Float.parseFloat(priceUpdated));
		addItemService.updateItem(addItem);
		return "redirect:/toViewAllItems";
	}
}
