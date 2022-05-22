package study.servlet.domain.member;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemberRepositoryTest {

    MemberRepository memberRepository = MemberRepository.getInstance();

    @AfterEach
    void afterEach() {
        memberRepository.clearStore();
    }

    @Test
    public void save() {
        //given
        Member member = new Member("member", 20);

        //when
        Member savedMember = memberRepository.save(member);
        Member findMember = memberRepository.findById(savedMember.getId());

        //then
        assertThat(findMember).isEqualTo(savedMember);
    }

    @Test
    public void findAll() {
        //given
        Member member1 = new Member("member1", 10);
        Member member2 = new Member("member2", 20);

        memberRepository.save(member1);
        memberRepository.save(member2);

        //when
        List<Member> findMember = memberRepository.findAll();

        //then
        assertThat(findMember.size()).isEqualTo(2);
        assertThat(findMember).contains(member1, member2);
    }
}