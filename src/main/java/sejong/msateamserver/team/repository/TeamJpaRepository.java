package sejong.msateamserver.team.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sejong.msateamserver.team.entity.TeamEntity;

@Repository
public interface TeamJpaRepository extends JpaRepository<TeamEntity, Long> {

}
