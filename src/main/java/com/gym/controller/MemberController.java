package com.gym.controller;

import com.gym.entity.Member;
import com.gym.repository.MemberRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
@CrossOrigin(origins = "http://localhost:3000")
public class MemberController {

    private final MemberRepository repo;

    public MemberController(MemberRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return repo.findAll();
    }
}
