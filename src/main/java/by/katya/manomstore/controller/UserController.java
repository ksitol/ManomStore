package by.katya.manomstore.controller;

import by.katya.manomstore.entity.User;
import by.katya.manomstore.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/reg")
    public ResponseEntity<String> regUser(@RequestBody @NotNull User user){
        return new ResponseEntity(userService.reg(user), HttpStatus.OK);
    }

    @PostMapping(path = "/auth")
    public ResponseEntity<String> authUser(@RequestParam @NotNull String username, @RequestParam @NotNull String password){
        return new ResponseEntity(userService.auth(username, password), HttpStatus.OK);
    }

    @PostMapping(path = "/logout")
    public ResponseEntity<String> logoutUser(){
        return new ResponseEntity(userService.logout(), HttpStatus.OK);
    }


}
