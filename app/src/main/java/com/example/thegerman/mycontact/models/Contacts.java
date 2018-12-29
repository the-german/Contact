package com.example.thegerman.mycontact.models;

public class Contacts {
    private String name;
    private String phoneNumber;
    private String email;
    private String device;
    private String adress;
    private String profileImage; //fille//documents/images/img.jpg

    public Contacts(String name, String phoneNumber, String email, String device, String adress, String profileImage) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.device = device;
        this.adress = adress;
        this.profileImage = profileImage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    @Override
    public String toString() {
        return "Contacts{" +
                "name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                ", device='" + device + '\'' +
                ", adress='" + adress + '\'' +
                ", profileImage='" + profileImage + '\'' +
                '}';
    }
}
