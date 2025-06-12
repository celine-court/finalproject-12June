package com.ironhack.lastProject2025.repository;

import com.ironhack.lastProject2025.model.Membership;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembershipRepository extends JpaRepository<Membership, String>{
    void deleteById(Integer id);
}