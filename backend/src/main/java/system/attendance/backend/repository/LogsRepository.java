package system.attendance.backend.repository;

import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import system.attendance.backend.entity.Logs;

import java.util.List;

@Repository
public interface LogsRepository extends JpaRepository<Logs, Long> {
    @Query("Select lg from Logs lg where lg.user.userName = :userName")
    public List<Logs> getLogsByName(@Param("userName") String userName);
}
