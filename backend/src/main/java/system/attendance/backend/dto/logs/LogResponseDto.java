package system.attendance.backend.dto.logs;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class LogResponseDto {
    private String userName;
    private String userTeam;
    private LocalDateTime entryTime;

    public LogResponseDto(String userName, String userTeam, LocalDateTime entryTime) {
        this.userName = userName;
        this.userTeam = userTeam;
        this.entryTime = entryTime;
    }
}
