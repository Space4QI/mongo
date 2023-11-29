package mongo.discord.mongodiscord.controllers;

import mongo.discord.mongodiscord.models.Server;
import mongo.discord.mongodiscord.repos.ServerRepository;
import mongo.discord.mongodiscord.services.ServerService;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/servers")
public class ServerController {

    private final ServerService serverService;

    @Autowired
    public ServerController(ServerService serverService) {
        this.serverService = serverService;
    }

    @GetMapping("/all")
    public List<Server> getAllServers() {
        return serverService.getAllServers();
    }

    @GetMapping("/{id}")
    public Server getServerById(@PathVariable("id") String id) {
        return serverService.getServerById(new ObjectId(id)).orElse(null);
    }

    @PostMapping("/new")
    public Server createRandomServer() {
        return serverService.createRandomServer();
    }

    @DeleteMapping("/{id}")
    public void deleteServer(@PathVariable String id) {
        serverService.deleteServer(new ObjectId(id));
    }
}


//@RestController
//public class ServerController {
//
//    private final ServerService serverService;
//
//    private final ServerRepository serverRepository;
//
//    @Autowired
//    public ServerController(ServerService serverService, ServerRepository serverRepository) {
//        this.serverService = serverService;
//        this.serverRepository = serverRepository;
//    }
//
//    @GetMapping("/server/all")
//    List<Server> getAllServer() {
//        return serverService.getAllServer();
//    }
//
//    @GetMapping("/server/{id}")
//    Server getServerById(@PathVariable("id") String id) {
//        return serverService.getServer(id);
//    }
//
//    @PostMapping("/server/new")
//    Server newServer(@RequestBody Server newServer) {
//        return serverService.createServer(newServer);
//    }
//
//    @DeleteMapping("/server/{id}")
//    void deleteServer(@PathVariable String id) {
//        serverService.deleteServer(id);
//    }
//
//    @PutMapping("/server/update/{id}")
//    ResponseEntity<Server> updateServer(@PathVariable("id") String id, @RequestBody Server server) {
//        Optional<Server> serverData = serverRepository.findById(id);
//        if(serverData.isPresent()) {
//            Server _server = serverData.get();
//            _server.setServerName(server.getServerName());
//            _server.setUsers(server.getUsers());
//            return new ResponseEntity<>(serverRepository.save(_server), HttpStatus.OK);
//
//        } else {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//    }
//
//    @GetMapping("/server/sort")
//    ArrayList<Document> sortServer () {
//        return serverService.getAllServersSorted();
//    }
//}
