package DestinyBack;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class PlayerStat {
    @Id
    @GeneratedValue
    private int id;
    @JsonProperty("1935470627")
    private int stat1;
    @JsonProperty("2996146975")
    private int stat2;
    @JsonProperty("392767087")
    private int stat3;
    @JsonProperty("1943323491")
    private int stat4;
    @JsonProperty("1735777505")
    private int stat5;

    @JsonProperty("144602215")
    private int stat6;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStat1() {
        return stat1;
    }

    public void setStat1(int stat1) {
        this.stat1 = stat1;
    }

    public int getStat2() {
        return stat2;
    }

    public void setStat2(int stat2) {
        this.stat2 = stat2;
    }

    public int getStat3() {
        return stat3;
    }

    public void setStat3(int stat3) {
        this.stat3 = stat3;
    }

    public int getStat4() {
        return stat4;
    }

    public void setStat4(int stat4) {
        this.stat4 = stat4;
    }

    public int getStat5() {
        return stat5;
    }

    public void setStat5(int stat5) {
        this.stat5 = stat5;
    }

    public int getStat6() {
        return stat6;
    }

    public void setStat6(int stat6) {
        this.stat6 = stat6;
    }

    public int getStat7() {
        return stat7;
    }

    public void setStat7(int stat7) {
        this.stat7 = stat7;
    }

    @JsonProperty("4244567218")
    private int stat7;
}
