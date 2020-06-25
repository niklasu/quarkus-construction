package com.example.persistence;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotEmpty;

@Embeddable
public class BuildingAddress {
    @NotEmpty
    @Column(name = "street_and_number",length = 40, nullable = false)
    private String streetAndNumber;
    @NotEmpty
    @Column(length = 10, nullable = false)
    private String zip;
    @NotEmpty
    @Column(length = 30, nullable = false)
    private String city;

    public BuildingAddress() {

    }

    public BuildingAddress(String city, String streetAndNumber, String zip) {
        this.streetAndNumber = streetAndNumber;
        this.zip = zip;
        this.city = city;
    }

    public String getStreetAndNumber() {
        return streetAndNumber;
    }

    public void setStreetAndNumber(String streetAndNumber) {
        this.streetAndNumber = streetAndNumber;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "BuildingAddress{" +
                "StreetAndNumber='" + streetAndNumber + '\'' +
                ", zip='" + zip + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
