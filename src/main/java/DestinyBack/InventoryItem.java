package DestinyBack;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryItem {
    @Id
    @JsonProperty("itemHash")
    private long itemHash;

    @JsonProperty("itemInstanceId")
    private String itemInstanceId;

    @JsonProperty("quantity")
    private int quantity;

    @JsonProperty("bindStatus")
    private int bindStatus;

    @JsonProperty("location")
    private int location;

    @JsonProperty("bucketHash")
    private long bucketHash;

    @JsonProperty("transferStatus")
    private int transferStatus;

    @JsonProperty("lockable")
    private boolean lockable;

    @JsonProperty("state")
    private int state;

    @JsonProperty("dismantlePermission")
    private int dismantlePermission;

    @JsonProperty("isWrapper")
    private boolean isWrapper;

    @JsonProperty("versionNumber")
    private int versionNumber;

    @OneToOne
    private DisplayProperties displayProperties;

    public InventoryItem() {
    }

    public long getItemHash() {
        return itemHash;
    }

    public void setItemHash(long itemHash) {
        this.itemHash = itemHash;
    }

    public String getItemInstanceId() {
        return itemInstanceId;
    }

    public void setItemInstanceId(String itemInstanceId) {
        this.itemInstanceId = itemInstanceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getBindStatus() {
        return bindStatus;
    }

    public void setBindStatus(int bindStatus) {
        this.bindStatus = bindStatus;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }

    public long getBucketHash() {
        return bucketHash;
    }

    public void setBucketHash(long bucketHash) {
        this.bucketHash = bucketHash;
    }

    public int getTransferStatus() {
        return transferStatus;
    }

    public void setTransferStatus(int transferStatus) {
        this.transferStatus = transferStatus;
    }

    public boolean isLockable() {
        return lockable;
    }

    public void setLockable(boolean lockable) {
        this.lockable = lockable;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public int getDismantlePermission() {
        return dismantlePermission;
    }

    public void setDismantlePermission(int dismantlePermission) {
        this.dismantlePermission = dismantlePermission;
    }

    public boolean isWrapper() {
        return isWrapper;
    }

    public void setWrapper(boolean wrapper) {
        isWrapper = wrapper;
    }

    public int getVersionNumber() {
        return versionNumber;
    }

    public void setVersionNumber(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public DisplayProperties getDisplayProperties() {
        return displayProperties;
    }

    public void setDisplayProperties(DisplayProperties displayProperties) {
        this.displayProperties = displayProperties;
    }
}
