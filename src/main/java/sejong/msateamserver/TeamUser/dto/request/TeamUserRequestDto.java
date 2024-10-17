package sejong.msateamserver.TeamUser.dto.request;

import sejong.msateamserver.TeamUser.entity.Role;

public class TeamUserRequestDto {
	public record CreateTeamUserRequestDto(
		Long teamSeq,
		String studentId,
		Role role,
		String introduce
	) {

	}

	public record DeleteTeamUserRequestDto(
		String studentId
	) {

	}
}
