package DestinyBack;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;


@RestController
public class DestinyCharacterController {

    @Autowired
    CharacterHelper characterHelper;

    @GetMapping("/character")
    @RequestMapping(value="/character", params = {"memberShipType", "memberShipId", "characterId"})
    public DestinyCharacter getCharacter(@RequestParam("memberShipType") int memberShipType, @RequestParam("memberShipId") String memberShipId, @RequestParam("characterId") String characterId) throws URISyntaxException, JsonProcessingException {
        return characterHelper.getCharacter(memberShipType, memberShipId, characterId);
    }

    @GetMapping("/character")
    @RequestMapping(value="/character", params = {"memberShipType", "memberShipId"})
    public DestinyCharacterEquipmentWrapper getCharacterEquipment(@RequestParam("memberShipType") int memberShipType, @RequestParam("memberShipId") String memberShipId) throws URISyntaxException, JsonProcessingException {
        return characterHelper.getCharacterEquipment(memberShipType, memberShipId);
    }

    @GetMapping("/character/")
    @CrossOrigin("http://localhost:63343")
    @RequestMapping(value="/character", params = {"memberShipType", "memberShipId", "character"})
    public InventoryItem[] getCharacterEquipmentItems(@RequestParam("memberShipType") int memberShipType, @RequestParam("memberShipId") String memberShipId, @RequestParam("character") String character) throws URISyntaxException, JsonProcessingException {
        return characterHelper.getCharacterEquipment(memberShipType, memberShipId, character);
    }
}
