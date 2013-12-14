package net.snet.crm.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.yammer.dropwizard.config.Configuration;

public class CrmApiConfiguration extends Configuration {

  private String defaultName = "Anonymous";

  @JsonProperty
  public String getDefaultName() {
      return defaultName;
  }
}
