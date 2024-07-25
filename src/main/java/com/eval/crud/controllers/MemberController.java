package com.eval.crud.controllers;

import com.eval.crud.data.MemberDTO;
import com.eval.crud.entities.Member;
import com.eval.crud.services.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members")
    public ResponseEntity<List<Member>> getMembers() {
        List<Member> members = memberService.findAll();
        if (members.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(members, HttpStatus.OK);
    }

    @GetMapping("/getbyid")
    public ResponseEntity<Member> getMemberById(@RequestParam int id) {
        Optional<Member> member = memberService.findById(id);
        return member.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }

    @GetMapping("/getbyunit")
    public ResponseEntity<List<Member>> getMembersByUnit(@RequestParam String unit) {
        List<Member> members = memberService.findByUnit(unit);
        if (members.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(members, HttpStatus.OK);
        }
    }

    @PostMapping("/create")
    public ResponseEntity<Member> createMember(@RequestBody MemberDTO member) {
        Member m = memberService.save(member);
        return ResponseEntity.ok(m);
    }

    @PutMapping ("/edit")
    public ResponseEntity<Member> updateMember(@RequestBody MemberDTO member) {
        memberService.update(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteMember(@RequestBody MemberDTO member) {
        memberService.delete(member);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
