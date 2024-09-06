package system.attendance.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import system.attendance.backend.service.logs.LogsService;

@RestController
@RequestMapping("api/v1/logs")
public class LogsController {
    @Autowired
    private LogsService logsService;

    @PostMapping("/{cardId}")
    public ResponseEntity<?> enterLog(@PathVariable Long cardId){
        logsService.enterLog(cardId);
        return ResponseEntity.status(HttpStatus.CREATED).body("Attendance Marked");
    }

    @GetMapping
    public ResponseEntity<?> getAllLog(){
        return ResponseEntity.status(HttpStatus.OK).body(logsService.getAllLogs());

    }

    @GetMapping("/{userName}")
    public ResponseEntity<?> getUserLogs(@PathVariable String userName){
        return ResponseEntity.status(HttpStatus.OK).body(logsService.getLogsByName(userName));
    }
}
