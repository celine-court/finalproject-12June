package com.ironhack.lastProject2025.service;

import com.ironhack.lastProject2025.model.Member;
import com.ironhack.lastProject2025.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;


    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    public List<Member> getAllMembers(Member member) {
        return memberRepository.findAll();
    }

       public Member createMember(Member member) {
        return memberRepository.save(member);
    }


    public void deleteMember(Integer id) {
        memberRepository.deleteById(String.valueOf(id));
    }
}
