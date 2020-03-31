package by.katya.manomstore.service;

import by.katya.manomstore.entity.User;
import by.katya.manomstore.exception.UserEx;
import by.katya.manomstore.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSession;
import java.util.Map;
import java.util.Optional;

@Component
public class UserService {

    @Autowired
    private User currentUser;

    private final UserRepository userRepository;
    private final HttpSession httpSession;

    @Autowired
    public UserService(UserRepository userRepository, HttpSession httpSession) {
        this.userRepository = userRepository;
        this.httpSession = httpSession;
    }

    public String reg (User user) {
       if (user != null) {
           userRepository.save(user);
       }
       return "reg";
    }

    public String auth (String username, String password) {
        User user1  = userRepository.findUserByUsername(username);
        if (!user1.getPassword().equals(password)) {
            throw new UserEx();
            }
            httpSession.setAttribute("currentUser", user1);
            userRepository.save(user1);
        return "auth";
    }

    public String logout () {
        httpSession.removeAttribute("currentUser");
        return  "logout";
    }


}
