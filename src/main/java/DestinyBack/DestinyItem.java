package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinyItem {

    @Id
    @GeneratedValue
    private int id;

    private long hash;

    private int itemType;

    private String itemTypeDisplayName;

    @OneToOne
    @JsonProperty("displayProperties")
    private DisplayProperties displayProperties;


    public DestinyItem() {}

    DestinyItem(long hash, int itemType, String itemTypeDisplayName){
        this.hash = hash;
        this.itemType = itemType;
        this.itemTypeDisplayName = itemTypeDisplayName;
    }

    public void setHash(long hash) {
        this.hash = hash;
    }

    public void setItemType(int itemType) {
        this.itemType = itemType;
    }

    public void setItemTypeDisplayName(String itemTypeDisplayName) {
        this.itemTypeDisplayName = itemTypeDisplayName;
    }

    public DisplayProperties getDisplayProperties() {
        return displayProperties;
    }

    public void setDisplayProperties(DisplayProperties displayProperties) {
        this.displayProperties = displayProperties;
    }

    public long getHash() {
        return hash;
    }


    public int getItemType() {
        return itemType;
    }

    public String getItemTypeDisplayName() {
        return itemTypeDisplayName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
