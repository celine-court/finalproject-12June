package com.ironhack.lastProject2025.model;

import com.ironhack.lastProject2025.model.enums.SportType;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.OneToMany;

@Entity
@Table(name = "SportClub")
public class SportClub {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String clubName;
    private String president;
    private String address;

    @Min(value = 0, message = "Rating must be greater than or equal to 0")
    @Max(value = 10, message = "Rating must be less than or equal to 10")
    private Integer rating;

    @Email
    @NotBlank
    private String email;

    @Enumerated(EnumType.STRING)
    private SportType sportType;  // Each SportClub has only one SportType

    @OneToMany(mappedBy = "sportClub", cascade = CascadeType.ALL)
    private Set<Membership> memberships = new HashSet<>();

    public SportClub() {}

    public SportClub(String clubName, String president, String address, Integer rating, String email, SportType sportType, Set<Membership> memberships) {
        this.clubName = clubName;
        this.president = president;
        this.address = address;
        this.rating = rating;
        this.email = email;
        this.sportType = sportType;
        this.memberships = memberships;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getClubName() {
        return clubName;
    }

    public void setClubName(String name) {
        this.clubName = name;
    }

    public String getPresident() {
        return president;
    }

    public void setPresident(String president) {
        this.president = president;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public Set<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(Set<Membership> memberships) {
        this.memberships = memberships;
    }
}
