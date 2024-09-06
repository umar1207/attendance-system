package system.attendance.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    private Long userId;
    private String userName;
    private String userTeam;
    private Long cardId;

    @OneToMany(mappedBy = "user")
    private Set<Logs> logs;
}
