package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    //회원 찾기
    private final MemberRepository memberRepository;
    //할인 정책
    private final DiscountPolicy discountPolicy;  //아래의 구현 클래스가 아닌 !추상 클래스!에만 의존해야함 -> 그러나, 객체 생성은 필요함 -> 대신 해줄 누군가(AppConfig)가 필요함!
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();          //실제 구현 객체 인스턴스화
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();

    //생성자를 통해 AppConfig에 설정된(주입된) 사항을 받아들여옴
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        //회원 찾기
        Member member = memberRepository.findById(memberId);
        //할인액?
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
