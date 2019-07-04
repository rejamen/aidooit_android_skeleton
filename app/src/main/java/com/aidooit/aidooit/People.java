package com.aidooit.aidooit;

public class People {

    private int id;
    private String name;
    private String mobile;
    private String phone;
    private String email;
    private int photo;

    public People(int id, String name, String mobile, String phone, String email, int photo) {
        this.id = id;
        this.name = name;
        this.mobile = mobile;
        this.phone = phone;
        this.email = email;
        this.photo = photo;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getMobile() {
        return mobile;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public int getPhoto() {
        return photo;
    }
}
