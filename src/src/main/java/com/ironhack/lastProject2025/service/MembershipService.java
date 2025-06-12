package com.ironhack.lastProject2025.service;

import com.ironhack.lastProject2025.model.Member;
import com.ironhack.lastProject2025.model.Membership;
import com.ironhack.lastProject2025.model.SportClub;
import com.ironhack.lastProject2025.model.enums.Status;
import com.ironhack.lastProject2025.repository.MembershipRepository;
import com.ironhack.lastProject2025.repository.MemberRepository;
import com.ironhack.lastProject2025.service.MemberService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MembershipService {

    private final MembershipRepository membershipRepository;

    public MembershipService(MembershipRepository membershipRepository) {
        this.membershipRepository = membershipRepository;
    }



    //    @Transactional
    public List<Membership> getAllMemberships() {
        List<Membership> membershipsList = membershipRepository.findAll();
        System.out.println("Print debug");
        for (Membership membership : membershipsList) {
            Member member = membership.getMember(); // Correctly retrieve the single member
            if (member != null) { // Check if the member is not null
                System.out.println(member.getFirstName());
                System.out.println(member.getLastName());
            }
        }
        System.out.println(membershipsList);
        return membershipsList;
    }


    public Membership findMembershipById(Integer id) {
        return membershipRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new IllegalArgumentException("Membership not found"));
    }

    public Membership createMembership(Membership membership) {
        return membershipRepository.save(membership);
    }

    public Membership updateMembership(Integer id, Membership membershipDetails) {
        return membershipRepository.findById(String.valueOf(id))
                .map(membership -> {
                    membership.setMember(membershipDetails.getMember());
                    membership.setSportClub(membershipDetails.getSportClub());
                    membership.setRating(membershipDetails.getRating());
                    return membershipRepository.save(membership);
                })
                .orElseThrow(() -> new IllegalArgumentException("Membership not found"));
    }

    public void deleteMembership(Integer id) {
        membershipRepository.deleteById(id);
    }
}

