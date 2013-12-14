package net.snet.crm.api;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Environment;
import net.snet.crm.api.resources.CustomerResource;

public class CrmApiService extends Service<CrmApiConfiguration> {
  public static void main(String[] args) throws Exception {
    new CrmApiService().run(args);
  }

  @Override
  public void initialize(Bootstrap<CrmApiConfiguration> bootstrap) {
    bootstrap.setName("netbilldb-service");
  }

  @Override
  public void run(CrmApiConfiguration configuration, Environment environment) throws ClassNotFoundException {
    environment.addResource(new CustomerResource(configuration.getDefaultName()));
  }

}
