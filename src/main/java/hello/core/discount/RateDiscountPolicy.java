package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//정률 할인 (10%)
public class RateDiscountPolicy implements DiscountPolicy {

    private int discounrtPercent = 10;
    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discounrtPercent / 100;
        } else {
            return 0;
        }
    }
}
