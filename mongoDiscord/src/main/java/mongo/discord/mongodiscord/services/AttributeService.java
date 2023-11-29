package mongo.discord.mongodiscord.services;

import com.github.javafaker.Faker;
import mongo.discord.mongodiscord.models.Attribute;
import mongo.discord.mongodiscord.repos.AttributeRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AttributeService {

    private final AttributeRepository attributeRepository;
    private final Faker faker;

    @Autowired
    public AttributeService(AttributeRepository attributeRepository, Faker faker) {
        this.attributeRepository = attributeRepository;
        this.faker = faker;
    }

    public List<Attribute> getAllAttributes() {
        return attributeRepository.findAll();
    }

    public Optional<Attribute> getAttributeById(ObjectId id) {
        return attributeRepository.findById(id);
    }

    public Attribute createRandomAttribute() {
        String randomAttributeNickname = faker.name().username() + " " + faker.regexify("[A-Za-z0-9]{8}");
        return attributeRepository.save(new Attribute(randomAttributeNickname));
    }

    public void deleteAttribute(ObjectId id) {
        attributeRepository.deleteById(id);
    }
}

//public interface AttributeService {
//    Attribute createAttribute(Attribute attribute);
//
//    Attribute getAttribute(String id);
//
//    void deleteAttribute(String id);
//
//    void deleteAllAttribute();
//
//    void saveAllAttribute(List<Attribute> attributes);
//
//    List<Attribute> getAllAttribute();
//}

