package spring.core;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import spring.core.member.*;
import spring.core.order.Order;
import spring.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

        //ApplicationContext  -> 스프링 컨테이너라고 한다.
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "Lee", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L, "itemA", 12_000);

        System.out.println("order = " + order);
    }
}
