package sejong.msateamserver.team.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;
import sejong.msateamserver.global.entity.BaseTimeEntity;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "team_tb")
public class TeamEntity extends BaseTimeEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "team_seq")
	private Long teamSeq;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "unique_num", nullable = false)
	private String uniqueNum;

	@Column(name = "details", nullable = false)
	private String details;

	public void updateTeamEntity(String name, String uniqueNum, String details) {
		this.name = name;
		this.uniqueNum = uniqueNum;
		this.details = details;
	}
}