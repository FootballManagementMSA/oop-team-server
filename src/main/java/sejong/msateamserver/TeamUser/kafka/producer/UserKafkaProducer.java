package sejong.msateamserver.TeamUser.kafka.producer;

import lombok.RequiredArgsConstructor;

import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserKafkaProducer {
	private final KafkaTemplate<String, String> deleteUserKafkaTemplate;

	public void deleteUser(String studentId) {
		deleteUserKafkaTemplate.send("user-delete", studentId);
	}
}
