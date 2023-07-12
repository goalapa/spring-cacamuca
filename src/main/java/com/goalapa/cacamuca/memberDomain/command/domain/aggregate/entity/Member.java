package com.goalapa.cacamuca.memberDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.memberDomain.command.domain.aggregate.vo.BirthDay;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "Member")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_no")
    private Integer memberNo;

    @Column(name = "member_id")
    private String memberId;

    @Column(name = "member_pwd")
    private String memberPwd;

    @Column(name = "member_nickname")
    private String memberNickname;

    @Column(name = "member_email")
    private String memberEmail;

    @Column(name = "member_grant")
    private String memberGrant;

    @Column(name = "member_report_cnt")
    private String memberReportCnt;

    @Embedded
    private BirthDay birthDay;
}