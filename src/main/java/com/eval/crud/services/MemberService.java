package com.eval.crud.services;

import com.eval.crud.data.MemberDTO;
import com.eval.crud.entities.Member;
import com.eval.crud.entities.Position;
import com.eval.crud.entities.Unit;
import com.eval.crud.repositories.MemberRepository;
import com.eval.crud.repositories.PositionRepository;
import com.eval.crud.repositories.UnitRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    private final UnitRepository unitRepository;

    private final PositionRepository positionRepository;

    public MemberService(MemberRepository memberRepository, UnitRepository unitRepository, PositionRepository positionRepository) {
        this.memberRepository = memberRepository;
        this.unitRepository = unitRepository;
        this.positionRepository = positionRepository;
    }

    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public Optional<Member> findById(int id) {
        return memberRepository.findById(id);
    }

    public List<Member> findByUnit(String name) {
        Unit unit = unitRepository.findByName(name);
        return memberRepository.findByUnit(unit);
    }

    public Member save(MemberDTO member) {
        Optional<Unit> unit = unitRepository.findById(member.getUnitId());
        Optional<Position> position = positionRepository.findById(member.getPositionId());
        if (unit.isPresent() && position.isPresent()) {
            return memberRepository.save(new Member(member.getName(), member.getAge(), member.getGender(), unit.get(), position.get()));
        }
        return null;
    }

    public void update(MemberDTO dto) {
        Optional<Member> optional = memberRepository.findById(dto.getId());
        Optional<Unit> unit = unitRepository.findById(dto.getUnitId());
        Optional<Position> position = positionRepository.findById(dto.getPositionId());
        if (unit.isPresent() && position.isPresent() && optional.isPresent()) {
            Member member = optional.get();
            member.setName(dto.getName());
            member.setAge(dto.getAge());
            member.setGender(dto.getGender());
            member.setUnit(unit.get());
            member.setPosition(position.get());
            memberRepository.save(member);
        }
    }

    public void delete(MemberDTO dto) {
        Optional<Member> optional = memberRepository.findById(dto.getId());
        optional.ifPresent(memberRepository::delete);
    }
}
