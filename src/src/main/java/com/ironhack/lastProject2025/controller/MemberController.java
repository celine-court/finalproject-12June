package com.ironhack.lastProject2025.controller;

import com.ironhack.lastProject2025.model.Member;
import com.ironhack.lastProject2025.service.MemberService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping
    public List<Member> getAllMembers(Member member) {
        return memberService.getAllMembers(member);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Member createMember(@RequestBody @Valid Member member) {
        return memberService.createMember(member);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteMember(@PathVariable Integer id) {
        memberService.deleteMember(id);
    }



}
