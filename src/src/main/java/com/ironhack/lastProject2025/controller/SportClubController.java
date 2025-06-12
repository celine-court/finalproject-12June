package com.ironhack.lastProject2025.controller;


import com.ironhack.lastProject2025.dto.UpdateSportClubAddressRequest;
import com.ironhack.lastProject2025.dto.UpdateSportClubEmailRequest;
import com.ironhack.lastProject2025.dto.UpdateSportClubPresidentRequest;
import com.ironhack.lastProject2025.model.SportClub;
import com.ironhack.lastProject2025.model.enums.SportType;
import com.ironhack.lastProject2025.repository.SportClubRepository;
import com.ironhack.lastProject2025.service.SportClubService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.security.access.prepost.PreAuthorize;

import java.util.List;

@RestController
@RequestMapping("api/clubs")
public class SportClubController {

    private final SportClubService sportClubService;

    public SportClubController(SportClubService sportClubService, SportClubRepository sportClubRepository) {
        this.sportClubService = sportClubService;
    }


    @GetMapping
    public List<SportClub> getAllSportClubs() {
        return sportClubService.getAllSportClubs();
    }

    @GetMapping("/{sportType}")
    public SportClub findClubBySportType(@PathVariable SportType sportType) {
        return sportClubService.findSportClubBySportType(sportType);
    }

    @PreAuthorize("hasRole('USERMEMBER')")
    @PostMapping("/{clubName}/reviews")
    @ResponseStatus(HttpStatus.CREATED)
    public SportClub addReview(@PathVariable String clubName, @RequestParam @Min(0) @Max(10) int review) {
        return sportClubService.addReviewToClub(clubName, review);
    }

    @PreAuthorize("hasAnyRole('APPADMIN','CLUBADMIN')")
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SportClub createSportClub(@RequestBody @Valid SportClub sportClub) {
        return sportClubService.createSportClub(sportClub);
    }


    @PreAuthorize("hasAnyRole('APPADMIN','CLUBADMIN')")
    @PutMapping("/{id}")
    public SportClub updateSportClub(@PathVariable Long id, @RequestBody SportClub sportClub) {
        return sportClubService.update(id, sportClub);
    }

    @PreAuthorize("hasAnyRole('APPADMIN','CLUBADMIN')")
    @PatchMapping("/president")
    public SportClub updateSportClubPresident(@RequestBody UpdateSportClubPresidentRequest request){
        return sportClubService.updateSportClubPresident(request.getId(), request.getPresident());
    }

    @PreAuthorize("hasAnyRole('APPADMIN','CLUBADMIN')")
    @PatchMapping("/clubemail")
    public SportClub updateSportClubEmail(@RequestBody UpdateSportClubEmailRequest request){
        return sportClubService.updateSportClubEmail(request.getId(), request.getEmail());
    }

    @PreAuthorize("hasAnyRole('APPADMIN','CLUBADMIN')")
    @PatchMapping("/clubaddress")
    public SportClub updateSportClubAddress(@RequestBody UpdateSportClubAddressRequest request){
        return sportClubService.updateSportClubAddress(request.getId(), request.getAddress());
    }

    @PreAuthorize("hasAnyRole('APPADMIN','CLUBADMIN')")
    @DeleteMapping("/{clubid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteSportClub(@PathVariable Integer id) {
        sportClubService.delete(id);
    }

}
