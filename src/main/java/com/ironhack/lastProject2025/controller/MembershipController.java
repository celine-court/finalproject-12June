package com.ironhack.lastProject2025.controller;

import com.ironhack.lastProject2025.model.Membership;
import com.ironhack.lastProject2025.service.MembershipService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("api/memberships")
public class MembershipController {

    private final MembershipService membershipService;

    public MembershipController(MembershipService membershipService) {
        this.membershipService = membershipService;
    }

    @PreAuthorize("hasAnyRole('APPADMIN')")
    @GetMapping
    public List<Membership> getAllMemberships() {
        return membershipService.getAllMemberships();
    }

    @PreAuthorize("hasAnyRole('APPADMIN','USERMEMBER', 'CLUBADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Membership createMembership(@RequestBody @Valid Membership membership) {
        return membershipService.createMembership(membership);
    }

    @PreAuthorize("hasAnyRole('APPADMIN','USERMEMBER', 'CLUBADMIN')")
    @GetMapping("/{id}")
    public Membership findMembershipById(@PathVariable Integer id) {
        return membershipService.findMembershipById(id);
    }

    @PreAuthorize("hasAnyRole('APPADMIN','USERMEMBER', 'CLUBADMIN')")
    @PutMapping("/{id}")
    public Membership updateMembership(@PathVariable Integer id, @RequestBody Membership membership) {
        return membershipService.updateMembership(id, membership);
    }


    @PreAuthorize("hasAnyRole('APPADMIN','USERMEMBER', 'CLUBADMIN')")
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMembership(@PathVariable Integer id) {
        membershipService.deleteMembership(id);
    }


}

