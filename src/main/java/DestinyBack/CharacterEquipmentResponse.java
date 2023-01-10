package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class CharacterEquipmentResponse {
    @Id
    @JsonProperty("responseMintedTimestamp")
    private Date responseMintedTimestamp;
    @JsonProperty("secondaryComponentsMintedTimestamp")
    private Date secondaryComponentsMintedTimestamp;

    @OneToOne
    @JsonProperty("characterEquipment")
    private DestinyCharacterData destinyCharacterData;

    public CharacterEquipmentResponse() {
    }

    public Date getResponseMintedTimestamp() {
        return responseMintedTimestamp;
    }

    public void setResponseMintedTimestamp(Date responseMintedTimestamp) {
        this.responseMintedTimestamp = responseMintedTimestamp;
    }

    public Date getSecondaryComponentsMintedTimestamp() {
        return secondaryComponentsMintedTimestamp;
    }

    public void setSecondaryComponentsMintedTimestamp(Date secondaryComponentsMintedTimestamp) {
        this.secondaryComponentsMintedTimestamp = secondaryComponentsMintedTimestamp;
    }

    public DestinyCharacterData getCharacterEquipment() {
        return destinyCharacterData;
    }

    public void setCharacterEquipment(DestinyCharacterData destinyCharacterData) {
        this.destinyCharacterData = destinyCharacterData;
    }
}
