package com.example.hellospring.repository;

import com.example.hellospring.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.*;

public class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();

    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("lee");


        repository.save(member);

        Member result = repository.findById(member.getId()).get();

        Assertions.assertEquals(member, result);
        //assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("lee");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("lee2");
        repository.save(member2);

        Member result = repository.findByName("lee").get();

        assertThat(member1).isEqualTo(result);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("lee");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("lee2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
