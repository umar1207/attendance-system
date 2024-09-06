package system.attendance.backend.service.user;

import system.attendance.backend.dto.user.UserRequestDto;
import system.attendance.backend.dto.user.UserUpdateDto;

import java.util.List;

public interface UserService {
    public void createUser(UserRequestDto userRequestDto);
    public List<UserRequestDto> getAllUsers();
    public void updateUser(Long userId, UserUpdateDto userUpdateDto);
}
