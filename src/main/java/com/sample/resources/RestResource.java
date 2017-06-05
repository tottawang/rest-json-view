package com.sample.resources;

import java.util.Optional;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Produces(MediaType.APPLICATION_JSON)
@Path("/api")
public class RestResource {

  @Autowired
  private Optional<ConditionalOnExpressionA> conditionalA;

  @Autowired
  private Optional<ConditionalOnPropertyB> conditionalB;

  @GET
  @Path("condition")
  public String getConditional() {
    if (conditionalA.isPresent()) {
      return conditionalA.get().getValue();
    } else {
      return "Not Found A";
    }
  }

  @GET
  @Path("condition-b")
  public String getConditionalB() {
    if (conditionalB.isPresent()) {
      return conditionalB.get().getValue();
    } else {
      return "Not Found B";
    }
  }

}
