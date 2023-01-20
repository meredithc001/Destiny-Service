package DestinyBack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;


@Component()
public class ItemHelper {
    @Autowired
    ItemRepository itemRepository;

    ObjectMapper mapper = new ObjectMapper();


    public DestinyItem getItem(long hash) throws JsonProcessingException {
        return mapper.readValue(itemRepository.findDestinyItemByHash(hash), DestinyItem.class);
    }

    public DestinyItem[] getItemsbyHash(ArrayList<Long> HashList) throws JsonProcessingException {
        List<String> results = itemRepository.findDestinyItemsByHash(HashList);
        List<JSONObject> objects = new LinkedList<>();
        for(String item : results){
            objects.add(new JSONObject(item));
        }
        return mapper.readValue(objects.toString(), DestinyItem[].class);
    }

    public DestinyItem[] getItems(int item_type) throws JsonProcessingException {
        return mapper.readValue(itemRepository.findAllByItemType(item_type).toString(), DestinyItem[].class);
    }

    public DestinyItem[] getItems(String display_name) throws JsonProcessingException {
        return mapper.readValue(itemRepository.findAllByDisplayName(display_name).toString(), DestinyItem[].class);
    }

    public DestinyItem[] getItems() throws JsonProcessingException {
        return mapper.readValue(itemRepository.findAllDestinyItems().toString(), DestinyItem[].class);
    }

}
