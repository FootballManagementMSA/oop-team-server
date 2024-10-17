package sejong.msateamserver.TeamUser.service;

import static sejong.msateamserver.TeamUser.dto.request.TeamUserRequestDto.*;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import sejong.msateamserver.TeamUser.kafka.producer.UserKafkaProducer;
import sejong.msateamserver.TeamUser.mapper.TeamUserMapper;
import sejong.msateamserver.TeamUser.repository.TeamUserRepository;
import sejong.msateamserver.feignClient.UserFeignClient;

@Service
@RequiredArgsConstructor
public class TeamUserService {
	private final UserFeignClient userFeignClient;

	private final TeamUserRepository teamUserRepository;

	private final TeamUserMapper teamUserMapper;

	private final UserKafkaProducer userKafkaProducer;

	@Transactional
	public void createTeamUser(CreateTeamUserRequestDto requestDto) {
		userFeignClient.getUser(requestDto.studentId());
		teamUserRepository.saveTeamUserEntity(teamUserMapper.toTeamUserEntity(requestDto));
	}

	@Transactional
	@KafkaListener(topics = "user-delete", groupId = "group-01")
	public void deleteTeamUser(String studentId) {
		System.out.println("Received delete user message for studentId: " + studentId);
		teamUserRepository.deleteAllByStudentId(studentId);
	}

	@Transactional
	public void deleteTeamUserAPI(String studentId) {
		try {
			System.out.println("Received delete user message for studentId: " + studentId);
			int deletedCount = teamUserRepository.deleteAllByStudentId(studentId);

			if (deletedCount == 0) {
				throw new RuntimeException("No records deleted for studentId: " + studentId); // No record found
			}

		} catch (Exception e) {
			System.out.println("Error occurred while deleting user: " + e.getMessage());
			userKafkaProducer.deleteUserRollback(e.getMessage());
			throw e;
		}
	}
}
