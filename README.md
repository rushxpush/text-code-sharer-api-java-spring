# Text Code Sharer

Text Code Sharer is a web application for sharing text and code snippets with ease. Built with Java Spring Boot, React, PostgreSQL, and Redis, it provides a performant and scalable platform for managing shared snippets.

## Table of Contents

1. [Features](#features)
2. Tech Stack(#tech-Stack)
3. Getting Started(#getting-started)
4. Environment Variables(#environement-variables)
5. API Endpoints(#api-endpoints)
6. Development Setup(#development-setup)
7. Contributing(#contributing)
8. License(#license)

## Features
* Create, read, update, and delete (CRUD) text/code snippets.
* Snippet expiration and one-time views.
* Search and categorize snippets.
* Caching with Redis for faster performance.

## Tech Stack
* Frontend: React
* Backend: Java Spring Boot
* Database: PostgreSQL
* Caching: Redis
* Deployment: Docker

## Getting Started

### Prerequisites
1. Docker and Docker Compose installed.
2. Java 21+ and Maven installed (if not using Docker for local development).
3. Node.js 16+ and npm/yarn installed (for the frontend).

```bash
git clone https://github.com/my_nickname/text-code-sharer-api-java-spring.git
cd text-code-sharer-api-java-spring
```

### Project Setup
1. Clone the repository:

```bash
git clone https://github.com/my_nickname/text-code-sharer-api-java-spring.git
cd text-code-sharer-api-java-spring
```

2. Build and run the backend:

	* With Docker
	
```bash
docker-compose up --build
```

	* Without Docker
	
```bash
./mvnw spring-boot:run
```

3. Configure the frontend: (Details will follow as the frontend get implemented.)

## Environment Variables

Create a <mark>env.properties</mark> file in the root directory with the following variables:
POSTGRES_DB_NAME=<YOUR_DB_NAME>
POSTGRES_DB_USERNAME=<YOUR_DB_USERNAME>
POSTGRES_DB_PASSWORD=<YOUR_DB_PASSWORD>
POSTGRES_DB_PORT=5432

### Backend:

```bash
SPRING_DATASOURCE_URL=jdbc:postgresql://localhost:5432/text_code_sharer
SPRING_DATASOURCE_USERNAME=your_username
SPRING_DATASOURCE_PASSWORD=your_password
REDIS_HOST=localhost
REDIS_PORT=6379
```

### Frontend:
(To be added later.)

## API Endpoints

| Method |	Endpoint    |	Description                  |
| ------ | ------------ | ---------------------------- |
| POST	 | api/snippets |	Create a new snippet         |
| GET	   | api/snippets |{id}	Retrieve a snippet by ID |
| DELETE | api/snippets |{id}	Delete a snippet         |
| GET	   | api/snippets |	List all snippets            |

## Development Setup

Backend: TODO
Frontend: TODO 
Database: Ensure PostgreSQL is running and a database named text_code_sharer is created:

```bash
CREATE DATABASE text_code_sharer;
```

Caching: Ensure Redis is running locally or via Docker:

```bash
docker run -d -p 6379:6379 redis
```

## Contributing

1. Fork the repository.
2. Create a new feature branch:

```bash
git checkout -b feature-name
```

3. Commit your changes and push the branch:

```bash
git push origin feature-name
```

4. Create a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](./blob/main/LICENSE) file for details.