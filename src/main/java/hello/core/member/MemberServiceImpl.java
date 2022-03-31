package hello.core.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;  //추상 인터페이스에만 의존하자! 나머지는 AppConfig가 처리할테니..

    //생성자를 통해 AppConfig에 설정된(주입된) 사항을 받아들여옴 
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
