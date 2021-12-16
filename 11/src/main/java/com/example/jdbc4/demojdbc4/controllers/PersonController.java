package com.example.jdbc4.demojdbc4.controllers;

import com.example.jdbc4.demojdbc4.DAOs.Person;
import com.example.jdbc4.demojdbc4.DBManager.DBOperations;
import com.example.jdbc4.demojdbc4.Requests.CreateRequest;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
public class PersonController {

    @GetMapping("/getPersons")
    public List<Person> getPersons() throws SQLException {

        // calling dao to get object from db
        return DBOperations.getPersons();

    }

    @PostMapping("/createTable")
    public boolean createTable(@RequestParam String name) throws SQLException {
        DBOperations.createTable(name);
        return true ;
    }

    @PostMapping("/insertPerson")
    public boolean insertPerson(@RequestBody CreateRequest request) throws SQLException {

        boolean operation_result = DBOperations.insertPerson(request);
        return operation_result;
    }



}
