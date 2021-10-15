package com.example.demo;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SimpleAPI {

    @GetMapping("/hello")
    public String sayHello(){
        return "Hello";
    }

    @GetMapping("/bye")
    public String sayBye(){
        return "Bye Students";
    }

    @GetMapping("/bestcollege")
    public String tellBestCollege(){
        return "Chitkara University";
    }

    // Taking Single Parameter
    @GetMapping("/exclusivehello")
    public String sayHelloToAbhay(@RequestParam String name){
        if(name.equalsIgnoreCase("abhay")){
            return "Hello Master Abhay , Welcome !";
        }else{
            return "Who are you ? My master is Abhay ";
        }
    }

    //Taking Multiple Parameter
    @GetMapping("/fullname")
    public String getFullName(@RequestParam String fname , @RequestParam String lname){
      return "Your full name is "+fname+" "+lname;
    }

    public static void main(String[] args) {
        HashmapDB hdb = new HashmapDB();
        System.out.println(hdb.getMeaning("Somaksh"));
        System.out.println(hdb.getMeaning("Abhay"));
    }


}
