package Service;

import domain.Member;
import org.springframework.stereotype.Service;
import repository.MemberRepository;
import repository.MemoryMemberRepository;

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

    //검색
    public Optional<Member> findName(String name) {
       return memberRepository.findByName(name);
    }
    public Optional<Member> findAge(Long age) {
        return memberRepository.findByAge(age);
    }
}
