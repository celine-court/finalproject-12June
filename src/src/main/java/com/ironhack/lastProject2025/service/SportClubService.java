package com.ironhack.lastProject2025.service;

import com.ironhack.lastProject2025.exception.ResourceNotFoundException;
import com.ironhack.lastProject2025.model.SportClub;
import com.ironhack.lastProject2025.model.enums.SportType;
import com.ironhack.lastProject2025.repository.SportClubRepository;
import com.ironhack.lastProject2025.repository.MembershipRepository;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportClubService {

    private final SportClubRepository sportClubRepository;

    public SportClubService(SportClubRepository sportClubRepository, MembershipRepository membershipRepository) {
        this.sportClubRepository = sportClubRepository;
            }

    public SportClub createSportClub(SportClub sportClub) {
        return sportClubRepository.save(sportClub);
    }

    public List<SportClub> findAll() {
        return sportClubRepository.findAll();
    }

    public SportClub findSportClubBySportType(SportType sportType) {
        return sportClubRepository.findSportClubBySportType(sportType)
                .orElseThrow(() -> new ResourceNotFoundException("SportClub not found with SportType: " + sportType));
    }

    public List<SportClub> getAllSportClubs() {
        return sportClubRepository.findAll();
    }



    public void delete(Integer id) {
        SportClub existingClub = sportClubRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("SportClub not found with id: " + id));
        sportClubRepository.delete(existingClub);
    }

    public SportClub updateSportClubPresident(Integer id, String president) {
        SportClub existingClub = sportClubRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("SportClub not found with id: " + id));
        existingClub.setPresident(president);
        return sportClubRepository.save(existingClub);
    }

    public SportClub updateSportClubEmail(Integer id, String email) {
        SportClub existingClub = sportClubRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("SportClub not found with id: " + id));
        existingClub.setEmail(email);
        return sportClubRepository.save(existingClub);
    }

    public SportClub updateSportClubAddress(Integer id, String address) {
        SportClub existingClub = sportClubRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("SportClub not found with id: " + id));
        existingClub.setAddress(address);
        return sportClubRepository.save(existingClub);
        }

    public SportClub update(Long id, SportClub sportClubDetails) {
        SportClub existingClub = sportClubRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new ResourceNotFoundException("SportClub not found with id: " + id));

        existingClub.setClubName(sportClubDetails.getClubName());
        existingClub.setPresident(sportClubDetails.getPresident());
        existingClub.setAddress(sportClubDetails.getAddress());
        existingClub.setEmail(sportClubDetails.getEmail());
        existingClub.setSportType(sportClubDetails.getSportType());

        return sportClubRepository.save(existingClub);
    }


    public SportClub addReviewToClub(String clubName, @Min(0) @Max(10) int review) {
        SportClub club = sportClubRepository.findByClubName(clubName)
                .orElseThrow(() -> new ResourceNotFoundException("SportClub not found with name: " + clubName));

        // Logic to add the review
        if (club.getRating() != null) {
            club.setRating((club.getRating() + review) / 2); // Simple averaging logic
        } else {
            club.setRating(review); // Initial rating if none exist
        }

        return sportClubRepository.save(club);
    }
}
