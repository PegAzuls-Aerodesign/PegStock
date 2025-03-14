# PegStock  

PegStock is a stock management system developed by [PegAzuls AeroDesign](https://www.instagram.com/pegazulsaerodesign/) to control the materials used in the team's projects. The system allows the registration of inputs, outputs, and loans of materials, as well as the generation of reports and notifications.

**All the rights of this project are reserved to PegAzuls AeroDesign team.**


## Installation
To install PegStock, follow the steps below:

1. Clone the repository
    ```bash
    git clone https://github.com/PegAzuls-Aerodesign/PegStock
    cd PegStock
    ```

2. Install the dependencies
    ```bash
    mvn clean install
    ``` 

## Configure the database
The application uses a PostgreSQL database. To configure the database, follow the steps below:

1. Create a PostgreSQL database
    ```postgresql
    CREATE DATABASE your_database;
    ```

2. Create a `application.properties` file in the `src/main/resources` directory
    ```bash
    cd src/main/resources
    # Linux
    touch application.properties
    # CMD
    echo > application.properties
    ```

3. Add the following content to the `application.properties` file:
    ```properties
    spring.datasource.url=jdbc:postgresql://localhost:your_port/your_database
    spring.datasource.username=your_username
    spring.datasource.password=your_password
    spring.datasource.driver-class-name=org.postgresql.Driver
    spring.jpa.database-platform=org.hibernate.dialect.PostgreSQLDialect
    spring.jpa.hibernate.ddl-auto=create
    ```
    Replace `your_port`, `your_database`, `your_username`, and `your_password` with your database information.
    
## Running the application
To run the application, run the command below:  

```bash
# Run JavaFX + Spring Boot application
mvn javafx:run
# Run only Spring Boot application
mvn spring-boot:run
```

# Documentation
The documentation of the project is available in the [Wiki](link)


# Collaborators
This project is maintened by the development team from PegAzuls AeroDesign. The main contributors are:
- [Clara Lopes](https://github.com/ClaraLeticia) (Member)
- [Joás Barros](https://github.com/joas-barros) (Member)
- [Laura Moroni](https://github.com/lauramoroni) (Member)
- [Lucas Silva](https://github.com/Lucassilv7) (Member)
