package mongo.discord.mongodiscord.models;

import com.github.javafaker.Faker;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@Component
public class ServerFactory {
    private static AtomicInteger nextId = new AtomicInteger(1);
    private final Faker faker = new Faker();

    private final MongoTemplate mongoTemplate;

    public ServerFactory(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public String serverName() {
        return faker.gameOfThrones().house() + " Discord Сервер";
    }

    public String usersNickname() {
        return faker.pokemon().name() + "#" + faker.number().numberBetween(1000, 9999);
    }

    public String attributeNickname() {
        String login = faker.name().username();
        String password = faker.regexify("[A-Za-z0-9]{8}");
        return login + " " + password;
    }

    // Создание объектов типа Server
    public Server make(UUID uuid, UnaryOperator<Server>... server) {
        final Server result = new Server(serverName(), new ArrayList<>());
        Stream.of(server).forEach(v -> v.apply(result));
        return result;
    }

    // Обновление id
    public static UnaryOperator<Server> oneUpId = s -> {
        s.setId(ObjectId.get().toString()); // Создать новый ObjectId
        return s;
    };

    public ServerListDTOFactory listBuilder() {
        return new ServerListDTOFactory();
    }

    public class ServerListDTOFactory {
        public List<Server> server(int min, int max, UnaryOperator<Server>... server) {
            List<Server> serverList = IntStream.range(0, faker.number().numberBetween(min, max))
                    .mapToObj(i -> {
                        ObjectId id = new ObjectId();
                        Server serverObj = ServerFactory.this.make(UUID.randomUUID(), server);

                        List<Users> usersList = new ArrayList<>();
                        // Создание пользователя
                        Users users = new Users(usersNickname(), new ArrayList<>());
                        //users.setId(new ObjectId().toHexString());

                        // Создание атрибута
                        Attribute attribute1 = new Attribute(attributeNickname());
                        attribute1.setId(ObjectId.get().toString());

                        // Добавление атрибута к пользователю
                        //users.addAttribute(attribute1);

                        usersList.add(users);
                        // Добавление пользователя к серверу
                        serverObj.setUsers(usersList);

                        return serverObj;
                    })
                    .collect(Collectors.toList());

            // Сохраняем объекты Server в базу данных
            mongoTemplate.insertAll(serverList);

            return serverList;
        }
    }
}










//package mongo.discord.mongodiscord.models;
//
//import com.github.javafaker.Faker;
//import org.bson.types.ObjectId;
//import org.springframework.data.mongodb.core.MongoTemplate;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.UUID;
//import java.util.concurrent.atomic.AtomicInteger;
//import java.util.function.UnaryOperator;
//import java.util.stream.Collectors;
//import java.util.stream.IntStream;
//import java.util.stream.Stream;
//
//@Component
//public class ServerFactory {
//    private static AtomicInteger nextId = new AtomicInteger(1);
//    private final Faker faker = new Faker();
//
//    private final MongoTemplate mongoTemplate;
//
//    public ServerFactory(MongoTemplate mongoTemplate) {
//        this.mongoTemplate = mongoTemplate;
//    }
//
//    public String serverName() {
//        return faker.gameOfThrones().house() + " Discord Сервер";
//    }
//
//    public String usersNickname() {
//        return faker.pokemon().name() + "#" + faker.number().numberBetween(1000, 9999);
//    }
//
//    public String attributeNickname() {
//        String login = faker.name().username();
//        String password = faker.regexify("[A-Za-z0-9]{8}");
//        return login + " " + password;
//    }
//
//    // Создание объектов типа Server
//    public Server make(UUID uuid, UnaryOperator<Server>... server) {
//        final Server result = new Server(serverName(), new ArrayList<>());
//        Stream.of(server).forEach(v -> v.apply(result));
//        return result;
//    }
//
//    // Обновление id
//    public static UnaryOperator<Server> oneUpId = s -> {
//        s.setId(ObjectId.get().toString()); // Создать новый ObjectId
//        return s;
//    };
//
//    public ServerListDTOFactory listBuilder() {
//        return new ServerListDTOFactory();
//    }
//
//    public class ServerListDTOFactory {
//        public List<Server> server(int min, int max, UnaryOperator<Server>... server) {
//            List<Server> serverList = IntStream.range(0, faker.number().numberBetween(min, max))
//                    .mapToObj(i -> {
//                        ObjectId id = new ObjectId();
//                        Server serverObj = ServerFactory.this.make(UUID.randomUUID(), server);
//
//                        List<Users> usersList = new ArrayList<>();
//                        // Создание пользователя
//                        Users users = new Users(usersNickname(), new ArrayList<>());
//                        users.setId(new ObjectId().toHexString());;
//
//                        // Создание атрибута
//                        Attribute attribute1 = new Attribute(attributeNickname());
//                        attribute1.setId(ObjectId.get().toString());
//                       // Attribute attribute2 = new Attribute(attributeNickname());
//
//                        // Добавление атрибута к пользователю
//                        users.addAttribute(attribute1);
//                        //users.addAttribute(attribute2);
//
//                        usersList.add(users);
//                        // Добавление пользователя к серверу
////                        serverObj.addUsers(users);
//                        serverObj.setUsers(usersList);
////                        serverObj.setUser(users);
//
//                        return serverObj;
//                    })
//                    .collect(Collectors.toList());
//
//            // Сохраняем объекты Server в базу данных
//            mongoTemplate.insertAll(serverList);
//
//            return serverList;
//        }
//
//    }
//
//}
