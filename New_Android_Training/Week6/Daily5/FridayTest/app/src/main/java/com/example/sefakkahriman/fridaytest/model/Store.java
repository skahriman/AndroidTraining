package com.example.sefakkahriman.fridaytest.model;

public class Store {

    private String storeId;
    private String addressDescription;
    private String  hoursDescription;

    public Store(String storeId, String addressDescription, String hoursDescription) {
        this.storeId = storeId;
        this.addressDescription = addressDescription;
        this.hoursDescription = hoursDescription;
    }

    public String getStoreId() {
        return storeId;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public String getAddressDescription() {
        return addressDescription;
    }

    public void setAddressDescription(String addressDescription) {
        this.addressDescription = addressDescription;
    }

    public String getHoursDescription() {
        return hoursDescription;
    }

    public void setHoursDescription(String hoursDescription) {
        this.hoursDescription = hoursDescription;
    }

    @Override
    public String toString() {
        return "Store{" +
                "storeId='" + storeId + '\'' +
                ", addressDescription='" + addressDescription + '\'' +
                ", hoursDescription='" + hoursDescription + '\'' +
                '}';
    }
}
