package com.example.teamprojectstudy.repository;

import com.example.teamprojectstudy.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findByName(String name);
    Optional<Member> findByAge(Long age);
    List<Member> findAll();
}
