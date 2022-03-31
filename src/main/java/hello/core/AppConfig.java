package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//애플리케이션 전체의 설정을 담당 (공연 기획자) - Service에서 필요한 구현 객체(Repository)들을 이곳에서 생성함 -> Service에서는 생성자를 통해 가져올(주입) 것임
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(new MemoryMemberRepository()); //memberServiceImpl에서 필요한 Repository 객체 생성 -> memberServiceImpl에서는 생성자를 통해 받아올 것임(주입됨)
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

}
