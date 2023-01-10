package DestinyBack;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class EquippedInventory {
    @Id
    @GeneratedValue
    private int id;


    public EquippedInventory() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
