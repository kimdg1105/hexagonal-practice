package com.msa.member.domain.model;

import com.msa.member.domain.vo.*;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long memberNo;
    @Embedded
    private IDName idName;
    @Embedded
    private Password password;
    @Embedded
    private Email email;
    @ElementCollection
    private List<Authority> authorities = new ArrayList<>();
    @Embedded
    private Point point;

    public static Member create(IDName idName, Password password, Email email) {
        Member member = new Member();
        member.idName = idName;
        member.password = password;
        member.email = email;
        member.point = Point.create();
        member.authorities.add(new Authority(UserRole.USER));
        return member;
    }

    public void savePoint(int value) {
        this.point.add(value);
    }

    public void usePoint(int value) {
        this.point.subtract(value);
    }

    public Member login(IDName idName, Password password) {
        if (!this.idName.equals(idName))
            throw new IllegalArgumentException("아이디가 일치하지 않습니다.");

        if (!this.password.equals(password))
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");

        return this;
    }
}
