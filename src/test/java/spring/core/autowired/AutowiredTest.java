package spring.core.autowired;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import spring.core.member.Member;

import java.util.Optional;

public class AutowiredTest {

    @Test
    void autowiredOption() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestBean.class);
//        ac.getBean()
    }

    @Component
    static class TestBean {
        /**
         * 관련된 bean이 없다면 메서드 호출을 하지 않는다.
         */
        @Autowired(required = false)
        public void setNoBean1(Member noBean1) {
            System.out.println("noBean1 = " + noBean1);
        }

        /**
         * 관련된 bean이 없다면 null이 주입
         */
        @Autowired
        public void setNoBean2(@Nullable Member noBean2) {
            System.out.println("noBean2 = " + noBean2);
        }

        @Autowired
        public void setNoBean2(Optional<Member> noBean3) {
            System.out.println("noBean3 = " + noBean3);
        }
    }
}
