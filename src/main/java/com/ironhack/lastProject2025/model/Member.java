package com.ironhack.lastProject2025.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.ironhack.lastProject2025.model.Membership;
import com.ironhack.lastProject2025.model.enums.SportType;
import com.ironhack.lastProject2025.model.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;



import java.util.List;

@Entity
@Table(name = "Members")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String firstName;
    private String lastName;

    @Email
    @NotBlank
    private String email;

   @Enumerated(EnumType.STRING)
    private Status status;


    @ElementCollection(targetClass = SportType.class)
    @Enumerated(EnumType.STRING)
    @CollectionTable(name = "member_sporttype", joinColumns = @JoinColumn(name = "member_id"))
    @Column(name = "sporttype")
    private Set<SportType> sportTypes = new HashSet<>();

    @OneToMany(mappedBy = "member", cascade = CascadeType.ALL)
    private Set<Membership> memberships = new HashSet<>();

    public Member() {}

    public Member(String firstName, String lastName, String email, Status status, Set<SportType> sportTypes, Set<Membership> memberships) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.status = status;
        this.sportTypes = sportTypes;
        this.memberships = memberships;
           }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Set<SportType> getSportTypes() {
        return sportTypes;
    }

    public void setSportTypes(Set<SportType> sportTypes) {
        this.sportTypes = sportTypes;
    }

    public Set<Membership> getMemberships() {
        return memberships;
    }

    public void setMemberships(Set<Membership> memberships) {
        this.memberships = memberships;
    }


}
