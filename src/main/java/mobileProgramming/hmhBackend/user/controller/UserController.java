package mobileProgramming.hmhBackend.user.controller;

import mobileProgramming.hmhBackend.user.domain.User;
import mobileProgramming.hmhBackend.user.dto.UserDto;
import mobileProgramming.hmhBackend.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/user")
    public List<User> userList() {
        return userService.findAll();
    }

    @GetMapping(value = "/user/{id}")
    public UserDto userInfo(@PathVariable Long id) {
        return userService.findById(id);
    }

    @PutMapping(value = "/user")
    public String newUser(@RequestBody UserDto userDto) {
        userService.addUser(userDto);
        return "user/join";
    }

    @DeleteMapping(value = "/user")
    public String deleteUser(@RequestParam("id") Long id){
        userService.deleteUser(id);
        return "user/delete";
    }

}
