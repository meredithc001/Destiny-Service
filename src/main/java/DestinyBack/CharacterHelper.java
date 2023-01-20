package DestinyBack;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.connector.Response;
import org.json.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@Component
public class CharacterHelper {

    @Value("${bungie.url}")
    private String bungie_url;

    @Value("${bungie.auth}")
    private String auth;

    @Value("${bungie.api.key}")
    private String api_key;

    @Autowired
    private ItemHelper itemHelper;

    RestTemplate restTemplate = new RestTemplate();

    ObjectMapper mapper = new ObjectMapper();

    private JSONObject getRequest(URI uri) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", auth);
        headers.add("x-api-key", api_key);
        HttpEntity<String> httpEntity = new HttpEntity<>("", headers);
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, String.class);
        return new JSONObject(response.getBody()).getJSONObject("Response");
    }

    public DestinyCharacter getCharacter(int membershipType, String membership_id, String character_id) throws URISyntaxException, JsonProcessingException {
        URI uri = new URI(bungie_url + membershipType + "/"  + "Profile" + "/" +  membership_id + "/Character/" + character_id + "/?components=200");
        JSONObject obj = getRequest(uri);
        return mapper.readValue(obj.getJSONObject("character").getJSONObject("data").toString(), DestinyCharacter.class);
    }

    public InventoryItem[] getCharacterEquipment(int memberShipType, String memberShipId, String character_id) throws URISyntaxException, JsonProcessingException {
        URI uri = new URI(bungie_url + memberShipType + "/"  + "Profile" + "/" +  memberShipId + "/?components=205");
        JSONObject response = getRequest(uri);
        InventoryItem[] items =  mapper.readValue(response.getJSONObject("characterEquipment").getJSONObject("data").getJSONObject(character_id).getJSONArray("items").toString(), InventoryItem[].class);
        return getDisplayProperties(items);
    }

    private InventoryItem[] getDisplayProperties(InventoryItem[] items) throws JsonProcessingException {
        ArrayList<Long> hashes = new ArrayList<Long>();
        for(int i = 0; i < items.length; i++) {
            hashes.add(items[i].getItemHash());
        }
        DestinyItem[] destinyItems = itemHelper.getItemsbyHash(hashes);
        for(int i = 0; i < items.length; i++) {
            items[i].setDisplayProperties(destinyItems[i].getDisplayProperties());
        }
        return items;
    }

    public InventoryItem[] getVaultItems(int memberShipType, String memberShipId) throws URISyntaxException, IOException {
        URI uri = new URI(bungie_url + memberShipType + "/"  + "Profile" + "/" +  memberShipId + "/?components=102");
        JSONObject json = getRequest(uri);
        JSONArray itemArray = json.getJSONObject("profileInventory").getJSONObject("data").getJSONArray("items");
        return mapper.readValue(itemArray.toString(), InventoryItem[].class);
    }
}
