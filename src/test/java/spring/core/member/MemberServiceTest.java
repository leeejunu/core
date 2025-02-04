package spring.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.AppConfig;
import spring.core.AutoAppConfig;

public class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appConfig = new AppConfig();
        appConfig.memberService();
    }

    @Test
    void join() {
        //준비
        Member member = new Member(1L, "Lee", Grade.VIP);
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        memberService = ac.getBean("memberServiceImpl", MemberService.class);

        //실행
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //검증
        Assertions.assertThat(member).isEqualTo(findMember);
    }

}
