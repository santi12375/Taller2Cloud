package co.com.taller2.userservice.controller;

import co.com.taller2.userservice.commons.FormatParser;
import co.com.taller2.userservice.commons.Response;
import co.com.taller2.userservice.commons.ResponseBuild;
import co.com.taller2.userservice.persistence.entity.User;
import co.com.taller2.userservice.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final ResponseBuild builder;
    private final FormatParser formatParser;

    @PostMapping
    public Response save(@Valid @RequestBody User user , BindingResult result){
        if (result.hasErrors()) {
            return builder.failed(formatParser.formatMessage(result));
        }
        try {
            userService.save(user);
        }catch (Exception e){
            return builder.badRequest();
        }
        return builder.success(user);
    }

    @DeleteMapping("/{id}")
    public Response delete(@PathVariable("id") Long id){
        try {
            User user = userService.findById(id);
            userService.delete(user);
            return builder.success(user);
        }catch (Exception e){
            return builder.badRequest();
        }
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
