package com.empiricism.kafkatut.user;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/kafka")
public class UserController {
    private UserProducer userProducer;

    public UserController(UserProducer userProducer) {
        this.userProducer = userProducer;
    }

    @PostMapping("/user")
    public ResponseEntity<String> publish(@RequestBody User user){
        userProducer.sendMessage(user);
        return ResponseEntity.ok("JSON Message sent kafka topic users");

    }
}
