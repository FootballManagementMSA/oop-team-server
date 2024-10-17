package sejong.msateamserver.TeamUser.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import sejong.msateamserver.global.entity.BaseTimeEntity;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Entity
@Table(name = "team_user_tb")
public class TeamUserEntity extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_user_seq")
	private Long teamUserSeq;

	@Column(name = "team_seq", nullable = false)
	private Long teamSeq;

	@Column(name = "student_id", nullable = false)
	private String studentId;

	@Column(name = "accept", columnDefinition = "boolean default false")
	private Boolean accept;

	@Column(name = "role", nullable = false)
	@Enumerated(EnumType.STRING)
	private Role role;

	@Column(name = "introduce", nullable = false)
	private String introduce;
}
