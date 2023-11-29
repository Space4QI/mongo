//package mongo.discord.mongodiscord.services.impl;
//
//import mongo.discord.mongodiscord.models.Users;
//import mongo.discord.mongodiscord.repos.UsersRepository;
//import mongo.discord.mongodiscord.services.ServerService;
//
//import mongo.discord.mongodiscord.utils.ClientErrorException;
//import org.bson.types.ObjectId;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UsersServiceImpl {
//
//    private final UsersRepository usersRepository;
//
//    public UsersServiceImpl(UsersRepository usersRepository) {
//        this.usersRepository = usersRepository;
//    }
//
//    public Users findUserById(String userId) {
//        Optional<Users> userOptional = usersRepository.findById(userId);
//
//        if (userOptional.isPresent()) {
//            Users user = userOptional.get();
//            // Добавьте логирование, чтобы посмотреть, что возвращает метод
//            System.out.println("User found: " + user);
//            return user;
//        } else {
//            // Добавьте логирование, чтобы посмотреть, что происходит, если пользователя не найдено
//            System.out.println("User not found for ID: " + userId);
//            return null;
//        }
//    }
//
////    @Override
////    public Users createUsers(Users users) {
////        users.setId(ObjectId.get().toString());
////        usersRepository.save(users);
////        return users;
////    }
////
////    @Override
////    public Users getUsers(String id) {
////        return usersRepository.findById(id)
////                .orElseThrow(() -> new ClientErrorException.NotFoundException("Пользователь с id=[%s] не найден", id));
////    }
////
////    @Override
////    public void deleteUsers(String id) {
////        usersRepository.deleteById(id);
////    }
////
////    @Override
////    public void deleteAllUsers() {
////        usersRepository.deleteAll();
////    }
////
////    @Override
////    public void saveAllUsers(List<Users> users) {
////        usersRepository.saveAll(users);
////    }
////
////    @Override
////    public List<Users> getAllUsers() {
////        return usersRepository.findAll();
////    }
//}
