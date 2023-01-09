package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class DisplayProperties {

    @Id
    private String icon;

    private String name;

    private boolean hasIcon;

    private String description;

    public DisplayProperties(String icon, String name, boolean hasIcon, String description) {
        this.icon = icon;
        this.name = name;
        this.hasIcon = hasIcon;
        this.description = description;
    }

    public DisplayProperties() {

    }


    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isHasIcon() {
        return hasIcon;
    }

    public void setHasIcon(boolean hasIcon) {
        this.hasIcon = hasIcon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
