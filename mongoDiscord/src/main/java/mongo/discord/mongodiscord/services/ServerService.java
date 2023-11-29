package mongo.discord.mongodiscord.services;

import com.github.javafaker.Faker;
import mongo.discord.mongodiscord.models.Server;
import mongo.discord.mongodiscord.repos.ServerRepository;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServerService {

    private final ServerRepository serverRepository;
    private final Faker faker;

    @Autowired
    public ServerService(ServerRepository serverRepository, Faker faker) {
        this.serverRepository = serverRepository;
        this.faker = faker;
    }

    public List<Server> getAllServers() {
        return serverRepository.findAll();
    }

    public Optional<Server> getServerById(ObjectId id) {
        return serverRepository.findById(id);
    }

    public Server createRandomServer() {
        String randomServerName = faker.gameOfThrones().house() + " Discord Сервер";
        return serverRepository.save(new Server(randomServerName, new ArrayList<>()));
    }

    public void deleteServer(ObjectId id) {
        serverRepository.deleteById(id);
    }

    public void saveAllServer(List<Server> servers) {
    }
}

//public interface ServerService {
//    Server createServer(Server server);
//
//    Server getServer(String id);
//
//    void deleteServer(String id);
//
//    void deleteAllServer();
//
//    void saveAllServer(List<Server> servers);
//
//    List<Server> getAllServer();
//
//    ArrayList<Document> getAllServersSorted();


