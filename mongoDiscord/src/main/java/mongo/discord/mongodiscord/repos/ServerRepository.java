package mongo.discord.mongodiscord.repos;

import mongo.discord.mongodiscord.models.Server;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ServerRepository extends MongoRepository<Server, ObjectId> {
    Optional<Server> findByServerName(String s); // найти по имени сервера


}
