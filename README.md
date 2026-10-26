# Innerverse — Personal Journaling & Mood Tracking

Innerverse is a full-stack personal journaling application designed to help users record their thoughts, track moods, and reflect on their experiences.

## Features

- **Journal entries:** Create and view journal entries.
- **Mood classification:** Categorizes journal text into moods such as Happy, Sad, Anxious, and Neutral using keyword-based logic.
- **Mood filtering:** Filter journal entries by mood.
- **Reflection support:** Optional reflection fields to record what was tried and whether it helped.
- **Timestamps:** Record when journal entries are created.
- **REST API:** Backend endpoints built with Spring Boot.
- **Database integration:** Uses Hibernate/JPA and an H2 database.
- **API testing:** Endpoints tested using Postman.

## Tech Stack

**Backend**
- Java
- Spring Boot
- REST APIs
- Hibernate and Spring Data JPA

**Database**
- H2 Database

**Frontend**
- HTML
- CSS
- JavaScript

**Tools**
- IntelliJ IDEA
- Maven
- Postman
- Git and GitHub

## Project Structure

The application source is currently organized inside the `project/` directory.

- `project/src/main/java/` — Java backend source code
- `project/src/main/resources/` — Application configuration
- `project/pom.xml` — Maven dependencies and build configuration

## Getting Started

### Prerequisites

- Java JDK compatible with the project's Maven configuration
- Git
- A modern web browser

### Run the Backend

1. Clone the repository:

   ```bash
   git clone https://github.com/Shweta7880/Innerverse.git
   ```

2. Open a terminal in the cloned repository and enter the project directory:

   ```bash
   cd Innerverse/project
   ```

3. Start the Spring Boot application on Windows:

   ```powershell
   .\mvnw.cmd spring-boot:run
   ```

4. The backend is configured to run at:

   `http://localhost:8081`

### Run the Frontend

Open the frontend's `index.html` file using a local development server, such as VS Code Live Server, if the frontend files are included in the repository. Ensure the backend is running.

## API Endpoints

| Method | Endpoint | Purpose |
|---|---|---|
| POST | `/api/journal` | Create a journal entry |
| GET | `/api/journal` | Retrieve journal entries |

Backend base URL: `http://localhost:8081`

## Database Note

The current development configuration uses an in-memory H2 database. Journal data is reset when the backend application restarts.

## Future Improvements

- Weekly and monthly mood summaries
- Historical emotional pattern insights
- Improved responsive user interface
- Persistent database storage
- More comprehensive automated tests

## Project Status

Developed as a personal full-stack learning and portfolio project.

This project is under active development, and features may evolve over time.
