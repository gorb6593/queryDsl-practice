package io.security.querydslpractice.entity;

import jakarta.persistence.*;
import lombok.*;

import static jakarta.persistence.FetchType.*;
/*
    this()는 자바에서 특별한 문법으로, 같은 클래스의 다른 생성자를 호출할 때 사용
    가장 첫 줄에서 사용되어야 한다.
    생성자 호출 시 매개변수의 타입과 개수를 기준으로 일치하는 생성자를 찾는다
 */
@Table(name = "member_dsl")
@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(of = {"id", "username", "age"})
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "member_id")
    private Long id;

    private String username;
    private int age;

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name ="team_id")
    private Team team;

    public Member(String username) {
        this(username, 0);
    }

    public Member(String username, int age) {
        this(username, age, null);
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    private void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }

}
