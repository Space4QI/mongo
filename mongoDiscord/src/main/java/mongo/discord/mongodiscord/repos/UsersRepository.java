package mongo.discord.mongodiscord.repos;

import mongo.discord.mongodiscord.models.Users;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface UsersRepository extends MongoRepository<Users, ObjectId> {
    //Optional<Users> findById(String userId);
    List<Users> findById(String userId);
}
