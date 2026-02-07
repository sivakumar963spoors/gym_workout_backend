# Gym Workout Tracker

## Overview
Gym Workout Tracker is a simple full-stack application designed for trainers to log and manage workout sessions for gym members. The trainer can select a member, add workout logs, and view workout history. The application demonstrates a clean end-to-end flow using a relational database, RESTful APIs, and a React frontend.

This project focuses on correctness, data modeling, and full-stack integration rather than UI complexity.

---

## Features
- View list of gym members
- Select a member to view workout history
- Add new workout logs for a member
- View workout history sorted by date
- Backend validation for workout data
- RESTful API design

---

## Tech Stack

### Backend
- Java
- Spring Boot
- Spring Data JPA
- MySQL
- Maven

### Frontend
- React
- JavaScript
- HTML
- CSS
- Axios / Fetch API

---

## Application Architecture
The application follows a standard layered architecture:

- Controller Layer – Handles HTTP requests and responses
- Service Layer – Contains business logic
- Repository Layer – Interacts with the database using JPA
- Database Layer – MySQL with relational tables

---

## Database Design

### Members Table
| Column    | Type        | Description              |
|----------|-------------|--------------------------|
| id       | BIGINT (PK) | Auto-generated member ID |
| name     | VARCHAR     | Member name              |
| joinDate | DATE        | Member join date         |

### Workout Logs Table
| Column     | Type        | Description                              |
|------------|-------------|------------------------------------------|
| id         | BIGINT (PK) | Auto-generated workout log ID            |
| memberId  | BIGINT (FK) | References members(id)                   |
| date       | DATE        | Workout session date                     |
| exercise   | VARCHAR     | Exercise name                            |
| sets       | INT         | Number of sets                           |
| reps       | VARCHAR     | Repetitions (e.g. 12/10/8)               |
| weight     | DOUBLE      | Weight in kg (nullable)                  |
| notes      | TEXT        | Optional notes                           |

Relationship: One Member can have multiple Workout Logs.

---

## REST API Endpoints

### Members
- GET /api/members  
  Returns all gym members.

### Workouts
- GET /api/workouts?memberId={id}  
  Returns workouts for a member (sorted by date descending).

- GET /api/workouts/{id}  
  Returns a single workout log.

- POST /api/workouts  
  Creates a new workout log.

- PUT /api/workouts/{id}  
  Updates an existing workout log.

- DELETE /api/workouts/{id}  
  Deletes a workout log.

---

## Validation
- Exercise name must not be blank
- Sets and reps must be positive
- Member must exist before logging workouts
- Weight and notes are optional

---

## Frontend Flow
1. Application loads and fetches members.
2. Trainer selects a member.
3. Workout history for the selected member is displayed.
4. Trainer adds a workout using the form.
5. Workout history refreshes automatically.

---

## Running the Application

### Backend
1. Configure MySQL in application.properties.
2. Run the Spring Boot application:
   mvn spring-boot:run
3. Backend runs on http://localhost:8080

### Frontend
1. Install dependencies:
   npm install
2. Start the React app:
   npm start
3. Frontend runs on http://localhost:3000

---

## Sample Data
Sample members are preloaded for testing. Workout data can be added through the UI.

---

## Design Decisions
- Separate Member and WorkoutLog entities to maintain data normalization.
- Trainer-focused workflow for clarity.
- Simple UI with emphasis on functionality.
- Backend validation to ensure data integrity.

---

## Future Enhancements
- Edit and delete workouts from UI
- Filter workouts by date or exercise
- Member workout summaries
- Authentication and authorization

---

## Conclusion
This project demonstrates a complete full-stack workflow with proper database design, RESTful APIs, and frontend-backend integration. It is suitable for learning and interview evaluation purposes.
