package com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo;

import org.hibernate.annotations.Comment;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.time.LocalDate;

@Embeddable
public class BirthDay {

    @Column(name = "member_birth")
    @Comment("생년월일")
    private LocalDate memberBirth;

    protected BirthDay() {}

    public BirthDay(LocalDate birthDay) {
        validatePast(birthDay);
        this.memberBirth = birthDay;
    }

    private void validatePast(LocalDate birthDay) {

        if(!birthDay.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("생일은 오늘 날짜보다 이후일 수 없습니다.");
        }
    }

    public int getAge() {

        LocalDate now = LocalDate.now();


        return 10;
    }
}
