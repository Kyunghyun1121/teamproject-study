package com.example.teamprojectstudy.controller;

import com.example.teamprojectstudy.Service.MemberService;
import com.example.teamprojectstudy.domain.Member;
import com.example.teamprojectstudy.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }
    //    객체를 new로 만들면 다른 모든군데에서 접근하고
//    스프링 컨테이너로부터만 받아야 정보보안이
//    되기 때문에 스프링 컨테이너에 등록을 하여서 사용한다.
//   생성자에 Autowired라고 해놓으면 컨테이너를 멤버서비스의 컨테이너에 가져다가
//    연결을 시켜준다.
//    하지만 지금 멤버서비스가 스프링 빈에 없어서 연결을 못시켜준다.
//    따라서 멤버서비스 @service를 멤버리포지토리에 @repository 넣어준다.
//    단 application과 같은 패키지에 있어야 스프링빈이 그 패키지의 하위컨텐츠들을
//    꺼내서 사용할 수 있다.

    @GetMapping("/members/join")
    public String createForm() {
        return "members/createMember";
        //그냥 createMeberform으로 이동시켜주는 역할
    }

    @PostMapping("/members/join")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName());
        member.setAge(form.getAge());

        memberService.join(member);
        //join로직을 통해 입력받은 member를 보낸다.
//        그러면 memberservice에서 MemoryMemberRepository의 save 로직을 실행시키면
//                MemoryMemberRepository의 Map에 나이와 이름이 저장된다.

        return "redirect:/";//홈화면으로
    }

    @GetMapping("/members/find")
    public String list(Model model){
        List<Member> members = memberService.findMembers();
        model.addAttribute("members", members);
        return "members/findMember";
    }


}