package fi.joufa.safetor.team.service.web.rest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import fi.joufa.safetor.team.service.Application;
import fi.joufa.safetor.team.service.entity.TeamEntity;
import fi.joufa.safetor.team.service.mapper.TeamEntityMapper;
import fi.joufa.safetor.team.service.mapper.TeamVmMapper;
import fi.joufa.safetor.team.service.repository.TeamRepository;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(classes = Application.class)
public class TeamResourceIT {

  private static String TEST_TEAM_NAME = "Test team";

  @Autowired private TeamRepository teamRepository;

  @Autowired private TeamVmMapper teamVmMapper;

  @Autowired private TeamEntityMapper teamEntityMapper;

  private MockMvc mvc;

  @BeforeEach
  public void setup() {
    MockitoAnnotations.initMocks(this);
    final TeamResource teamResource =
        new TeamResource(teamRepository, teamEntityMapper, teamVmMapper);
    this.mvc = MockMvcBuilders.standaloneSetup(teamResource).build();
  }

  public static TeamEntity createEntity() {
    TeamEntity teamEntity = new TeamEntity();
    teamEntity.setName(TEST_TEAM_NAME);
    return teamEntity;
  }

  public static TeamVM createVM() {
    TeamVM teamVM = new TeamVM();
    teamVM.setName(TEST_TEAM_NAME);
    return teamVM;
  }

  @Test
  @Transactional
  public void createTeam() throws Exception {
    int sizeBeforeCreated = teamRepository.findAll().size();
    mvc.perform(
            post("/api/teams")
                .contentType(MediaType.APPLICATION_JSON)
                .content(TestUtils.convertObjectToJsonBytes(createVM())))
        .andExpect(status().isCreated());

    List<TeamEntity> teamEntities = teamRepository.findAll();
    assertThat(teamEntities).hasSize(sizeBeforeCreated + 1);
    TeamEntity testTeamEntity = teamEntities.get(teamEntities.size() - 1);
    assertThat(testTeamEntity.getName()).isEqualTo(TEST_TEAM_NAME);
  }
}
