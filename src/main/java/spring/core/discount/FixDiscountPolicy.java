package spring.core.discount;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import spring.core.annotation.MainDiscountPolicy;
import spring.core.member.Grade;
import spring.core.member.Member;

@Component
/**
 * Qualifier
 * Qualifier는 빈 이름을 변경시키는 것은 아님
 * 같은 타입으로 스프링 빈이 2개이상 등록되어 있을 때 구분할 수 있도록 하는 어노테이션이다.
 */
//@Qualifier("fixDiscountPolicy")
/**
 * Primary
 * 같은 타입으로 스프링 빈이 2개이상 등록되어 있을 때 우선권을 가지도록 하는 어노테이션이다.
 */
@Primary
public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1_000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) return discountFixAmount;
        else return 0;
    }
}
