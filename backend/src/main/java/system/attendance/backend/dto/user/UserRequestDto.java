package system.attendance.backend.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class UserRequestDto {
    private String userName;
    private String userTeam;
    private Long cardId;

    public UserRequestDto(String userName, String userTeam, Long cardId) {
        this.userName = userName;
        this.userTeam = userTeam;
        this.cardId = cardId;
    }
}
