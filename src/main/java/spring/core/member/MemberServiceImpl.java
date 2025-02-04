package spring.core.member;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService{

    /**
     * MemberServiceImpl가 구현 클래스인 MemoryMemberRepositoryImpl를 의존하고 있으므로
     * DIP(Dependency Inversion Principle)를 위반한 상황
     */
    //private final MemberRepository = new MemoryMemberRepositoryImpl();

    private final MemberRepository memberRepository;

    /**
     * DIP문제 해결 방법 (생성자 주입)
     * MemberServiceImpl의 생성자 파라미터를 인터페이스로 맞추고
     * 클라이언트 쪽에서 원하는 구현 클래스를 주입하게 되면
     * MemberServiceImpl는 구현 클래스를 의존하지 않을 수 있다.
     */
    @Autowired
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
