package com.marketbe.util;

import java.util.Iterator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

public final class ValidatorUtil
{
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	private ValidatorUtil(){}
	
	@SuppressWarnings("rawtypes")
	public static Boolean isValid(Object entity, Class clazz)
	{
		if(validator.validate(entity, clazz).isEmpty())
		{
			return true;
		}
		return false;
	}
	
	@SuppressWarnings("rawtypes")
	public static String getErrorMessages(Object entity, Class clazz)
	{
		Iterator<ConstraintViolation<Object>> iterator = validator.validate(entity, clazz).iterator();
		
		String messageObject = "";
		
		while(iterator.hasNext())
		{
			if(iterator.hasNext())
			{
				messageObject += iterator.next().getMessage() + ":";
			}
			else
			{
				messageObject += iterator.next().getMessage();
			}
			
		}
		
		return messageObject;
	}
}
