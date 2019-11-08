package fi.joufa.safetor.team.service;

import fi.joufa.safetor.team.service.config.ApplicationProperties;
import fi.joufa.safetor.team.service.config.DefaultProfileUtil;
import java.util.Arrays;
import java.util.Collection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.core.env.Environment;

@SpringBootApplication
@EnableConfigurationProperties({ApplicationProperties.class})
public class Application implements InitializingBean {

  private static final Logger log = LoggerFactory.getLogger(Application.class);

  private final Environment environment;

  public Application(Environment environment) {
    this.environment = environment;
  }

  public static void main(String[] args) {
    SpringApplication app = new SpringApplication(Application.class);
    DefaultProfileUtil.addDefaultProfile(app);
    Environment env = app.run(args).getEnvironment();
    logStartup(env);
  }

  @Override
  public void afterPropertiesSet() throws Exception {
    Collection<String> activeProfiles = Arrays.asList(environment.getActiveProfiles());
    if (activeProfiles.contains("dev") && activeProfiles.contains("prod")) {
      log.error("Profiles 'dev' and 'prod' active at the same time ");
    }
  }

  private static void logStartup(Environment environment) {}
}
