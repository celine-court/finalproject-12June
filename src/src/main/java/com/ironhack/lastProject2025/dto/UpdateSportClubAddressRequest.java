package com.ironhack.lastProject2025.dto;

public class UpdateSportClubAddressRequest {
    private Integer id;
    private String address;

    public UpdateSportClubAddressRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
