package controller;

import Service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

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
}
