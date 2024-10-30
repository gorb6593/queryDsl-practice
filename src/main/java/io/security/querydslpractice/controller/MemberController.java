package io.security.querydslpractice.controller;

import io.security.querydslpractice.dto.MemberSearchCondition;
import io.security.querydslpractice.dto.MemberTeamDto;
import io.security.querydslpractice.repository.MemberJpaRepository;
import lombok.Generated;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MemberController {

    private final MemberJpaRepository memberJpaRepository;

    @GetMapping("/v1/members")
    public List<MemberTeamDto> searchMemberV1(MemberSearchCondition condition) {
        return memberJpaRepository.search(condition);
    }
}
