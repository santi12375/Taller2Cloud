package co.com.taller2.userservice.controller;

import co.com.taller2.userservice.persistence.entity.User;
import co.com.taller2.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping
    public User save(@RequestBody User user){
        userService.save(user);
        return user;
    }

    @DeleteMapping("/{id}")
    public User delete(@PathVariable("id") Long id){
        User user = userService.findById(id);
        userService.delete(user);
        return user;
    }

    @GetMapping
    public List<User> findAll(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public User findById(@PathVariable("id") Long id) {
        return userService.findById(id);
    }
}
