package hello.core.discount;

import hello.core.member.Grade;
import hello.core.member.Member;

//정액 할인
public class FixDiscountPolicy implements DiscountPolicy {

    private int discounFixAmount = 1000;    //1000원 할인

   @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {   //enum 타입은 == 쓰는것이다. (equals() X)
            return discounFixAmount;
        } else {
            return 0;
        }
    }
}
