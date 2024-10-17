package sejong.msateamserver.team.repository;

import org.springframework.stereotype.Component;

import jakarta.ws.rs.BadRequestException;
import lombok.RequiredArgsConstructor;
import sejong.msateamserver.team.entity.TeamEntity;

@Component
@RequiredArgsConstructor
public class TeamRepositoryImpl implements TeamRepository {
	private final TeamJpaRepository teamJpaRepository;

	@Override
	public TeamEntity saveTeamEntity(TeamEntity teamEntity) {
		return teamJpaRepository.save(teamEntity);
	}

	@Override
	public TeamEntity findByTeamSeq(Long teamSeq) {
		return teamJpaRepository.findById(teamSeq)
			.orElseThrow(() -> new BadRequestException("TEAM SEQ Exception"));
	}
}
