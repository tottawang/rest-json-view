package com.sample.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

  Logger logger = LoggerFactory.getLogger(RestResource.class);

  @Value("${IT_OUTCOMES_FOLDER}")
  private String name;

  @Autowired
  private SampleService service;

  @GET
  @Path("test")
  @JsonView(Views.PublicView.class)
  public DomainObject getViewedObject() {
    System.out.println("test: " + name);
    return service.getValue();
  }

  @GET
  @Path("get-object")
  public DomainObject getObject() {
    return service.getValue();
  }

  @GET
  @Path("test-json-log")
  @JsonView(Views.PublicView.class)
  public void jsonLog() {
    try {
      throw new RuntimeException("test");
    } catch (Exception ex) {
      logger.error("test error log", ex);
    }
  }
}
