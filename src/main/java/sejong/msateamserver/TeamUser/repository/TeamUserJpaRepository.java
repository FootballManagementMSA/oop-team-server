package sejong.msateamserver.TeamUser.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import sejong.msateamserver.TeamUser.entity.TeamUserEntity;

@Repository
public interface TeamUserJpaRepository extends JpaRepository<TeamUserEntity, Long> {
	@Modifying
	@Transactional
	@Query("DELETE FROM TeamUserEntity t WHERE t.studentId = :studentId")
	void deleteAllByStudentId(@Param("studentId") String studentId);
}
