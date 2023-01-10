package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinyPlaceHolder {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne
    @JsonProperty("character")
    private SecondPlaceHolder character;

    public DestinyPlaceHolder(int id, SecondPlaceHolder character) {
        this.id = id;
        this.character = character;
    }

    public DestinyPlaceHolder() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SecondPlaceHolder getCharacter() {
        return character;
    }

    public void setCharacter(SecondPlaceHolder character) {
        this.character = character;
    }
}
