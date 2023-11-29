package mongo.discord.mongodiscord.repos;

import mongo.discord.mongodiscord.models.Attribute;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AttributeRepository extends MongoRepository<Attribute, ObjectId> {
}
