package sejong.msateamserver.team.service;

import static sejong.msateamserver.team.dto.request.TeamRequestDto.*;
import static sejong.msateamserver.team.dto.response.TeamResponseDto.*;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import sejong.msateamserver.team.entity.TeamEntity;
import sejong.msateamserver.team.mapper.TeamMapper;
import sejong.msateamserver.team.repository.TeamRepository;

@Service
@RequiredArgsConstructor
public class TeamService {
	private final TeamRepository teamRepository;

	private final TeamMapper teamMapper;

	@Transactional
	public CreateTeamResponseDto createTeam(CreateTeamRequestDto requestDto) {
		TeamEntity teamEntity = teamRepository.saveTeamEntity(teamMapper.toTeamEntity(requestDto));

		return teamMapper.toCreateTeamResponseDto(teamEntity);
	}

	@Transactional
	public void updateTeam(Long teamSeq, UpdateTeamRequestDto requestDto) {
		TeamEntity teamEntity = teamRepository.findByTeamSeq(teamSeq);
		teamEntity.updateTeamEntity(requestDto.name(), requestDto.uniqueNum(), requestDto.details());

		teamRepository.saveTeamEntity(teamEntity);
	}

	@Transactional(readOnly = true)
	public GetTeamResponseDto getTeam(Long teamSeq) {
		TeamEntity teamEntity = teamRepository.findByTeamSeq(teamSeq);

		return teamMapper.toGetTeamResponseDto(teamEntity);
	}
}
