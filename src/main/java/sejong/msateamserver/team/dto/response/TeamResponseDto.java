package sejong.msateamserver.team.dto.response;

import static sejong.msateamserver.team.vo.response.TeamResponse.*;

import sejong.msateamserver.team.vo.response.TeamResponse;

public class TeamResponseDto {
	public record CreateTeamResponseDto(
		Long teamSeq
	) {
		public CreateTeamResponse toCreateTeamResponse() {
			return new CreateTeamResponse(
				this.teamSeq
			);
		}
	}

	public record GetTeamResponseDto(
		Long teamSeq,
		String name,
		String uniqueNum,
		String details
	) {
		public GetTeamResponse toGetTeamResponse() {
			return new GetTeamResponse(
				this.teamSeq,
				this.name,
				this.uniqueNum,
				this.details
			);
		}
	}
}
