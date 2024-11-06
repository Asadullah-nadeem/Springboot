Here’s a step-by-step guide on how to use this Spring Boot application:

### Prerequisites

1. **Java Development Kit (JDK)**: Ensure you have JDK 11 or later installed.
2. **MySQL Database**: Install MySQL and create a database. Also, add a table named `employee` to hold employee data.
3. **Spring Boot Setup**: Add the necessary dependencies to your `build.gradle` file if using Gradle.

### Step 1: Configure Database

In MySQL, create a database and an `employee` table:

```sql
CREATE DATABASE your_database_name;

USE your_database_name;

CREATE TABLE employee (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100)
);
```

Replace `your_database_name` with the name you want for your database.

### Step 2: Configure Application Properties

In `src/main/resources/application.properties`, set your MySQL connection properties:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
```

Replace `your_database_name`, `your_username`, and `your_password` with your actual database credentials.

### Step 3: Build and Run the Application

Navigate to your project directory and run the application using the Gradle command:

```bash
./gradlew bootRun
```

Alternatively, you can run the `Demo1Application.java` class directly from your IDE (e.g., IntelliJ, Eclipse) by clicking "Run."

### Step 4: Test the API Endpoints

You can use a tool like **Postman** or **curl** to test the REST endpoints.

1. **Get All Employees**
    - **Request**: `GET /api/employees`
    - **Example**: Retrieve all employees.
   ```bash
   curl -X GET http://localhost:8080/api/employees
   ```

2. **Add a New Employee**
    - **Request**: `POST /api/employees`
    - **Example**: Add a new employee with name "John Doe" and department "Engineering".
   ```bash
   curl -X POST http://localhost:8080/api/employees -H "Content-Type: application/json" -d '{"name": "John Doe", "department": "Engineering"}'
   ```

3. **Update an Employee**
    - **Request**: `PUT /api/employees`
    - **Example**: Update an existing employee with `id` = 1.
   ```bash
   curl -X PUT http://localhost:8080/api/employees -H "Content-Type: application/json" -d '{"id": 1, "name": "Jane Doe", "department": "HR"}'
   ```

4. **Delete an Employee**
    - **Request**: `DELETE /api/employees/{id}`
    - **Example**: Delete an employee with `id` = 1.
   ```bash
   curl -X DELETE http://localhost:8080/api/employees/1
   ```

### Summary of Endpoints

- **`GET /api/employees`**: Retrieve a list of all employees.
- **`POST /api/employees`**: Add a new employee.
- **`PUT /api/employees`**: Update an existing employee.
- **`DELETE /api/employees/{id}`**: Delete an employee by ID.

### Additional Notes

- **Error Handling**: For a real application, you might add error handling to ensure better responses when something goes wrong.
- **Testing**: You can create tests in the `DemoApplicationTests.java` file to verify each component works as expected.