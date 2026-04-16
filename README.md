# Lab 11 Part 1: Unit Testing with JUnit and Mockito

This Maven project implements a Java application demonstrating unit testing with JUnit and service mocking with Mockito.

## Project Overview

### Components

#### 1. ArrayFlattener
- **Class**: `com.example.ArrayFlattener`
- **Method**: `flattenArray(int[][] nestedArray)`
- **Purpose**: Flattens a 2-D nested array into a 1-D array
- **Example**: `[[1,3], [0], [4,5,9]]` → `[1,3,0,4,5,9]`

#### 2. ArrayFlattenerService (Interface)
- **Interface**: `com.example.ArrayFlattenerService`
- **Method**: `flattenArray(int[][] nestedArray)`
- **Purpose**: Remote service interface for flattening arrays (simulates a remote/unavailable service)

#### 3. ArrayReversor
- **Class**: `com.example.ArrayReversor`
- **Method**: `reverseArray(int[][] nestedArray)`
- **Purpose**: Flattens a 2-D array and then reverses it
- **Dependency**: Uses `ArrayFlattenerService` to flatten the array
- **Example**: `[[1,3], [0], [4,5,9]]` → flattened to `[1,3,0,4,5,9]` → reversed to `[9,5,4,0,3,1]`

## Test Coverage

### ArrayFlattenerTest
Unit tests for the ArrayFlattener component with the following test cases:

1. **testFlattenArrayWithValidInput()** - Test Case A
   - Input: `[[1,3], [0], [4,5,9]]`
   - Expected: `[1,3,0,4,5,9]`
   - Verifies correct flattening of a valid 2-D array

2. **testFlattenArrayWithNullInput()** - Test Case B
   - Input: `null`
   - Expected: `NullPointerException`
   - Verifies proper error handling for null input

### ArrayReversorTest
Unit tests for the ArrayReversor component using Mockito to mock the ArrayFlattenerService:

1. **testReverseArrayWithValidInput()** - Test Case A
   - Input: `[[1,3], [0], [4,5,9]]`
   - Expected: `[9,5,4,0,3,1]`
   - **Mock Verification**: Confirms that `ArrayFlattenerService.flattenArray()` was called exactly once
   - Ensures the service was invoked and not bypassed

2. **testReverseArrayWithNullInput()** - Test Case B
   - Input: `null`
   - Expected: `NullPointerException` (thrown before service invocation)
   - **Mock Verification**: Confirms that `ArrayFlattenerService.flattenArray()` was NOT called
   - Validates null-check before service use

3. **testReverseArrayVerifyServiceInvocation()** - Additional Test
   - Demonstrates additional verification of service invocation with different data
   - Input: `[[1,2], [3]]`
   - Expected: `[3,2,1]`

## Test Suites

1. **ArrayFlattenerTestSuite**
   - Organizes all ArrayFlattener tests
   - Location: `src/test/java/com/example/ArrayFlattenerTestSuite.java`

2. **ArrayReversorTestSuite**
   - Organizes all ArrayReversor tests
   - Location: `src/test/java/com/example/ArrayReversorTestSuite.java`

## Project Structure

```
lab11part1/
├── pom.xml
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/
│   │           └── example/
│   │               ├── ArrayFlattener.java
│   │               ├── ArrayFlattenerService.java
│   │               └── ArrayReversor.java
│   └── test/
│       └── java/
│           └── com/
│               └── example/
│                   ├── ArrayFlattenerTest.java
│                   ├── ArrayFlattenerTestSuite.java
│                   ├── ArrayReversorTest.java
│                   └── ArrayReversorTestSuite.java
└── target/
    └── (Compiled output and test results)
```

## Building and Running Tests

### Prerequisites
- Java 11 or later
- Maven 3.6.0 or later

### Compile the Project
```bash
mvn clean compile
```

### Run Tests
```bash
mvn test
```

### Run Specific Test Suite
```bash
# Run ArrayFlattener tests
mvn test -Dtest=ArrayFlattenerTestSuite

# Run ArrayReversor tests
mvn test -Dtest=ArrayReversorTestSuite
```

### Full Build (Clean, Compile, Test)
```bash
mvn clean compile test
```

## Test Results

All tests pass successfully:
- **ArrayFlattenerTest**: 2 tests passed
- **ArrayReversorTest**: 3 tests passed
- **Total**: 5 tests passed, 0 failures

## Dependencies

### Production Dependencies
None

### Test Dependencies
- **JUnit 4.13.2** - Unit testing framework
- **Mockito 4.11.0** - Mocking framework for unit tests

## Key Testing Concepts Demonstrated

### 1. JUnit Testing
- Using `@Test` annotations
- Using `@Before` for test setup
- Using `@Test(expected = Exception.class)` for exception testing
- Using `assertArrayEquals()` for array comparisons

### 2. Mockito Mocking
- Creating mock objects with `@Mock` annotation
- Initializing mocks with `MockitoAnnotations.initMocks()`
- Configuring mock behavior with `when().thenReturn()`
- Verifying mock method calls with `verify()`
- Using `times()` to verify call count
- Using `never()` to verify method was not called
- Using `verifyNoMoreInteractions()` to ensure no unexpected calls

### 3. Test Organization
- Creating test classes with meaningful names
- Grouping tests into TestSuites for better organization
- Using Arrange-Act-Assert pattern in tests
- Clear test methods with descriptive names and comments

## Notes

- The `ArrayFlattenerService` is mocked in `ArrayReversorTest` to simulate a remote/unavailable service
- Mock verification ensures the service is actually being used, not bypassed
- Null input handling is tested to demonstrate proper error handling
- Test cases cover both positive scenarios (valid input) and negative scenarios (null input)

## Author
Lab 11 Part 1 - Applied Software Development

## Date
April 2026
