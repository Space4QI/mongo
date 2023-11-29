package mongo.discord.mongodiscord.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "users")
public class Users extends BaseEntity {

    private String usersNickname;

    private List<Attribute> attributes;

    public String getUsersNickname() {
        return usersNickname;
    }

    public void setUsersNickname(String usersNickname) {
        this.usersNickname = usersNickname;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }



    //    private String usersNickname;
//
//    private List<Attribute> attributes;
//
//
//    public Users(String usersNickname, List<Attribute> attributes) {
//        this.usersNickname = usersNickname;
//        this.attributes = attributes;
//    }
//
//    public Users(){
//
//    }
//
//    public String getUsersNickname() {
//        return usersNickname;
//    }
//
//    public void setUsersNickname(String usersNickname) {
//        this.usersNickname = usersNickname;
//    }
//
//    public List<Attribute> getAttributes() {
//        return attributes;
//    }
//
//    public void setAttributes(List<Attribute> attributes) {
//        this.attributes = attributes;
//    }
//
//    public void addAttribute(Attribute attribute) {
//        if (attributes == null) {
//            attributes = new ArrayList<>();
//        }
//        attributes.add(attribute);
//    }
//
//    @Override
//    public String toString() {
//        return "Users{" +
//                "usersNickname='" + usersNickname + '\'' +
//                ", attributes=" + attributes +
//                '}';
//    }

}
