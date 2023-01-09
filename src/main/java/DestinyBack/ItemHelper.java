package DestinyBack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    RestTemplate restTemplate = new RestTemplate();

    @Value("${bungie.url}")
    private String bungie_url;

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

    public JSONObject getCharacterEquipment(int characterType, String membership_id) throws URISyntaxException {
        URI uri = new URI(bungie_url + characterType + "/"  + "Profile" + "/" +  membership_id + "/?components=205");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "Basic NDI1NzI6U09Nd2NzckV0LjFQNkdFWEJJVFVtZTA5YUV0dGFXRFd3SU9ZQVlqVC12NA==");
        return restTemplate.getForObject(uri, JSONObject.class);
    }
}
