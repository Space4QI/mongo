package mongo.discord.mongodiscord;

import mongo.discord.mongodiscord.models.Server;

import mongo.discord.mongodiscord.models.ServerFactory;
import mongo.discord.mongodiscord.repos.ServerRepository;
import mongo.discord.mongodiscord.services.ServerService;

import mongo.discord.mongodiscord.services.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@SpringBootApplication
@EnableMongoRepositories(basePackageClasses = {ServerRepository.class}, repositoryImplementationPostfix = "Impl")
public class MongoDiscordApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(MongoDiscordApplication.class);
        app.setDefaultProperties(Collections.singletonMap("spring.profiles.default", "mongodb"));
        app.run(args);
    }

    @Component
    public class Init implements CommandLineRunner {
        private final ServerService serverService;

        private final ServerFactory serverFactory;

        private final ServerRepository serverRepository;

        private final UsersService usersService;

        @Autowired
        public Init(ServerService serverService, ServerFactory serverFactory, ServerRepository serverRepository, UsersService usersService) {
            this.serverService = serverService;
            this.serverFactory = serverFactory;
            this.serverRepository = serverRepository;
            this.usersService = usersService;
        }

        @Override
        public void run(String... args) throws Exception {
            List<Server> server = serverFactory.listBuilder().server(100, 100);
            //serverService.saveAllServer(server);
//            System.out.println(usersServiceimpl.getAllUsers());
//            serverRepository.findByServerName("server")
//                    .ifPresentOrElse(c -> {
//                        System.out.println(c + "already exists");
//                    }, () -> {
//                        System.out.println("not found");
//                    });
//            System.out.println(serverRepository.getAllServerSorted());
        }
    }

    @Component
    public class CustomCode implements CommandLineRunner {
        private final ServerService serverService;
        private final MongoTemplate mongoTemplate;

        @Autowired
        public CustomCode(ServerService serverService, MongoTemplate mongoTemplate) {
            this.serverService = serverService;
            this.mongoTemplate = mongoTemplate;
        }

        @Override
        public void run(String... args) throws Exception {
            // Получение коллекции "server"
//            MongoCollection<Document> serverCollection = mongoTemplate.getCollection("server");
//
//            List<Server> storedServer = serverService.getAllServer();
//            for (Server b:storedServer) {
//                System.out.println(b);
//            }
//
//            List<Bson> pipeline = Arrays.asList(
//                    Aggregates.sort(Sorts.orderBy(
//                            Sorts.ascending("serverName"),
//                            Sorts.descending("usersNickname"),
//                            Sorts.ascending("attributeNickname")
//                    ))
//            );
//
//            List<Document> results = serverCollection.aggregate(pipeline).into(new ArrayList<>());
//
//            for (Document document : results) {
//                System.out.println(document + "\n");
//            }
        }
    }
}
