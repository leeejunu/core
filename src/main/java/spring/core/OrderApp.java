package spring.core;

import spring.core.member.*;
import spring.core.order.Order;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

public class OrderApp {

    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();

        Long memberId = 1L;
        Member member = new Member(memberId, "Lee", Grade.VIP);
        memberService.join(member);
        Order order = orderService.createOrder(1L, "itemA", 12_000);

        System.out.println("order = " + order);
    }
}
