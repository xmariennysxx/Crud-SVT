package com.eval.crud.repositories;

import com.eval.crud.entities.Member;
import com.eval.crud.entities.Unit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {
    List<Member> findByUnit(Unit unit);
}
