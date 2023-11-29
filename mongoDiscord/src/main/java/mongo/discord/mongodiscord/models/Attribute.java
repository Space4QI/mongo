package mongo.discord.mongodiscord.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Document(collection = "attributes")
public class Attribute extends BaseEntity {

    private String attributeNickname;

//    public Attribute() {}
//
//    public Attribute(String attributeNickname) {
//        this.attributeNickname = attributeNickname;
//    }
//
//    public String getAttributeNickname() {
//        return attributeNickname;
//    }
//
//    public void setAttributeNickname(String attributeNickname) {
//        this.attributeNickname = attributeNickname;
//    }
//
//    @Override
//    public String toString() {
//        return "Attribute{" +
//                "attributeNickname='" + attributeNickname + '\'' +
//                '}';
//    }
}
