package com.ironhack.lastProject2025.dto;

public class UpdateSportClubPresidentRequest {
    private Integer id;
    private String president;

    public UpdateSportClubPresidentRequest() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }
}
