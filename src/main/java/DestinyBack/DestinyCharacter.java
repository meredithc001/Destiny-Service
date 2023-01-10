package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

import java.util.Date;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DestinyCharacter {

    @Id
    @JsonProperty("characterId")
    private String characterId;

    @JsonProperty("membershipId")
    private String membershipId;

    @JsonProperty("membershipType")
    private int memberShipType;

    @JsonProperty("dateLastPlayed")
    private Date dateLastPlayed;
    @JsonProperty("minutesPlayedThisSession")
    private String minutesPlayedThisSession;
    @JsonProperty("minutesPlayedTotal")
    private String minutesPlayedTotal;
    @JsonProperty("light")
    private int light;

    @OneToOne
    @JsonProperty("stats")
    private PlayerStat stats;
    @JsonProperty("raceHash")
    private long raceHash;
    @JsonProperty("genderHash")
    private long genderHash;
    @JsonProperty("classHash")
    private long classHash;
    @JsonProperty("raceType")
    private int raceType;
    @JsonProperty("classType")
    private int classType;
    @JsonProperty("genderType")
    private int genderType;
    @JsonProperty("emblemPath")
    private String emblemPath;
    @JsonProperty("emblemBackgroundPath")
    private String emblemBackgroundPath;
    @JsonProperty("emblemHash")
    private long emblemHash;

    @OneToOne
    @JsonProperty("levelProgression")
    private LevelProgression levelProgression;
}
