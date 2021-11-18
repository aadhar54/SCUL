package com.example.jdbc4.demojdbc4.DBManager;

import com.example.jdbc4.demojdbc4.DAOs.Person;
import com.example.jdbc4.demojdbc4.Requests.CreateRequest;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBOperations {

    private static volatile Connection connection;


    public static Connection getConnection() throws SQLException {

        if(connection == null){

            synchronized (DBOperations.class){

                if(connection == null) {
                    connection = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/persons", "root", "root123");
                }
            }
        }

        return connection;

    }

    public static void closeConnection() throws SQLException {
        if(connection != null){

            synchronized (DBOperations.class){

                if(connection != null) {
                    connection = null;
                }
            }
        }
    }

    public static void createTable(String name) throws SQLException {

        getConnection();

        Statement statement = connection.createStatement();
        boolean isCreated = statement.execute("CREATE TABLE " + name + " ( id INT PRIMARY KEY AUTO_INCREMENT, name VARCHAR(20), age INT, " +
                "address VARCHAR(50))");

        if(isCreated){
            System.out.println("table " + name + " is successfully created");
        }

        closeConnection();
    }

    public static boolean insertPerson(CreateRequest request) throws SQLException {

        getConnection();

        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO Person(id,name,age,address) VALUES (null, ?, ?, ?)");
        preparedStatement.setString(1, request.getName());
        preparedStatement.setInt(2, request.getAge());
        preparedStatement.setString(3, request.getAddress());

        int rows_affected = preparedStatement.executeUpdate();

        closeConnection();

        if(rows_affected > 0){
            System.out.println("succesfully inserted the record");
            return true;
        }else{
            System.out.println("unable to insert the record");
            return false;
        }


    }

    public Person getPersonById(){
        return null;
    }

    public static List<Person> getPersons() throws SQLException {

        getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("SELECT * FROM Person");
        List<Person> persons = new ArrayList<>();
        while(resultSet.next()){

            int id = resultSet.getInt(1);
            String name = resultSet.getString(2);
            int age = resultSet.getInt(3);
            String add = resultSet.getString(4);

            Person person = new Person(id, name, age, add);

            System.out.println(person);

            persons.add(person);
        }

        closeConnection();
        return persons;
    }

    public static void deletePerson(int id){

    }

    public static void updatePerson(Person person){

    }
}
