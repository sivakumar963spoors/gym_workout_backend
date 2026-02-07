package com.gym.repository;

import com.gym.entity.WorkoutLog;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface WorkoutLogRepository extends JpaRepository<WorkoutLog, Long> {

    List<WorkoutLog> findByMemberIdOrderByWorkoutDateDesc(Long memberId);
}
