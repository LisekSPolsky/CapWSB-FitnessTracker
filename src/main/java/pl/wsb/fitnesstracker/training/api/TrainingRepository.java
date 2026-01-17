package pl.wsb.fitnesstracker.training.api;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface TrainingRepository extends JpaRepository<Training, Long> {

    
    @Query("SELECT t FROM Training t WHERE t.user.id = :userId AND t.startTime >= :startDate")
    List<Training> findByUserIdAndStartTimeAfter(@Param("userId") Long userId, @Param("startDate") Date startDate);

    
    List<Training> findByUserId(Long userId);
}
