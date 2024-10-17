package sejong.msateamserver.TeamUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sejong.msateamserver.TeamUser.entity.TeamUserEntity;

@Repository
public interface TeamUserJpaRepository extends JpaRepository<TeamUserEntity, Long> {

	int deleteAllByStudentId(String studentId);
}
