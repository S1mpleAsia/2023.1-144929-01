# Attendance App

Attendance app is a JavaFX application to keep track of employee working time in the company or in the department
<p>
    <img src="asset/thumbnail.jpg"  alt="Thumbnail Image"/>
</p>

## Description

Attendance app is a proof for the midterm mini project of IT4490 - Hanoi University of Science and Technology 

## App installs

1. Clone the repository
    ```
    git clone https://github.com/S1mpleAsia/2023.1-144929-01.git
   ```
2. Change directory to attendance-app folder
    ```
   cd attendance-app
   ```
3. Change the `database config` in the `Constraints.java` in the `utils` package that match to your configuration. (You must create new database before run the app)
4. Run `db.sql` file in `resource` folder to seed dummy data to database. 
5. Run the app with `Main.java` entry point. 
If you got the error `Error: JavaFX runtime components are missing, and are required to run this application` \
   Try to add this to VM Options `   --module-path PATH_TO_JAVA_SDK
                                     --add-modules=javafx.controls,javafx.fxml`

## Technologies

- Application: [JavaFX](https://openjfx.io/)
- Database: [MySQL](https://www.mysql.com/)
- Other: [Docker](https://www.docker.com/)

## License

[MIT](https://choosealicense.com/licenses/mit/)