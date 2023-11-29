package mongo.discord.mongodiscord.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

@Document(collection = "servers") // класс будет отображаться в коллекцию discord в mongoDB
public class Server extends BaseEntity {

    private String serverName;

    private List<Users> users;



    //название сервера serverName
    // unique = false - значения в индексе не будут уникальными
    // sparse = true - индекс не будет создан для документа, если поле serverName не существует в нем
    //direction = IndexDirection.ASCENDING - индексируем поле по возрастанию
    // background = false - блокируем операции записи в коллекцию во время создания индекса, чтобы не повредить данные
//    @Indexed(unique = false, sparse = true, direction = IndexDirection.ASCENDING, background = false)
//    private String serverName;
//
//    //никнейм пользователя usersNickname
//
//    private List<Users> users;
//    //private String usersNickname;
//
//    //имя атрибута для у пользователя
//    //private String attributeNickname;
//
//    public Server(){
//
//    }
//
//    public Server(String serverName, List<Users> users) {
//        this.serverName = serverName;
//        this.users = users;
//        //this.usersNickname = usersNickname;
//    }
//
//    public String getServerName() {
//        return serverName;
//    }
//
//    public void setServerName(String serverName) {
//        this.serverName = serverName;
//    }
//
//    public List<Users> getUsers() {
//        return users;
//    }
//
//    public void setUsers(List<Users> users) {
//        this.users = users;
//    }
//
//    public void setUser(Users users) {
//        this.users.add(users);
//    }
//
//    public void addUsers(Users user) {
//        if (users == null) {
//            users = new ArrayList<>();
//        }
//        users.add(user);
//    }
//
//
//    @Override
//    public String toString() {
//        return "Discord{" +
////                "id='" + id + '\'' +
//                ", server name='" + serverName + '\'' +
//                ", users='" + users + '\'' +
//                '}';
//    }
}
