package com.marketbe.util;

import java.util.Iterator;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.groups.Default;


public final class ValidatorUtil
{
	private static Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	private ValidatorUtil(){}
	
	public static Boolean isValid(Object entity)
	{
		if(validator.validate(entity, Default.class).isEmpty())
		{
			return true;
		}
		return false;
	}
	
	public static String getErrorMessages(Object entity)
	{
		Iterator<ConstraintViolation<Object>> iterator = validator.validate(entity, Default.class).iterator();
		
		String messageObject = "";
		
		while(iterator.hasNext())
		{
			ConstraintViolation<Object> cv = iterator.next();
			
			if(iterator.hasNext())
			{
				messageObject += cv.getMessage() + ":";
			}
			else
			{
				messageObject += cv.getMessage();
			}
		}
		
		return messageObject;
	}
}
