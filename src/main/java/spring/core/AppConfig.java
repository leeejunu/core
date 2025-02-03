package spring.core;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import spring.core.discount.DiscountPolicy;
import spring.core.discount.RateDiscountPolicy;
import spring.core.member.MemberRepository;
import spring.core.member.MemberService;
import spring.core.member.MemberServiceImpl;
import spring.core.member.MemoryMemberRepositoryImpl;
import spring.core.order.OrderService;
import spring.core.order.OrderServiceImpl;

/**
 * IoC 컨테이너, DI 컨테이너
 */
@Configuration
public class AppConfig {

    /**
     * 반환된 객체들은 스프링 빈이라고 한다.
     * {
     *     메서드 명(key): 반환 객체(value)
     * }
     * @return Spring Bean
     */
    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepositoryImpl();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
