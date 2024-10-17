package sejong.msateamserver.team.vo.request;

import static sejong.msateamserver.team.dto.request.TeamRequestDto.*;

public class TeamRequest {
	public record CreateTeamRequest(
		String name,
		String uniqueNum,
		String details
	) {
		public CreateTeamRequestDto toCreateTeamRequestDto() {
			return new CreateTeamRequestDto(
				this.name,
				this.uniqueNum,
				this.details
			);
		}
	}

	public record UpdateTeamRequest(
		String name,
		String uniqueNum,
		String details
	) {
		public UpdateTeamRequestDto toUpdateTeamRequestDto() {
			return new UpdateTeamRequestDto(
				this.name,
				this.uniqueNum,
				this.details
			);
		}
	}
}
