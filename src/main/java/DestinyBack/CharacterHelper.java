package DestinyBack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;

@Component
public class CharacterHelper {

    @Value("${bungie.url}")
    private String bungie_url;

    @Value("${bungie.auth}")
    private String auth;

    @Autowired
    private ItemHelper itemHelper;

    RestTemplate restTemplate = new RestTemplate();

    ObjectMapper mapper = new ObjectMapper();

    public DestinyCharacter getCharacter(int membershipType, String membership_id, String character_id) throws URISyntaxException, JsonProcessingException {
        URI uri = new URI(bungie_url + membershipType + "/"  + "Profile" + "/" +  membership_id + "/Character/" + character_id + "/?components=200");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", auth);
        JSONObject obj = restTemplate.getForObject(uri, JSONObject.class);
        return mapper.readValue(obj.toJSONString(), DestinyCharacterResponse.class).getResponse().getCharacter().getData();
    }


    public DestinyCharacterEquipmentWrapper getCharacterEquipment(int memberShipType, String memberShipId) throws URISyntaxException, JsonProcessingException {
        URI uri = new URI(bungie_url + memberShipType + "/"  + "Profile" + "/" +  memberShipId + "/?components=205");
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", auth);
        return mapper.readValue(restTemplate.getForObject(uri, JSONObject.class).toJSONString(), DestinyCharacterEquipmentWrapper.class);
    }

    public InventoryItem[] getCharacterEquipment(int memberShipType, String memberShipId, String character_id) throws URISyntaxException, JsonProcessingException {
        CharacterEquipmentList data =getCharacterEquipment(memberShipType, memberShipId).getCharacterEquipmentResponse().getCharacterEquipment().getCharacterEquipmentList();
        if (character_id.equals("2305843009270276511")) {
            return getDisplayProperties(data.getCharacter_1().getEquippedInventoryList());
        } else if (character_id.equals("2305843009270276512")) {
            return getDisplayProperties(data.getCharacter_2().getEquippedInventoryList());
        } else {
            return getDisplayProperties(data.getCharacter_3().getEquippedInventoryList());
        }
    }

    private InventoryItem[] getDisplayProperties(InventoryItem[] items) throws JsonProcessingException {
        for(int i = 0; i < items.length; ++i) {
            DestinyItem item = itemHelper.getItem(items[i].getItemHash());
            items[i].setDisplayProperties(item.getDisplayProperties());
        }
        return items;
    }
}
