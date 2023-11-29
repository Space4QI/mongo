package mongo.discord.mongodiscord.controllers;

import mongo.discord.mongodiscord.models.Users;
import mongo.discord.mongodiscord.services.UsersService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UsersController {

    private final UsersService usersService;

    @Autowired
    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/all")
    public List<Users> getAllUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/{id}")
    public Users getUserById(@PathVariable("id") String id) {
        return usersService.getUserById(new ObjectId(id)).orElse(null);
    }


    @PostMapping("/new")
    public Users createRandomUser() {
        return usersService.createRandomUser();
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        usersService.deleteUser(new ObjectId(id));
    }

}


//@RestController
//public class UsersController {
//
//    private final UsersServiceImpl usersServiceimpl;
//
//    @Autowired
//    public UsersController(UsersServiceImpl usersServiceimpl) {
//        this.usersServiceimpl = usersServiceimpl;
//    }
//
//    @GetMapping("/users/{userId}")
//    public ResponseEntity<Users> getUserById(@PathVariable String userId) {
//        Users user = usersServiceimpl.findUserById(userId);
//        return (user != null) ? ResponseEntity.ok(user) : ResponseEntity.notFound().build();
//    }
        //
//    @GetMapping("/users/all")
//    List<Users> getAllUsers() {
//        return usersService.getAllUsers();
//    }
//
//    @GetMapping("/users/{id}")
//    Users getUsersById(@PathVariable("id") String id) {
//        return usersService.getUsers(id);
//    }
//
//
//    @PostMapping("/users/new")
//    Users newUsers(@RequestBody Users newUsers) {
//        return usersService.createUsers(newUsers);
//    }
//
//    @DeleteMapping("/users/{id}")
//    void deleteUsers(@PathVariable String id) {
//        usersService.deleteUsers(id);
//    }


