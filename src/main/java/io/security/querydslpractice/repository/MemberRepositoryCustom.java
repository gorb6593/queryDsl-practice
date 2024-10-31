package io.security.querydslpractice.repository;

import io.security.querydslpractice.dto.MemberSearchCondition;
import io.security.querydslpractice.dto.MemberTeamDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MemberRepositoryCustom {
    List<MemberTeamDto> search(MemberSearchCondition condition);
    Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pageable);
    List<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable pageable);
}
