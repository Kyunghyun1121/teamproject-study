package com.example.teamprojectstudy.Service;

import com.example.teamprojectstudy.domain.Member;
import org.springframework.stereotype.Service;
import com.example.teamprojectstudy.repository.MemberRepository;
import com.example.teamprojectstudy.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();

    //회원가입
    public Long join(Member member){
        memberRepository.save(member);
        return member.getAge();
    }

    /**
     * 전체 회원 조회
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }
    //검색
    public Optional<Member> findName(String name) {
       return memberRepository.findByName(name);
    }
    public Optional<Member> findAge(Long age) {
        return memberRepository.findByAge(age);
    }
}
