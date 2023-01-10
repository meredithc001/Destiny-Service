package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class SecondPlaceHolder {
    @Id
    @GeneratedValue
    private int id;

    @JsonProperty("data")
    @OneToOne
    private DestinyCharacter data;

    public SecondPlaceHolder() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public DestinyCharacter getData() {
        return data;
    }

    public void setData(DestinyCharacter data) {
        this.data = data;
    }
}
