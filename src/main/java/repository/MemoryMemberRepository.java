package repository;

import domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;
@Repository
public class MemoryMemberRepository implements MemberRepository{

    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public Member save(Member member) {
        store.put(member.getAge(), member);
        return member;
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
        //반복문을 돌며 찾아준다
    }

    @Override
    public Optional<Member> findByAge(Long age) {
        return Optional.ofNullable(store.get(age));
        //map으로 불러오는데 optional로 감싸주면 null일떄 서버에서 처리해 줄 수 있다.
    }


}
