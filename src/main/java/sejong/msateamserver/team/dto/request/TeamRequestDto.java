package sejong.msateamserver.team.dto.request;

public class TeamRequestDto {
	public record CreateTeamRequestDto(
		String name,
		String uniqueNum,
		String details
	) {

	}

	public record UpdateTeamRequestDto(
		String name,
		String uniqueNum,
		String details
	) {

	}
}
