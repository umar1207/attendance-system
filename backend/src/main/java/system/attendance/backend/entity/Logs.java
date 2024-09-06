package system.attendance.backend.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter @Setter @NoArgsConstructor
public class Logs {
    @Id
    private Long logId;
    private LocalDateTime entryTime;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

}
