package sejong.msateamserver.team.controller;

import static sejong.msateamserver.global.response.constant.ResponseMessageConstant.*;
import static sejong.msateamserver.global.response.constant.StatusCodeConstant.*;
import static sejong.msateamserver.team.dto.response.TeamResponseDto.*;
import static sejong.msateamserver.team.vo.request.TeamRequest.*;
import static sejong.msateamserver.team.vo.response.TeamResponse.*;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import sejong.msateamserver.global.response.BaseResponse;
import sejong.msateamserver.global.response.DataResponse;
import sejong.msateamserver.team.service.TeamService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/team-service/team")
public class TeamController {
	private final TeamService teamService;

	@PostMapping()
	public ResponseEntity<DataResponse> createTeam(@RequestBody CreateTeamRequest request) {
		CreateTeamResponseDto responseDto = teamService.createTeam(request.toCreateTeamRequestDto());
		CreateTeamResponse response = responseDto.toCreateTeamResponse();

		return ResponseEntity.ok().body(new DataResponse(OK_STATUS_CODE, SUCCESS, response));
	}

	@PutMapping()
	public ResponseEntity<BaseResponse> updateTeam(
		@RequestBody UpdateTeamRequest request,
		@RequestParam(value = "teamSeq") Long teamSeq
	) {
		teamService.updateTeam(teamSeq, request.toUpdateTeamRequestDto());

		return ResponseEntity.ok().body(new BaseResponse());
	}

	@GetMapping()
	public ResponseEntity<DataResponse> getTeam(@RequestParam(value = "teamSeq") Long teamSeq) {
		GetTeamResponseDto responseDto = teamService.getTeam(teamSeq);
		GetTeamResponse response = responseDto.toGetTeamResponse();

		return ResponseEntity.ok().body(new DataResponse(OK_STATUS_CODE, SUCCESS, response));
	}
}
