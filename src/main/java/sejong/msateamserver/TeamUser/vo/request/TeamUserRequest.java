package sejong.msateamserver.TeamUser.vo.request;

import static sejong.msateamserver.TeamUser.dto.request.TeamUserRequestDto.*;

import sejong.msateamserver.TeamUser.entity.Role;

public class TeamUserRequest {
	public record CreateTeamUserRequest(
		Long teamSeq,
		String studentId,
		Role role,
		String introduce
	) {
		public CreateTeamUserRequestDto toCreateTeamUserRequestDto() {
			return new CreateTeamUserRequestDto(
				this.teamSeq,
				this.studentId,
				this.role,
				this.introduce
			);
		}
	}

	public record DeleteTeamUserRequest(
		String studentId
	) {
		public DeleteTeamUserRequestDto toDeleteTeamUserRequestDto() {
			return new DeleteTeamUserRequestDto(
				this.studentId
			);
		}
	}
}
