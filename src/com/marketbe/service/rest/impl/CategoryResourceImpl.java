package com.marketbe.service.rest.impl;

import java.util.Calendar;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketbe.business.CategoryBusiness;
import com.marketbe.model.entity.Category;
import com.marketbe.service.rest.CategoryResource;
import com.marketbe.service.result.json.impl.CategoryJSONResult;
import com.marketbe.util.Constants;

/**
 * @author junior
 * 
 * Category Resource
 */
@Service("categories")
@Path("/categories")
public class CategoryResourceImpl implements CategoryResource
{
	/**
	 * Injected CategoryBusiness interface
	 */
	@Autowired(required=true)
	private CategoryBusiness categoryBusiness;
	
	/* (non-Javadoc)
	 * @see com.marketbe.service.rest.CategoryResource#pingResource()
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("ping")
	@Override
	public String pingResource()
	{
		return "Category Resource is alive! " + Calendar.getInstance().getTime();
	}
	
	/* (non-Javadoc)
	 * @see com.marketbe.service.rest.CategoryResource#getAllCategories()
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("list")
	@Override
	public CategoryJSONResult getAllCategories()
	{
		CategoryJSONResult categories = new CategoryJSONResult();
		
		categories.setMessage("Categories listed in database");
		categories.setMethod(Constants.GET);
		categories.setStatus(Constants.SUCCESS);
		categories.setCategories(categoryBusiness.getAllCategories());
		
		return categories;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.service.rest.CategoryResource#getCategoryById(java.lang.Integer)
	 */
	@GET
	@Produces({MediaType.APPLICATION_JSON})
	@Path("{id}")
	@Override
	public CategoryJSONResult getCategoryById(@PathParam("id") Integer id)
	{
		CategoryJSONResult categories = new CategoryJSONResult();
		
		if(id == null)
		{
			categories.setMessage("Error when loading Category, ID: " + id);
			categories.setMethod(Constants.GET);
			categories.setStatus(Constants.FAILURE);
		}
		else
		{
			categories.setMessage("Category successfully found");
			categories.setMethod(Constants.GET);
			categories.setStatus(Constants.SUCCESS);
			categories.setCategory(categoryBusiness.getCategory(id));
		}
		
		return categories;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.service.rest.CategoryResource#saveCategory(java.lang.String, java.lang.String)
	 */
	@POST
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
	@Path("create")
	@Override
	public CategoryJSONResult saveCategory(@FormParam("name") String name, @FormParam("description") String description)
	{
		CategoryJSONResult categories = new CategoryJSONResult();
		
		if(name == null || name.isEmpty() || description == null || description.isEmpty())
		{
			categories.setMessage("Error when creating Category, Name: " + name + " - Description: " + description);
			categories.setMethod(Constants.POST);
			categories.setStatus(Constants.FAILURE);
		}
		else
		{
			Category category = new Category();
			category.setName(name);
			category.setDescription(description);
			
			categoryBusiness.createCategory(category);
			
			categories.setMessage("Category was successfully created");
			categories.setMethod(Constants.POST);
			categories.setStatus(Constants.SUCCESS);
			categories.setCategory(category);
		}
		
		return categories;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.service.rest.CategoryResource#updateCategory(java.lang.Integer, java.lang.String, java.lang.String)
	 */
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Consumes("application/x-www-form-urlencoded")
	@Path("update")
	@Override
	public CategoryJSONResult updateCategory(@FormParam("id") Integer id, @FormParam("name") String name, @FormParam("description") String description)
	{
		CategoryJSONResult categories = new CategoryJSONResult();
		
		if(id == null || name == null || name.isEmpty() || description == null || description.isEmpty())
		{
			categories.setMessage("Error when updating Category, ID: " + id + " - Name: " + name + " - Description: " + description);
			categories.setMethod(Constants.PUT);
			categories.setStatus(Constants.FAILURE);
		}
		else
		{
			Category category = categoryBusiness.getCategory(id);
				
			if(category != null)
			{
				category.setName(name);
				category.setDescription(description);
					
				categoryBusiness.updateCategory(category);
				
				categories.setMessage("Category was successfully updated");
				categories.setMethod(Constants.PUT);
				categories.setStatus(Constants.SUCCESS);
				categories.setCategory(category);
			}
			else
			{
				categories.setMessage("Error when updating Category, because the category was not found in the database");
				categories.setMethod(Constants.PUT);
				categories.setStatus(Constants.FAILURE);				
			}
		}
		
		return categories;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.service.rest.CategoryResource#deleteCategory(java.lang.Integer)
	 */
	@DELETE
	@Produces({MediaType.APPLICATION_JSON})
	@Path("destroy/{id}")
	@Override
	public CategoryJSONResult deleteCategory(@PathParam("id") Integer id)
	{
		CategoryJSONResult categories = new CategoryJSONResult();
		
		if(id == null)
		{
			categories.setMessage("Error when removing the Category, ID: " + id);
			categories.setMethod(Constants.DELETE);
			categories.setStatus(Constants.SUCCESS);
		}
		else
		{
			categoryBusiness.deleteCategory(id);
					
			categories.setMessage("Category was successfully removed");
			categories.setMethod(Constants.DELETE);
			categories.setStatus(Constants.SUCCESS);
			categories.setCategories(categoryBusiness.getAllCategories());
		}
		
		return categories;
	}

	/**
	 * Do not call this method. This is used by the Spring IoC Container
	 * 
	 * @param CategoryBusiness categoryBusiness
	 */
	public void setCategoryBusiness(CategoryBusiness categoryBusiness)
	{
		this.categoryBusiness = categoryBusiness;
	}

	/**
	 * Do not call this method. This is used by the Spring IoC Container
	 * 
	 * @return CategoryBusiness
	 */
	public CategoryBusiness getCategoryBusiness()
	{
		return categoryBusiness;
	}
}
