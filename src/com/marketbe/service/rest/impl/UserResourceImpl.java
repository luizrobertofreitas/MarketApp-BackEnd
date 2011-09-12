package com.marketbe.service.rest.impl;

import java.util.Calendar;

import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.marketbe.business.UserBusiness;
import com.marketbe.model.entity.User;
import com.marketbe.service.rest.UserResouce;
import com.marketbe.service.result.json.impl.UserJSONResult;
import com.marketbe.util.Constants;
import com.marketbe.util.ValidatorUtil;

@Service("users")
@Path("/users")
public class UserResourceImpl implements UserResouce
{
	@Autowired(required=true)
	private UserBusiness userBusiness;
	
	public void setUserBusiness(UserBusiness userBusiness)
	{
		this.userBusiness = userBusiness;
	}

	public UserBusiness getUserBusiness()
	{
		return userBusiness;
	}
	
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Path("changepassword")
	@Override
	public UserJSONResult changePassword(@FormParam("username") String username, @FormParam("newPassword") String newPassword, @FormParam("confirmNewPassword") String confirmNewPassword)
	{
		
		UserJSONResult result = new UserJSONResult();
		result.setMethod(Constants.PUT);
		
		User user = getUserBusiness().findByUsername(username);
		
		if(user != null)
		{
			if((newPassword != null && confirmNewPassword != null) && (newPassword.equalsIgnoreCase(confirmNewPassword)))
			{
				user.setPassword(newPassword);
				
				if(ValidatorUtil.isValid(user))
				{
					getUserBusiness().update(user);
					result.setStatus(Constants.SUCCESS);
					result.setMessage(Constants.MESSAGE_SUCCESS_USER_CHANGE_PASSWORD);
				}
				else
				{
					result.setStatus(Constants.FAILURE);
					result.setMessage(ValidatorUtil.getErrorMessages(user));
				}
			}
			else
			{
				result.setStatus(Constants.FAILURE);
				result.setMessage(Constants.MESSAGE_FAILURE_USER_CHANGE_PASSWORD_DIFF_PASSWORD);
			}
		}
		else
		{
			result.setStatus(Constants.FAILURE);
			result.setMessage(Constants.MESSAGE_FAILURE_USER_CHANGE_PASSWORD_USER_NOT_FOUND);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.service.rest.UserResouce#ping()
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("ping")
	@Override
	public String ping()
	{
		return "Users Resource is alive! " + Calendar.getInstance().getTime();
	}

	/* (non-Javadoc)
	 * @see com.marketbe.service.rest.UserResouce#loadByUsername(java.lang.String)
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("load/{username}")
	@Override
	public UserJSONResult loadByUsername(@PathParam("username") String username)
	{
		UserJSONResult result = new UserJSONResult();
		result.setMethod(Constants.GET);
		
		if(username != null)
		{
			result.setUser(userBusiness.findByUsername(username));
			result.setStatus(Constants.SUCCESS);
			result.setMessage(Constants.MESSAGE_SUCCESS_USER_LOAD);
		}
		else
		{
			result.setMessage(Constants.MESSAGE_FAILURE_USER_CHANGE_PASSWORD_USER_NOT_FOUND);
			result.setStatus(Constants.FAILURE);
		}
		
		return result;
	}

	/* (non-Javadoc)
	 * @see com.marketbe.service.rest.UserResouce#updateInformation(java.lang.String, java.lang.String, java.lang.String)
	 */
	@PUT
	@Produces({MediaType.APPLICATION_JSON})
	@Path("update")
	@Override
	public UserJSONResult updateInformation(@FormParam("username") String username, @FormParam("name") String name, @FormParam("email") String email)
	{
		UserJSONResult result = new UserJSONResult();
		result.setMethod(Constants.PUT);
		
		User user = userBusiness.findByUsername(username);
		
		if(user != null)
		{
			user.setName(name);
			user.setEmail(email);
			
			if(ValidatorUtil.isValid(user))
			{
				getUserBusiness().update(user);
				result.setStatus(Constants.SUCCESS);
				result.setMessage(Constants.MESSAGE_SUCCESS_USER_UPDATE);
				result.setUser(user);
			}
			else
			{
				result.setStatus(Constants.FAILURE);
				result.setMessage(ValidatorUtil.getErrorMessages(user));
			}
		}
		else
		{
			result.setMessage(Constants.MESSAGE_FAILURE_USER_CHANGE_PASSWORD_USER_NOT_FOUND);
			result.setStatus(Constants.FAILURE);
		}
		
		return result;
	}
}
