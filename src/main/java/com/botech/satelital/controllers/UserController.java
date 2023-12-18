package com.botech.satelital.controllers;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.botech.satelital.models.entities.User;
import com.botech.satelital.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> list(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id){
        Optional<User> oUser = userService.findById(id);
        if(oUser.isPresent()) {     return ResponseEntity.ok(oUser.get());      }
        return ResponseEntity.notFound().build();   
    }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody User user){
        return ResponseEntity.status(HttpStatus.CREATED).body(userService.save(user));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody User user, @PathVariable Long id){
        Optional<User> oUser = userService.update(user, id);
        if(oUser.isPresent()) {     return ResponseEntity.status(HttpStatus.CREATED).body(oUser.orElseThrow());      }
         return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> remove(@PathVariable Long id){
        Optional<User> oUser = userService.findById(id);
        if(oUser.isPresent()) {
            userService.deleteById(id);
            return ResponseEntity.noContent().build(); //204
        }
        return ResponseEntity.notFound().build();
    }
}
