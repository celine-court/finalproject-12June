package com.ironhack.lastProject2025.repository;

import com.ironhack.lastProject2025.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, String>{
}
