# Testing-Spring-Boot-App-with-JUnit-Mockito-and-Testcontainers

# Introduction
## What is Unit Testing 
- **Unit Testing** involves the testing of *each unit* or an individual component of the software application.
- The purpose is to validate that each unit of the software code performs as expected
- Unit Testing is done during development (coding phase) of an application by the developers
- Unit may be an individual function, method, procedure, module and object

## What is Integration Testing
- As the name suggests, integration tests focus on integrating different layers of the application. That also means no mocking is involved.
- We write integration tests for testing a feature which may involve interaction with multiple components
- Examples:
  - **Employee Management Feature**: EmployeeRepository, EmployeeService, EmployeeController
  - **User Management Feature**: UserController, UserService, and UserRepository
  - **Login Feature**: LoginRepository, LoginController, LoginService

## Best Practices of Unit Testing in Java
### Source Code Structure
- It's a good idea to keep the test classes separate from the main source code. So, they are developed, executed, and maintained separately from the production code.
- Also, it avoids any possibility of running test code in the production environment
- We can follow the steps of the build tools like Maven and Gradle that look for src/test directory for test implementations

### Package Naming Convention
- We should create a similar package structure in the src/test  directory for test classes. Thus, improving the readability and maintainability of the test code.
- The package of the test class should match the package of the source class whose unit of source code it'll test.

### Unit Test Case Naming Convention
- The test names should be insightful, and users should understand the behavior and expectation of the test by just glancing name itself.
- Given/when/then BDD style
  - givenEmployeeObject_whenSaveEmployee_thenReturnSavedEmployee
  - givenEmployeesList_whenFindAll_thenReturnListOfEmployees
  - givenEmployeeObject_whenUpdateEmployee_thenReturnUpdatedEmployee

### Appropriate Assertions
- Always use proper assertions to verify the expected vs actual results. 
- We should use various methods available in the Assert class of JUnit or similar frameworks like AssertJ.

### Mock External Services
- Although unit tests concentrate on specific and smaller pieces of code, there is a change that the code is dependent on external services for some logic.
- Therefore, we should mock the external services and merely test the logic and execution of our code for varying scenarios
- We can use various frameworks like Mockito, EasyMock, and JMockit for mocking external services.

### Specific Unit Tests
- Instead of adding multiple assertions to the same unit test, we should create separate test classes.
- Of course, it's sometimes tempting to verify multiple scenarios in the same test, but it's a good idea to keep them separate.
- Then, in the case of test failures, it'll be easier to determine which specific scenario failed and, likewise, simpler to fix the code.
- Therefore, always write a unit test to test a single specific scenario.

## Understanding Spring Boot Starter Test Dependency
- The Spring Boot Starter Test dependency is a primary dependency for testing the Spring Boot Applications.
- It holds all the necessary elements required for the testing.
- This starter includes:
  - Spring Specific Dependencies
  - Dependencies for Auto-Configuration
  - Set of Testing Libraries - JUnit, Mockito, Hamcrest, AssertJ, JSONassert, and JsonPath
- When we use this starter, we don't need to update the versions of all the dependencies (JUnit, Mockito, Hamcrest, AssertJ, JSONassert, and JsonPath) manually.
- The Spring Boot parent POM handles all dependency versions, and the Spring Boot team ensures the different testing dependencies work properly together.

# Unit Testing Repository Layer
- We don't use Mockito for Repository Layer as it not dependent to any layer, it's directly connected to the database.

## Repository Testing
- Overview of @DataJpaTest annotation
- Unit Test for Save Employee Operation
- Unit Test for Get All Employees Operation
- Unit Test for Get Employee by Id Operation
- Unit Test for Get Employee by Email Operation (Custom Query)
- Unit Test for Update Employee Operation
- Unit Test for Delete Employee Operation
- Unit Test for Custom Query using JPQL with Index Parameters (using @Query annotation)
- Unit Test for Custom Query using JPQL with Named Parameters (using @Query annotation)
- Unit Test for Custom Native Query with Index Parameters (using @Query annotation)
- Unit Test for Custom Native Query with Named Parameters (using @Query annotation)
- Refactoring JUnit Tests to Use @BeforeEach annotation

### JUnit Tests in BDD Style
#### Syntax
```java
@Test
public void given_when_then() {
    //given - precondition or setup
    //when - action or the behavior we're testing
    //then - verify the output
}
```

#### Example
```java
@Test
public void givenEmployeeObj_whenSave_thenReturnSavedEmployee() {   
    //given - precondition or setup
  Employee employee = Employee.builder()
          .firstName("Ramesh")
          .lastName("Ramesh")
          .email("ramesh@gmail.com")
          .build();
  
    //when - action or the behavior we're testing
    Employee savedEmployee = employeeRepository.save(employee);
    
    //then - verify the output
    assertThat(savedEmployee).isNotNull();
    assertThat(savedEmployee.getId()).isGreaterThan(0);
}
```

# Unit Testing Service Layer
# Unit Testing Controller Layer (Unit Testing of REST APIs)
# Integration Testing using Local MySQL Database
# Spring WebFlux - Build Reactive CRUD REST APIs
# Spring WebFlux - Unit Testing Reactive CRUD REST APIs
# Spring WebFlux - Integration Testing Reactive CRUD REST APIs