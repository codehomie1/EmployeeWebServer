
### HPE: Employee Webserver

#### Technologies Used
- **Backend:** Java Spring Boot, RESTful Web Services
- **Testing:** Mockito, Postman

### Requirements
- **Build Tool:** Gradle 8.11.1
- **Java Version:** Java 17

## How to Run

1. **Clone the repository:**
    ```sh
    git clone https://github.com/yourusername/EmployeeWebServer.git
    cd EmployeeWebServer
    ```

2. **Build the project using Gradle:**
    ```sh
    ./gradlew build
    ```

3. **Run the application:**
    ```sh
    ./gradlew bootRun
    ```

4. **Access the application:**
    Open your web browser and navigate to `http://localhost:8080`.

5. **Testing the endpoints:**
    Use tools like Postman or curl to interact with the API endpoints.

### Endpoints

- **GET** `/api/getEmployees`
    - Returns a list of employees in JSON format.

- **POST** `/api/createEmployee`
    - Creates a new employee using the provided JSON request body.
    - Example JSON body:
    ```json
    {
        "employee_id": "1",
        "first_name": "John",
        "last_name": "Doe",
        "email": "johndoe@gmail.com",
        "title": "Designer"
    }
    ```

- **GET** `/api/getEmployee/{ID}`
    - Returns a single employee with the specified `{ID}` as a JSON object.

- **DELETE** `/api/deleteEmployee/{ID}`
    - Deletes the employee with the specified `{ID}`.