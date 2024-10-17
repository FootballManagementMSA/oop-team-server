package sejong.msateamserver.TeamUser.repository;

import sejong.msateamserver.TeamUser.entity.TeamUserEntity;

public interface TeamUserRepository {
	TeamUserEntity saveTeamUserEntity(TeamUserEntity teamUserEntity);

	void deleteAllByStudentId(String studentId);
}
