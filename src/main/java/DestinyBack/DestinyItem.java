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

    private String itemInstanceId;

    private int quantity;

    private int bindStatus;

    private int location;

    private long bucketHash;

    private int transferStatus;

    private boolean lockable;

    private int state;

    private int dismantlePermission;

    private boolean isWrapper;

    private int versionNumber;


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
}
