package DestinyBack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;


import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;


@Component()
public class ItemHelper {
    @Autowired
    ItemRepository itemRepository;

    ObjectMapper mapper = new ObjectMapper();


    public DestinyItem getItem(long hash) throws JsonProcessingException {
        String jsonString = itemRepository.findDestinyItemByHash(hash).get("data").toString();
        return mapper.readValue(jsonString, DestinyItem.class);
    }

    public List<DestinyItem> getItems(int item_type) throws JsonProcessingException {
        return getListItems(itemRepository.findAllByItemType(item_type));
    }

    public List<DestinyItem> getItems(String display_name) throws JsonProcessingException {
        return getListItems(itemRepository.findAllByDisplayName(display_name));
    }

    public List<DestinyItem> getItems() throws JsonProcessingException {
        return getListItems(itemRepository.findAllDestinyItems());
    }

    private List<DestinyItem> getListItems(List<JSONObject> jsonObjects) throws JsonProcessingException {
        List<DestinyItem> items = new LinkedList<>();
        for(JSONObject entity: jsonObjects) {
            String jsonString = entity.get("data").toString();
            items.add(mapper.readValue(jsonString, DestinyItem.class));
        }
        return items;
    }

}
