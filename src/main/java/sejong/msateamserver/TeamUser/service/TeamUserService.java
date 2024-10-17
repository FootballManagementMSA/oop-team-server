package sejong.msateamserver.TeamUser.service;

import static sejong.msateamserver.TeamUser.dto.request.TeamUserRequestDto.*;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import sejong.msateamserver.TeamUser.mapper.TeamUserMapper;
import sejong.msateamserver.TeamUser.repository.TeamUserRepository;
import sejong.msateamserver.feignClient.UserFeignClient;

@Service
@RequiredArgsConstructor
public class TeamUserService {
	private final UserFeignClient userFeignClient;

	private final TeamUserRepository teamUserRepository;

	private final TeamUserMapper teamUserMapper;

	@Transactional
	public void createTeamUser(CreateTeamUserRequestDto requestDto) {
		userFeignClient.getUser(requestDto.studentId());
		teamUserRepository.saveTeamUserEntity(teamUserMapper.toTeamUserEntity(requestDto));
	}

	@Transactional
	@KafkaListener(topics = "user-delete", groupId = "group-01")
	public void deleteTeamUser(String studentId) {
		teamUserRepository.deleteAllByStudentId(studentId);
	}
}
