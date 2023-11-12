package com.example.A.chime.diary.repository;

import com.example.A.chime.diary.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member,Long> {
    public Member findByMemberId(Long memberId);

}
