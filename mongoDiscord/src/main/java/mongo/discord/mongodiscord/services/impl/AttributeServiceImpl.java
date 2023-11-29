//package mongo.discord.mongodiscord.services.impl;
//
//import mongo.discord.mongodiscord.models.Attribute;
//import mongo.discord.mongodiscord.repos.AttributeRepository;
//import mongo.discord.mongodiscord.services.AttributeService;
//import mongo.discord.mongodiscord.utils.ClientErrorException;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//
//@Service
//public class AttributeServiceImpl implements AttributeService {
//    private final AttributeRepository attributeRepository;
//
//    @Autowired
//    public AttributeServiceImpl(AttributeRepository attributeRepository) {
//        this.attributeRepository = attributeRepository;
//    }
//
//    @Override
//    public Attribute createAttribute(Attribute attribute) {
//        attribute.setId(ObjectId.get().toString());
//        attributeRepository.save(attribute);
//        return attribute;
//    }
//
//    @Override
//    public Attribute getAttribute(String id) {
//        return attributeRepository.findById(id)
//                .orElseThrow(() -> new ClientErrorException.NotFoundException("Аттрибут с id=[%s] не найден", id));
//    }
//
//    @Override
//    public void deleteAttribute(String id) {
//        attributeRepository.deleteById(id);
//    }
//
//    @Override
//    public void deleteAllAttribute() {
//        attributeRepository.deleteAll();
//    }
//
//    @Override
//    public void saveAllAttribute(List<Attribute> attributes) {
//        attributeRepository.saveAll(attributes);
//    }
//
//    @Override
//    public List<Attribute> getAllAttribute() {
//        return attributeRepository.findAll();
//    }
//}
