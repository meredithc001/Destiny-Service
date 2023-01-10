package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinyCharacterEquipmentWrapper {
    @Id
    @GeneratedValue
    private int id;

    @JsonProperty("Response")
    @OneToOne
    private CharacterEquipmentResponse characterEquipmentResponse;

    public DestinyCharacterEquipmentWrapper() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CharacterEquipmentResponse getCharacterEquipmentResponse() {
        return characterEquipmentResponse;
    }

    public void setCharacterEquipmentResponse(CharacterEquipmentResponse characterEquipmentResponse) {
        this.characterEquipmentResponse = characterEquipmentResponse;
    }
}
