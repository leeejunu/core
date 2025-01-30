package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.member.*;

import static spring.core.member.Grade.*;

public class MemberApp {

    public static void main(String[] args) {

        //스프링 컨터이너에 AppConfig 설정정보를 넣는다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "Lee", VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(findMember.toString());
    }
}
