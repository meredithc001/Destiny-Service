package DestinyBack;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterEquipmentList {
    @Id
    @GeneratedValue
    private int id;

    @JsonProperty("2305843009270276511")
    @OneToOne
    private CharacterEquipmentItems character_1;

    @JsonProperty("2305843009270276512")
    @OneToOne
    private CharacterEquipmentItems character_2;

    @JsonProperty("2305843009314366248")
    @OneToOne
    private CharacterEquipmentItems character_3;

    public CharacterEquipmentList() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public CharacterEquipmentItems getCharacter_1() {
        return character_1;
    }

    public void setCharacter_1(CharacterEquipmentItems character_1) {
        this.character_1 = character_1;
    }

    public CharacterEquipmentItems getCharacter_2() {
        return character_2;
    }

    public void setCharacter_2(CharacterEquipmentItems character_2) {
        this.character_2 = character_2;
    }

    public CharacterEquipmentItems getCharacter_3() {
        return character_3;
    }

    public void setCharacter_3(CharacterEquipmentItems character_3) {
        this.character_3 = character_3;
    }
}
