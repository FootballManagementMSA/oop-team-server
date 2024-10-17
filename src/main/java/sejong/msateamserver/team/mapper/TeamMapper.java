package sejong.msateamserver.team.mapper;

import static sejong.msateamserver.team.dto.request.TeamRequestDto.*;
import static sejong.msateamserver.team.dto.response.TeamResponseDto.*;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import sejong.msateamserver.team.dto.response.TeamResponseDto;
import sejong.msateamserver.team.entity.TeamEntity;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamMapper {
	@Mapping(target = "teamSeq", ignore = true)
	TeamEntity toTeamEntity(CreateTeamRequestDto requestDto);

	CreateTeamResponseDto toCreateTeamResponseDto(TeamEntity teamEntity);

	GetTeamResponseDto toGetTeamResponseDto(TeamEntity teamEntity);
}
