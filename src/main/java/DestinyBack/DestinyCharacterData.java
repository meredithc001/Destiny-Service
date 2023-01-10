package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinyCharacterData {
    @Id
    @GeneratedValue
    private int id;

    @JsonProperty("data")
    @OneToOne
    private CharacterEquipmentList characterEquipmentList;

    public DestinyCharacterData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CharacterEquipmentList getCharacterEquipmentList() {
        return characterEquipmentList;
    }

    public void setCharacterEquipmentList(CharacterEquipmentList characterEquipmentList) {
        this.characterEquipmentList = characterEquipmentList;
    }
}
