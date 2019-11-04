package java.fi.joufa.safetor.team.service.web.rest;

import javax.validation.constraints.NotNull;

public class TeamVM {
  private Long id;

  @NotNull private String name;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
