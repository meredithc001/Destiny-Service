package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinyCharacterResponse {
    @Id
    @GeneratedValue
    private int id;

    @JsonProperty("Response")
    @OneToOne
    private DestinyPlaceHolder response;

    public DestinyCharacterResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DestinyPlaceHolder getResponse() {
        return response;
    }

    public void setResponse(DestinyPlaceHolder response) {
        this.response = response;
    }
}
