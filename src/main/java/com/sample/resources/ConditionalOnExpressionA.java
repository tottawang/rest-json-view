package com.sample.resources;

import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.stereotype.Component;

@ConditionalOnExpression("${SPRINGBOOT_CONDITION_A:false}")
@Component
public class ConditionalOnExpressionA {

  public ConditionalOnExpressionA() {
    System.out.println("");
  }

  public String getValue() {
    return "ConditionalA";
  }

}
