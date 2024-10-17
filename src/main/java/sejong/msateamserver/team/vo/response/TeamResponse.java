package sejong.msateamserver.team.vo.response;

public class TeamResponse {
	public record CreateTeamResponse(
		Long teamSeq
	) {

	}

	public record GetTeamResponse(
		Long teamSeq,
		String name,
		String uniqueNum,
		String details
	) {

	}
}
