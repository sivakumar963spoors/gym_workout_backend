package com.gym.controller;

import com.gym.dto.WorkoutRequest;
import com.gym.entity.WorkoutLog;
import com.gym.service.WorkoutService;
import jakarta.validation.Valid; 
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/workouts")
@CrossOrigin(origins = "http://localhost:3000")
public class WorkoutController {

    private final WorkoutService service;

    public WorkoutController(WorkoutService service) {
        this.service = service;
    }

    @GetMapping
    public List<WorkoutLog> byMember(@RequestParam Long memberId) {
        return service.getWorkoutsByMember(memberId);
    }

    @GetMapping("/{id}")
    public WorkoutLog getOne(@PathVariable Long id) {
        return service.getWorkoutById(id);
    }

    @PostMapping
    public WorkoutLog create(@Valid @RequestBody WorkoutRequest req) {
        return service.createWorkout(req);
    }

    @PutMapping("/{id}")
    public WorkoutLog update(@PathVariable Long id,
                             @Valid @RequestBody WorkoutRequest req) {
        return service.updateWorkout(id, req);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteWorkout(id);
    }

    @GetMapping("/recent")
    public List<WorkoutLog> recent() {
        return service.recentWorkouts();
    }
}
