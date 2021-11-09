
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

@RestController
public class SimpleController {

    DBUser db = new DBUser();

    // @GetMapping =
    // Spring Boot 2.3 ->
    // Spring 5 -> Spring 3 (90%)
    // produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    //public UserModel getUser(@PathVariable String id)

/* 
IN LAST CLASS WE STUDIED REQUEST PARAM

    @GetMapping("/search")
    public String searchAWord (@RequestParam String q) {
        DataStore db = new DataStore();
        return db.getFromDB(q);
    }

*/
    // http://localhost:8080/users  -> Get
    @GetMapping("/users")
    public List<User> getAllUsers(){
        return db.getAllUsers();

    }
    // http://localhost:8080/users/{id} --> Get
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getAUser(@PathVariable int id){
        User user1 =  db.getAUser(id);
        MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
        headers.put("server", Collections.singletonList("codeofChitkara"));

        HttpStatus status = HttpStatus.CREATED;
        ResponseEntity<User> response =
                new ResponseEntity<User>(user1,headers,status);
        return response;

    }

    // http://localhost:8080/users?q=Ramu --> Get
    @GetMapping("/user")
    public User getAUser(@RequestParam String q){
        return db.getAUserByName(q);
    }

    // POST APIs
    @PostMapping("/users")
    @ResponseStatus(HttpStatus.BAD_GATEWAY)
    public boolean createUser(@RequestBody User user)
                              {
        return db.addUser(user);

    }
  ///users/{id}
    @DeleteMapping("/users/{id}")
    public boolean deleteAUser(@PathVariable int id){
        return db.deleteAUser(id);
    }
   

}
