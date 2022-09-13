package ca.uhn.fhir.jpa.starter;

import javax.servlet.ServletException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Import;

@Import(AppProperties.class)
public class JpaRestfulServer extends BaseJpaRestfulServer {

  @Autowired AppProperties appProperties;

  private static final long serialVersionUID = 1L;

  public JpaRestfulServer() {
    super();
  }

  @Override
  protected void initialize() throws ServletException {
    super.initialize();

    // Add your own customization here
    this.registerInterceptor(
        new BasicAuthorizationInterceptor(
            appProperties.getServer_client_id(), appProperties.getServer_client_secret()));
  }
}
