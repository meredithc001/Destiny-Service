package DestinyBack;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

@RestController
public class DestinyItemController {

    @Autowired
    ItemHelper itemHelper;

    @Autowired
    ItemRepository itemRepository;


    @GetMapping("/item")
    @RequestMapping(value="/item")
    public List<DestinyItem> getItems() throws JsonProcessingException {
        return itemHelper.getItems();
    }

    @GetMapping("/item")
    @RequestMapping(value="/item", params="item_type")
    public List<DestinyItem> getItemsByItemType(@RequestParam int item_type) throws JsonProcessingException {
        return itemHelper.getItems(item_type);
    }

    @GetMapping("/item")
    @RequestMapping(value="/item", params="display_name")
    public List<DestinyItem> getItemsByDisplayName(@RequestParam String display_name) throws JsonProcessingException {
        return itemHelper.getItems(display_name);
    }

    @GetMapping("/item")
    @CrossOrigin("http://localhost:63343")
    @RequestMapping(value="/item", params = "hash")
    public DestinyItem getItem(@RequestParam long hash) throws IOException {
        return itemHelper.getItem(hash);
    }

}
