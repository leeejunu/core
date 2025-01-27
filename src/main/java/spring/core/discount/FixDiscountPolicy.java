package spring.core.discount;

import spring.core.member.Grade;
import spring.core.member.Member;

public class FixDiscountPolicy implements DiscountPolicy{

    private final int discountFixAmount = 1_000;

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) return discountFixAmount;
        else return 0;
    }
}
