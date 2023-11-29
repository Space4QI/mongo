//package mongo.discord.mongodiscord.services.impl;
//
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.model.Aggregates;
//import com.mongodb.client.model.Sorts;
//import mongo.discord.mongodiscord.models.Server;
//import mongo.discord.mongodiscord.repos.ServerRepository;
//import mongo.discord.mongodiscord.services.ServerService;
//import mongo.discord.mongodiscord.utils.ClientErrorException;
//import org.bson.Document;
//import org.bson.conversions.Bson;
//import org.bson.types.ObjectId;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Service;
//
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.List;
//
//@Service
//public class ServerServiceImpl implements ServerService {
//    private final ServerRepository serverRepository;
//
//    private final MongoTemplate mongoTemplate;
//
//    @Autowired
//    public ServerServiceImpl(ServerRepository serverRepository, MongoTemplate mongoTemplate) {
//        this.serverRepository = serverRepository;
//        this.mongoTemplate = mongoTemplate;
//    }
//
//    @Override
//    public Server createServer(Server server) {
//        server.setId(ObjectId.get().toString());
//        serverRepository.save(server);
//        return server;
//    }
//
//    @Override
//    public Server getServer(String id) {
//        return serverRepository.findById(id)
//                .orElseThrow(() -> new ClientErrorException.NotFoundException("Сервер с id=[%s] не найден", id));
//    }
//
//    @Override
//    public void deleteServer(String id) {
//        serverRepository.deleteById(id);
//    }
//
//    @Override
//    public void deleteAllServer() {
//        serverRepository.deleteAll();
//    }
//
//    @Override
//    public void saveAllServer(List<Server> server) {
//        serverRepository.saveAll(server);
//    }
//
//    @Override
//    public List<Server> getAllServer() {
//        return serverRepository.findAll();
//    }
//
//    @Override
//    public ArrayList<Document> getAllServersSorted() {
//        MongoCollection<Document> serverCollection = mongoTemplate.getCollection("server");
//
//        List<Bson> pipeline = Arrays.asList(
//                Aggregates.sort(Sorts.orderBy(
//                        Sorts.ascending("serverName"),
//                        Sorts.ascending("usersName"),
//                        Sorts.ascending("attributeNickname")
//                ))
//        );
//
//        return serverCollection.aggregate(pipeline).into(new ArrayList<>());
//    }
//}
