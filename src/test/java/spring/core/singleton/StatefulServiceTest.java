package spring.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.assertj.core.api.Assertions.*;


class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean("statefulService", StatefulService.class);
        StatefulService statefulService2 = ac.getBean("statefulService", StatefulService.class);

        //ThreadA: A사용자가 10000원을 주문
        int priceA = statefulService1.order("userA", 10000);

        //ThreadA: B사용자가 20000원을 주문
        int priceB = statefulService2.order("userB", 20000);

//        int price = statefulService2.getPrice();
//        System.out.println("price = " + price);

        assertThat(priceA).isEqualTo(10000);
        assertThat(priceB).isEqualTo(20000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }

}