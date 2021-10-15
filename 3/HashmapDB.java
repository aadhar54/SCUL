package com.example.demo;

import java.util.HashMap;

public class HashmapDB {

    private HashMap<String,String> db = new HashMap<>();


    public HashmapDB(){
        db.put("Harsh","Happiness");
        db.put("Abhay","No Worries");
        db.put("Somaksh","Shiva's Eyes");
        db.put("Tushar","Snow");
        db.put("Aadhar","Foundation");
    }

    public String getMeaning(String name){
        return db.get(name);
    }

}
