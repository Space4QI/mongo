package mongo.discord.mongodiscord.controllers;

import mongo.discord.mongodiscord.models.Attribute;
import mongo.discord.mongodiscord.services.AttributeService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/attributes")
public class AttributeController {

    private final AttributeService attributeService;

    @Autowired
    public AttributeController(AttributeService attributeService) {
        this.attributeService = attributeService;
    }

    @GetMapping("/all")
    public List<Attribute> getAllAttributes() {
        return attributeService.getAllAttributes();
    }

    @GetMapping("/{id}")
    public Attribute getAttributeById(@PathVariable("id") String id) {
        return attributeService.getAttributeById(new ObjectId(id)).orElse(null);
    }

    @PostMapping("/new")
    public Attribute createRandomAttribute() {
        return attributeService.createRandomAttribute();
    }

    @DeleteMapping("/{id}")
    public void deleteAttribute(@PathVariable String id) {
        attributeService.deleteAttribute(new ObjectId(id));
    }
}


//@RestController
//public class AttributeController {
//
//    private final AttributeService attributeService;
//
//    @Autowired
//    public AttributeController(AttributeService attributeService) {
//        this.attributeService = attributeService;
//    }
//
//    @GetMapping("/attribute/all")
//    List<Attribute> getAllAttribute() {
//        return attributeService.getAllAttribute();
//    }
//
//    @GetMapping("/attribute/{id}")
//    Attribute getAttributeById(@PathVariable("id") String id) {
//        return attributeService.getAttribute(id);
//    }
//
//    @PostMapping("/attribute/new")
//    Attribute newAttribute(@RequestBody Attribute newAttribute) {
//        return attributeService.createAttribute(newAttribute);
//    }
//
//    @DeleteMapping("/attribute/{id}")
//    void deleteAttribute(@PathVariable String id) {
//        attributeService.deleteAttribute(id);
//    }
//}
