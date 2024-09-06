package system.attendance.backend.service.logs;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import system.attendance.backend.dto.logs.LogResponseDto;
import system.attendance.backend.entity.Logs;
import system.attendance.backend.entity.User;
import system.attendance.backend.repository.LogsRepository;
import system.attendance.backend.repository.UserRepository;
import system.attendance.backend.service.user.UserService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class LogsServiceImpl implements LogsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LogsRepository logsRepository;

    @Override
    public void enterLog(Long cardId) {
        Optional<User> user = userRepository.findByCardId(cardId);
        if(user.isEmpty()){
            throw new EntityNotFoundException("Card does not exist");
        }
        User user1 = user.get();
        Logs logs = new Logs(LocalDateTime.now(), user1);
        logsRepository.save(logs);
    }

    @Override
    public List<LogResponseDto> getAllLogs() {
        List<Logs> logs = logsRepository.findAll();
        List<LogResponseDto> allLogs = new ArrayList<>();
        for(Logs lg: logs){
            LogResponseDto logResponseDto = new LogResponseDto(lg.getUser().getUserName(), lg.getUser().getUserTeam(), lg.getEntryTime());
            allLogs.add(logResponseDto);
        }
        return allLogs;
    }

    @Override
    public List<LogResponseDto> getLogsByName(String userName) {
        List<Logs> logs = logsRepository.getLogsByName(userName);
        List<LogResponseDto> userLogs = new ArrayList<>();
        for(Logs lg: logs){
            LogResponseDto logResponseDto = new LogResponseDto(lg.getUser().getUserName(), lg.getUser().getUserTeam(), lg.getEntryTime());
            userLogs.add(logResponseDto);
        }
        return userLogs;
    }
}
