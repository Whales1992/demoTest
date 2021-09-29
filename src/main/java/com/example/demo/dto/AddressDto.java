package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.ToString;

@ToString
public class AddressDto {
    private String street;

    private String suite;

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @JsonIgnore
    public String getSuite() {
        return suite;
    }

    public void setSuite(String suite) {
        this.suite = suite;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    @JsonIgnore
    public Geo getGeo() {
        return geo;
    }

    public void setGeo(Geo geo) {
        this.geo = geo;
    }

    private String city;
    private String zipcode;

    private Geo geo;

}

