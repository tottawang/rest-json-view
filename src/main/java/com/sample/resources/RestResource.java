package com.sample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonView;
import com.sample.domain.DomainObject;
import com.sample.service.SampleService;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Path("/api")
public class RestResource {

  @Value("${IT_OUTCOMES_FOLDER}")
  private String name;

  @Autowired
  private SampleService service;

  @GET
  @Path("get-viewed-object")
  @JsonView(Views.PublicView.class)
  public DomainObject getViewedObject() throws InterruptedException {
    System.out.println("test: " + name);
    return service.getValue();
  }

  @GET
  @Path("get-object")
  public DomainObject getObject() {
    return service.getValue();
  }
}
