package com.gym.service;

import com.gym.dto.WorkoutRequest;
import com.gym.entity.Member;
import com.gym.entity.WorkoutLog;
import com.gym.repository.MemberRepository;
import com.gym.repository.WorkoutLogRepository;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class WorkoutService {

    private final WorkoutLogRepository workoutRepo;
    private final MemberRepository memberRepo;

    public WorkoutService(WorkoutLogRepository workoutRepo,
                          MemberRepository memberRepo) {
        this.workoutRepo = workoutRepo;
        this.memberRepo = memberRepo;
    }

    public List<WorkoutLog> getWorkoutsByMember(Long memberId) {
        return workoutRepo.findByMemberIdOrderByWorkoutDateDesc(memberId);
    }

    public WorkoutLog getWorkoutById(Long id) {
        return workoutRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Workout not found"));
    }

    public WorkoutLog createWorkout(WorkoutRequest req) {
        Member member = memberRepo.findById(req.getMemberId())
                .orElseThrow(() -> new RuntimeException("Member not found"));

        WorkoutLog log = new WorkoutLog();
        log.setMember(member);
        log.setWorkoutDate(LocalDate.now());
        log.setExerciseName(req.getExerciseName());
        log.setSets(req.getSets());
        log.setReps(req.getReps());
        log.setWeight(req.getWeight());
        log.setNotes(req.getNotes());

        return workoutRepo.save(log);
    }

    public WorkoutLog updateWorkout(Long id, WorkoutRequest req) {
        WorkoutLog log = getWorkoutById(id);

        log.setExerciseName(req.getExerciseName());
        log.setSets(req.getSets());
        log.setReps(req.getReps());
        log.setWeight(req.getWeight());
        log.setNotes(req.getNotes());

        return workoutRepo.save(log);
    }

    public void deleteWorkout(Long id) {
        if (!workoutRepo.existsById(id)) {
            throw new RuntimeException("Workout not found");
        }
        workoutRepo.deleteById(id);
    }


    public List<WorkoutLog> recentWorkouts() {
        return workoutRepo.findAll(
                PageRequest.of(0, 10, Sort.by("workoutDate").descending())
        ).getContent();
    }
}
