package sejong.msateamserver.TeamUser.mapper;

import static sejong.msateamserver.TeamUser.dto.request.TeamUserRequestDto.*;

import org.mapstruct.InjectionStrategy;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import sejong.msateamserver.TeamUser.entity.TeamUserEntity;

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface TeamUserMapper {
	@Mapping(target = "teamUserSeq", ignore = true)
	TeamUserEntity toTeamUserEntity(CreateTeamUserRequestDto requestDto);
}
