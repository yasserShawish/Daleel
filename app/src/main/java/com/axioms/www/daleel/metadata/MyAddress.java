package com.axioms.www.daleel.metadata;

import java.io.Serializable;

/**
 * Created by Ahmad Ababneh on 30/04/2017.
 */
public class MyAddress implements Serializable {

    private String Country;
    private String city;
    private String AddressLine;
    private String phoneNumber;
    private String email;
    private String fax;
    private double latitude;
    private double longitude;

    public String getCountry() {
        return Country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine() {
        return AddressLine;
    }

    public void setAddressLine(String addressLine) {
        AddressLine = addressLine;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    @Override
    public String toString(){
        return "Country: "+getCountry()+" City: "+getCity()+"\n"
                +"Phone: "+getPhoneNumber()+" Email: "+getEmail();
    }
}
