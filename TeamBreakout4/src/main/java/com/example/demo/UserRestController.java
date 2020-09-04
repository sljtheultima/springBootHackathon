package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.Collection;
import java.util.Map;

@Controller
@RequestMapping("/users")
@CrossOrigin
public class UserRestController{

    @Autowired
    privateMap<Integer, User> userlist;

    @GetMapping(produces={"application/json","application/xml"})
    public ResponseEntity<Collection<User>> getAllUsers() {
        Collection<User> result = userlist.values();
        return ResponseEntity.ok().body(result);
    }

    @GetMapping(value="/{username}", produces={"application/json","application/xml"})
    public ResponseEntity<User> getUser(@PathVariable String username) {

    }






}