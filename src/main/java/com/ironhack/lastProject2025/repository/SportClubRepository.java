package com.ironhack.lastProject2025.repository;

import com.ironhack.lastProject2025.service.SportClubService;
import com.ironhack.lastProject2025.model.SportClub;
import com.ironhack.lastProject2025.model.enums.SportType;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface SportClubRepository extends JpaRepository<SportClub, String>{
    Optional<SportClub> findSportClubBySportType(SportType sportType);
    Optional<SportClub> findByClubName(String clubName);


}
