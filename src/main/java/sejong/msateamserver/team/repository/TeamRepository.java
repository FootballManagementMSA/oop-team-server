package sejong.msateamserver.team.repository;

import sejong.msateamserver.team.entity.TeamEntity;

public interface TeamRepository {
	TeamEntity saveTeamEntity(TeamEntity teamEntity);
	TeamEntity findByTeamSeq(Long teamSeq);
}
