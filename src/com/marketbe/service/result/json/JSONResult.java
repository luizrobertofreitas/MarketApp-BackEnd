package com.marketbe.service.result.json;

public interface JSONResult
{
	public String getMethod();
	public void setMethod(String method);
	public String getStatus();
	public void setStatus(String status);
	public String getMessage();
	public void setMessage(String message);
}
