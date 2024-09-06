package system.attendance.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter @Setter @NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String userName;
    private String userTeam;
    private Long cardId;

    @OneToMany(mappedBy = "user")
    private Set<Logs> logs;

    public User(String userName, String userTeam, Long cardId) {
        this.userName = userName;
        this.userTeam = userTeam;
        this.cardId = cardId;
    }
}
