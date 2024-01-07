# Event-Management-System -Java Application
## Overview

Event Vista is a comprehensive event management system designed to streamline the planning, organization, and execution of events. 
This README.md file provides essential information on the required tools, setup instructions, and a brief overview of screens and the user interface.

## Required Tools

To run and contribute to the Event Vista project, you'll need the following tools:

- **Java Development Kit (JDK):** Event Vista is built using Java, so make sure you have JDK installed. You can download it [here](https://www.oracle.com/java/technologies/javase-downloads.html).

- **Eclipse IDE:** Eclipse is the integrated development environment used for this project. You can download it [here](https://www.eclipse.org/downloads/).

- **Git:** Git is a version control system used for managing the source code. You can download it [here](https://git-scm.com/downloads).

- **MySQL Database:** Event Vista uses MySQL for the backend. You can download it [here](https://dev.mysql.com/downloads/).

## Setup Instructions

### Install Java Development Kit (JDK):
- Download and install the latest version of JDK .

### Install Eclipse IDE:
- Download and install Eclipse IDE from.

### Set Up Eclipse:
- Open Eclipse.
- Create a new Java project for Event Vista.
- Create a new package for each screen (e.g., home,login, Create Event, TicketPurchasing, etc.).
- Add new files for each screen within the respective packages.

### Connect to MySQL Database:
- Download the JDBC Connector for MySQL from [here](https://dev.mysql.com/downloads/connector/j/).
- Add the JDBC Connector JAR file to your Eclipse project's build path.

### Link Eclipse to MySQL:
- Open Eclipse.
- In the "Data Source Explorer" view, right-click and select "New" -> "Database Connection."
- Choose MySQL and provide the necessary connection details (username, password, database URL).

### Create Tables in MySQL:
- In the files uploaded , there is eventvistaSDA.sql a file named `eventvista.sql`.
- Execute the SQL script to create the necessary tables in the MySQL database.

### Run the Application:
- Locate the `YourFrame.java` file in Eclipse.
- Right-click on the file and choose `Run As -> Java Application`.

### Access Event Vista:
- Open a web browser and navigate to `http://localhost:8080/EventVista`.
  
## Project Structure

- `/Code_Files`: Contains the Java source code files for the Event Vista application.
- `/SQL file`: SQL file related to database schema creation.

## Screenshots
![1](https://github.com/MahamKhurram2/Event-Management-Sysytem/assets/155904335/7db9e2f3-4171-4172-a822-1dee4c32fbd9)

![2](https://github.com/MahamKhurram2/Event-Management-Sysytem/assets/155904335/55a1fe05-61d3-4689-87c7-8f88af1ab6fa)

![3](https://github.com/MahamKhurram2/Event-Management-Sysytem/assets/155904335/2486ee3c-4935-47c6-87b1-fce2c2f1642a)



## License
This project is licensed under the [MIT License](LICENSE).


