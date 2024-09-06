package system.attendance.backend.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Logs {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long logId;
    private LocalDateTime entryTime;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public Logs(LocalDateTime entryTime, User user) {
        this.entryTime = entryTime;
        this.user = user;
    }
}
