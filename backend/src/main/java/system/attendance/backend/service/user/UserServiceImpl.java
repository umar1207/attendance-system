package system.attendance.backend.service.user;

import jakarta.persistence.EntityExistsException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.attendance.backend.dto.user.UserRequestDto;
import system.attendance.backend.dto.user.UserUpdateDto;
import system.attendance.backend.entity.User;
import system.attendance.backend.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public void createUser(UserRequestDto userRequestDto){
        Optional<User> checkUser = userRepository.findByCardId(userRequestDto.getCardId());
        if(checkUser.isPresent()){
            throw new EntityExistsException("Entity already exists"); //tbe
        }
        User user = new User(userRequestDto.getUserName(), userRequestDto.getUserTeam(), userRequestDto.getCardId());
        userRepository.save(user);
    }

    @Override
    public List<UserRequestDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        List<UserRequestDto> allUsers = new ArrayList<>();
        for(User u: users){
            UserRequestDto userRequestDto = new UserRequestDto(u.getUserName(), u.getUserTeam(), u.getCardId());
            allUsers.add(userRequestDto);
        }
        return allUsers;
    }

    @Override
    public void updateUser(Long userId, UserUpdateDto userUpdateDto) {
        Optional<User> findUser = userRepository.findById(userId);
        if(findUser.isEmpty()){
            throw new EntityNotFoundException("No user exists");
        }

        User user = findUser.get();
        if(userUpdateDto.getUserName() != null) user.setUserName(userUpdateDto.getUserName());
        if(userUpdateDto.getUserTeam() != null) user.setUserTeam(userUpdateDto.getUserTeam());
        userRepository.save(user);
    }
}
