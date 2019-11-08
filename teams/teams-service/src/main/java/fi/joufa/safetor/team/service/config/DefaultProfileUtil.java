package fi.joufa.safetor.team.service.config;

import java.util.HashMap;
import java.util.Map;
import org.springframework.boot.SpringApplication;

public class DefaultProfileUtil {
  private static final String SPRING_PROFILE_DEFAULT = "spring.profiles.default";

  private DefaultProfileUtil() {}

  public static void addDefaultProfile(SpringApplication application) {
    Map<String, Object> props = new HashMap<>();
    props.put(SPRING_PROFILE_DEFAULT, "dev");
    application.setDefaultProperties(props);
  }
}
