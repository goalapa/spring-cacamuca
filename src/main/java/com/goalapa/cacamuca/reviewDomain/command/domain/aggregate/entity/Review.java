package com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.entity;

import com.goalapa.cacamuca.reviewDomain.command.domain.aggregate.vo.ReviewWriter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "review")
@AllArgsConstructor
public class Review {

    @Id()
    @Column(name = "review_no")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewNo;

    @Comment("리뷰 내용")
    @Column(name = "review_content")
    private String reviewContent;

    @Column(name = "country")
    private String country;

    @Column(name = "food_type")
    private String foodType;

    @Column(name = "food_name")
    private String foodName;

    @Column(name = "review_date")
    private LocalDate reviewDate;

    @Column(name = "review_rate")
    private double reviewRate;

    @Embedded
    private ReviewWriter reviewWriter;

    @Column(name = "food_no")
    private Integer foodNo;

    @Column(name = "review_keyword")
    private String reviewKeyword;

    @Column(name = "review_price")
    private int reviewPrice;

    @Column(name = "review_link")
    private String reviewLink;

    @Column(name = "like_cnt")
    private Integer likeCnt;

    @Column(name = "report_cnt")
    private Integer reportCnt;

    public Review(String reviewContent, String country, String foodType, String foodName, LocalDate date, double reviewRate, ReviewWriter reviewWriter, Integer foodNo,
                  String reviewKeyword, int reviewPrice, String reviewLink, Integer reportCnt) {
        this.reviewContent = reviewContent;
        this.country = country;
        this.foodType = foodType;
        this.foodName = foodName;
        this.reviewDate = date;
        this.reviewRate = reviewRate;
        this.reviewWriter = reviewWriter;
        this.foodNo = foodNo;
        this.reviewKeyword = reviewKeyword;
        this.reviewPrice = reviewPrice;
        this.reviewLink = reviewLink;
        this.reportCnt = reportCnt;
    }

    public Review(String reviewContent, String country, String foodType, String foodName, LocalDate date, double reviewRate, ReviewWriter reviewWriter, Integer foodNo,
                  String reviewKeyword, int reviewPrice, String reviewLink, Integer reportCnt, Integer likeCnt) {
        this.reviewContent = reviewContent;
        this.country = country;
        this.foodType = foodType;
        this.foodName = foodName;
        this.reviewDate = date;
        this.reviewRate = reviewRate;
        this.reviewWriter = reviewWriter;
        this.foodNo = foodNo;
        this.reviewKeyword = reviewKeyword;
        this.reviewPrice = reviewPrice;
        this.reviewLink = reviewLink;
        this.reportCnt = reportCnt;
        this.likeCnt = likeCnt;
    }

    public Review(){
    }

    public ReviewWriter getReviewWriter() {
        return reviewWriter;
    }

    public void setReviewWriter(ReviewWriter reviewWriter) {
        this.reviewWriter = reviewWriter;
    }

    public int getReviewNo() {
        return reviewNo;
    }

    public String getReviewContent() {
        return reviewContent;
    }

    public void setReviewContent(String reviewContent) {
        this.reviewContent = reviewContent;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getFoodType() {
        return foodType;
    }

    public void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public LocalDate getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(LocalDate reviewDate) {
        this.reviewDate = reviewDate;
    }

    public double getReviewRate() {
        return reviewRate;
    }

    public void setReviewRate(double reviewRate) {
        this.reviewRate = reviewRate;
    }

    public Integer getFoodNo() {
        return foodNo;
    }

    public void setFoodNo(Integer foodNo) {
        this.foodNo = foodNo;
    }

    public String getReviewKeyword() {
        return reviewKeyword;
    }

    public void setReviewKeyword(String reviewKeyword) {
        this.reviewKeyword = reviewKeyword;
    }

    public int getReviewPrice() {
        return reviewPrice;
    }

    public void setReviewPrice(int reviewPrice) {
        this.reviewPrice = reviewPrice;
    }

    public String getReviewLink() {
        return reviewLink;
    }

    public void setReviewLink(String reviewLink) {
        this.reviewLink = reviewLink;
    }

    public Integer getLikeCnt() {
        return likeCnt;
    }

    public void setLikeCnt(Integer likeCnt) {
        this.likeCnt = likeCnt;
    }

    public Integer getReportCnt() {
        return reportCnt;
    }

    public void setReportCnt(Integer reportCnt) {
        this.reportCnt = reportCnt;
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewNo=" + reviewNo +
                ", reviewContent='" + reviewContent + '\'' +
                ", country='" + country + '\'' +
                ", foodType='" + foodType + '\'' +
                ", foodName='" + foodName + '\'' +
                ", reviewDate=" + reviewDate +
                ", reviewRate=" + reviewRate +
                ", reviewWriter=" + reviewWriter +
                ", foodNo=" + foodNo +
                ", reviewKeyword='" + reviewKeyword + '\'' +
                ", reviewPrice=" + reviewPrice +
                ", reviewLink='" + reviewLink + '\'' +
                ", likeCnt=" + likeCnt +
                '}';
    }
}
