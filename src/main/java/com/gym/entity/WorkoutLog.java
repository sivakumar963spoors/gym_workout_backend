package com.gym.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "workout_logs")
public class WorkoutLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "member_id")
    private Member member;

    @Column(nullable = false)
    private LocalDate workoutDate;

    @Column(nullable = false)
    private String exerciseName;

    private int sets;
    private String reps;
    private Double weight;
    private String notes;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public LocalDate getWorkoutDate() {
		return workoutDate;
	}
	public void setWorkoutDate(LocalDate workoutDate) {
		this.workoutDate = workoutDate;
	}
	public String getExerciseName() {
		return exerciseName;
	}
	public void setExerciseName(String exerciseName) {
		this.exerciseName = exerciseName;
	}
	public int getSets() {
		return sets;
	}
	public void setSets(int sets) {
		this.sets = sets;
	}
	public String getReps() {
		return reps;
	}
	public void setReps(String reps) {
		this.reps = reps;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	@Override
	public String toString() {
		return "WorkoutLog [id=" + id + ", member=" + member + ", workoutDate=" + workoutDate + ", exerciseName="
				+ exerciseName + ", sets=" + sets + ", reps=" + reps + ", weight=" + weight + ", notes=" + notes
				+ ", getId()=" + getId() + ", getMember()=" + getMember() + ", getWorkoutDate()=" + getWorkoutDate()
				+ ", getExerciseName()=" + getExerciseName() + ", getSets()=" + getSets() + ", getReps()=" + getReps()
				+ ", getWeight()=" + getWeight() + ", getNotes()=" + getNotes() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

}
