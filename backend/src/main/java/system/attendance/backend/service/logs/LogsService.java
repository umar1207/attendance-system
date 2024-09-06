package system.attendance.backend.service.logs;

import system.attendance.backend.dto.logs.LogResponseDto;
import system.attendance.backend.entity.Logs;

import java.util.List;

public interface LogsService {
    public void enterLog(Long cardId);
    public List<LogResponseDto> getAllLogs();
    public List<LogResponseDto> getLogsByName(String userName);
}
