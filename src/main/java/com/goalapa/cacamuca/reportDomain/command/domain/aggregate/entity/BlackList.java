package com.goalapa.cacamuca.reportDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.reportDomain.command.domain.aggregate.vo.BlackListMemberVO;
import lombok.Getter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Table(name = "blacklist")
public class BlackList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "blacklist_no")
    private Integer blacklistNo;

    @Column(name = "blacklist_reg_date")
    private LocalDate blacklistRegDate;

    @Column(name = "blacklist_rel_date")
    private LocalDate blacklistRelDate;

    @Embedded
    private BlackListMemberVO blackListMemberVO;

    public BlackList() {

    }

    public BlackList(BlackListMemberVO blackListMemberVO, LocalDate blacklistRegDate, LocalDate blacklistRelDate) {
        this.blackListMemberVO = blackListMemberVO;
        this.blacklistRegDate = blacklistRegDate;
        this.blacklistRelDate = blacklistRelDate;
    }

    public void setBlacklistRelDate(LocalDate blacklistRelDate) {
        this.blacklistRelDate = blacklistRelDate;
    }
}
