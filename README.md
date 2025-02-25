# trackingService

# Spring Boot Application Setup Guide

## Prerequisites

Before you begin, ensure that you have met the following requirements:

- Java 11 or later installed on your machine.
- Maven installed on your machine.
- An IDE or text editor of your choice (e.g., IntelliJ IDEA, Visual Studio Code).

## Clone the Repository

Clone the repository to your local machine:

```bash
git clone https://github.com/venkataponaganti39/trackingService.git
cd trackingservice
```

## Setup

1. **Install Java 11**

   Make sure you have Java 11 installed on your machine. You can verify this by running:

   ```bash
   java -version
   ```

   If you don't have Java 11 installed, download it from [Oracle's official website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html) or use a package manager like `brew` on macOS or `apt` on Ubuntu to install it.

2. **Install Maven**

   Ensure Maven is installed on your system. Verify by running:

   ```bash
   mvn -version
   ```

   If Maven is not installed, you can install it by following the instructions in the [Maven documentation](https://maven.apache.org/install.html).

## Running the Application

To run the application, follow these steps:

1. **Build the Application**

   In the project directory, run the following Maven command to build the application:

   ```bash
   mvn clean install
   ```

   This will clean any previous builds and install dependencies as defined in `pom.xml`.

2. **Run the Application**

   After the build is complete, you can run the application using the following Maven command:

   ```bash
   mvn spring-boot:run
   ```

   By default, the Spring Boot application will run on port 8080. You can customize the port by modifying the `application.properties` or `application.yml` file.

3. **Access the Application**

   Once the application is running, you can access it in your browser at:

   ```
   http://localhost:8080/next-tracking-number?origin_country_id=MY&destination_country_id=ID&weight=1.234&created_at=2018-11-20T19:29:32+08:00&customer_id=de619854-b59b-425e-9db4-943979elbd49&customer_name=RedBox%20Logistics&customer_slug=redbox-logistics
   
   ```

## Building a JAR

To create a packaged JAR file, use the following command:

```bash
mvn clean package
```

After the build completes, the JAR file will be located in the `target` directory (e.g., `target/application-name-0.0.1-SNAPSHOT.jar`).

You can run the JAR file with:

```bash
java -jar target/trackingservice-0.0.1-SNAPSHOT.jar
```

## Configuration

If you need to modify configuration settings, such as changing the port number or setting environment-specific properties, you can do so in the `src/main/resources/application.properties` or `src/main/resources/application.yml` file.

For example, to change the port number, add the following to `application.properties`:

```properties
server.port=8081
```

## Dependencies

The project uses the following dependencies (specified in the `pom.xml` file):

- Spring Boot 2.7.0
- Spring Web
- Spring Data JPA
- spring actuator
- spring devtools
- H2 Database (for in-memory DB, can be replaced with your preferred database)
- Other necessary dependencies for your specific use case.

## Troubleshooting

- **Port already in use**: If the default port 8080 is in use, you can change the port in the `application.properties` file as described above.
- **Missing dependencies**: If you get errors related to missing dependencies, ensure that all required dependencies are correctly listed in the `pom.xml` file and try running `mvn clean install` again.
