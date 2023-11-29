package mongo.discord.mongodiscord.services;

import com.github.javafaker.Faker;
import mongo.discord.mongodiscord.models.Users;
import mongo.discord.mongodiscord.repos.UsersRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UsersService {

    private final UsersRepository usersRepository;
    private final Faker faker;

    @Autowired
    public UsersService(UsersRepository usersRepository, Faker faker) {
        this.usersRepository = usersRepository;
        this.faker = faker;
    }

    public List<Users> getAllUsers() {
        return usersRepository.findAll();
    }

    public Optional<Users> getUserById(ObjectId id) {
        return usersRepository.findById(id);
    }

    public Users createRandomUser() {
        String randomNickname = faker.pokemon().name() + "#" + faker.number().numberBetween(1000, 9999);
        return usersRepository.save(new Users(randomNickname, new ArrayList<>()));
    }

    public Users getUserById(String userId) {
        return (Users) usersRepository.findById(userId);
    }

    public void deleteUser(ObjectId id) {
        usersRepository.deleteById(id);
    }
}

//public interface UsersService {
//    Users createUsers(Users users);
//
//   Users getUsers(String id);
//
//    void deleteUsers(String id);
//
//    void deleteAllUsers();
//
//    void saveAllUsers(List<Users> users);
//
//    List<Users> getAllUsers();
//
//
//
//}
