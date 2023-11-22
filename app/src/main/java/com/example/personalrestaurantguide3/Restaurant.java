package com.example.personalrestaurantguide3;

import java.io.Serializable;

public class Restaurant implements Serializable {
    private String name;
    private String cuisineType;
    private float rating;
    private String pictureUri; // You can use URI as a String for simplicity
    private String location;
    private String contactNumber;
    private String email;
    private String description;
    private String priceRange;
    private String operatingHours;

    // Constructor
    public Restaurant(String name, String cuisineType, float rating, String pictureUri,
                      String location, String contactNumber, String email,
                      String description, String priceRange, String operatingHours) {
        this.name = name;
        this.cuisineType = cuisineType;
        this.rating = rating;
        this.pictureUri = pictureUri;
        this.location = location;
        this.contactNumber = contactNumber;
        this.email = email;
        this.description = description;
        this.priceRange = priceRange;
        this.operatingHours = operatingHours;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisineType() {
        return cuisineType;
    }

    public float getRating() {
        return rating;
    }

    public String getPictureUri() {
        return pictureUri;
    }

    public String getLocation() {
        return location;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public String getPriceRange() {
        return priceRange;
    }

    public String getOperatingHours() {
        return operatingHours;
    }

    public void setCuisineType(String cuisineType) {
        this.cuisineType = cuisineType;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public void setPictureUri(String pictureUri) {
        this.pictureUri = pictureUri;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPriceRange(String priceRange) {
        this.priceRange = priceRange;
    }

    public void setOperatingHours(String operatingHours) {
        this.operatingHours = operatingHours;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "name='" + name + '\'' +
                ", cuisineType='" + cuisineType + '\'' +
                ", rating=" + rating +
                ", pictureUri='" + pictureUri + '\'' +
                ", location='" + location + '\'' +
                ", contactNumber='" + contactNumber + '\'' +
                ", email='" + email + '\'' +
                ", description='" + description + '\'' +
                ", priceRange='" + priceRange + '\'' +
                ", operatingHours='" + operatingHours + '\'' +
                '}';
    }
}
