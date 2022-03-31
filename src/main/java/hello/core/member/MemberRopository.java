package hello.core.member;

public interface MemberRopository {

    void save(Member member);

    Member findById(Long memberId);
}
