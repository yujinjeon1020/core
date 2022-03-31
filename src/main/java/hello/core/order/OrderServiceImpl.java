package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //회원 찾기
    private final MemberRepository memberRepository = new MemoryMemberRepository(); //실제 구현 객체 인스턴스화
    //할인 정책
    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();          //실제 구현 객체 인스턴스화

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 찾기
        Member member = memberRepository.findById(memberId);
        //할인액?
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
