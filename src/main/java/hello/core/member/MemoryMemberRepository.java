package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRopository {

    //id과 member객체를 Map에 키(id)와 값(member객체)으로 저장
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId); //해당 id의 value값을 찾는다 -> get
    }
}
