package spring.core.member;


import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
@Primary
public class MemoryMemberRepositoryImpl implements MemberRepository{

    /**
     * HashMap - 여러 스레드가 동시에 HashMap에 접근 가능
     * HashTable - 하나의 스레드가 Hashtable에 접근하였다면 lock을 걸어 다른 스레드가 접근하지 못함.
     * ConcurrentHashMap - 맵 자체에 lock을 걸지않고 세그먼트마다 lock을 걸어 여러 스레드가 서로 다른 세그먼트에 접근이 가능함.
     *
     * 싱글 스레드 상황이라면 HashMap이 가장 뛰어난 성능을 가짐. 하지만 멀티 스레드 상황에서는 안전하지 못함.
     * 멀티 스레드라면 세그먼트마다 lock을 거는 ConcurrentHashMap이 Hashtable보다 뛰어난 성능을 가짐.
     */
    private static final Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        System.out.println(store);
        return store.get(memberId);
    }
}
