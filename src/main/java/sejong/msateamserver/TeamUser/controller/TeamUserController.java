package sejong.msateamserver.TeamUser.controller;

import static sejong.msateamserver.TeamUser.vo.request.TeamUserRequest.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sejong.msateamserver.TeamUser.service.TeamUserService;
import sejong.msateamserver.global.response.BaseResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team-service/team-user")
public class TeamUserController {
	private final TeamUserService teamUserService;

	@PostMapping()
	public ResponseEntity<BaseResponse> createTeamUser(@RequestBody CreateTeamUserRequest request) {
		teamUserService.createTeamUser(request.toCreateTeamUserRequestDto());

		return ResponseEntity.ok().body(new BaseResponse());
	}

	@DeleteMapping()
	public ResponseEntity<BaseResponse> deleteTeamUser(@RequestParam(value = "studentId") String studentId) {
		teamUserService.deleteTeamUserAPI(studentId);

		return ResponseEntity.ok().body(new BaseResponse());
	}
}
