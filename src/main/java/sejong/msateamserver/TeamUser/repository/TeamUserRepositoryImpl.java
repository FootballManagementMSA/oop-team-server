package sejong.msateamserver.TeamUser.repository;

import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;
import sejong.msateamserver.TeamUser.entity.TeamUserEntity;

@Component
@RequiredArgsConstructor
public class TeamUserRepositoryImpl implements TeamUserRepository {
	private final TeamUserJpaRepository teamUserJpaRepository;

	@Override
	public TeamUserEntity saveTeamUserEntity(TeamUserEntity teamUserEntity) {
		return teamUserJpaRepository.save(teamUserEntity);
	}

	@Override
	public void deleteAllByStudentId(String studentId) {
		teamUserJpaRepository.deleteAllByStudentId(studentId);
	}
}
