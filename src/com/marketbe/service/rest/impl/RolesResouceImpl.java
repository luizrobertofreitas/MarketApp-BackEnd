package com.marketbe.service.rest.impl;

import java.util.Calendar;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Service;

import com.marketbe.service.rest.RolesResource;

@Service("roles")
@Path("/roles")
public class RolesResouceImpl implements RolesResource
{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("ping")
	public String pingResource()
	{
		return "Roles Resource is alive! " + Calendar.getInstance().getTime();
	}

}
