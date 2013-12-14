package net.snet.crm.api.resources;

import com.google.common.base.Optional;
import com.yammer.metrics.annotation.Timed;
import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.atomic.AtomicLong;
import java.util.HashMap;
import java.util.Map;

@Path("/customers")
@Produces(MediaType.APPLICATION_JSON)
public class CustomerResource {
  private static final Logger LOGGER = LoggerFactory.getLogger(CustomerResource.class);

  private final String defaultName;
  private final AtomicLong counter;

  public CustomerResource(final String defaultName) {
    this.defaultName = defaultName;
    this.counter = new AtomicLong();
  }

  @GET
  @Timed(name="get-requests")
  public Map<String, Object> status(@QueryParam("name") Optional<String> name) {
    LOGGER.debug("[{}] status called with '{}' name param", counter.incrementAndGet(), name.or(defaultName));
    Map<String, Object> status = new HashMap<String, Object>();
    status.put("name", name.or(defaultName));
    status.put("timestamp", new DateTime());
    return status;
  }


}
