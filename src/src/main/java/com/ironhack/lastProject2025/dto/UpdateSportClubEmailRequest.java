package com.ironhack.lastProject2025.dto;

public class UpdateSportClubEmailRequest {
    private Integer id;
    private String email;

    public UpdateSportClubEmailRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
