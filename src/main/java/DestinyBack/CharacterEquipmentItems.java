package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterEquipmentItems {
    @Id
    @GeneratedValue
    private int id;

    @JsonProperty("items")
    @OneToOne
    private InventoryItem[] equippedInventoryList;

    public CharacterEquipmentItems() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public InventoryItem[] getEquippedInventoryList() {
        return equippedInventoryList;
    }

    public void setEquippedInventoryList(InventoryItem[] equippedInventoryList) {
        this.equippedInventoryList = equippedInventoryList;
    }
}
