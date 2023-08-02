package com.project.BusFlow.model;


import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "Otp_table")
public class Otp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private long id;

    @Column(name = "Attempt")
    private int attempts;

    @Column(name = "Otp_Value")
    private String otpValue;

    @Column(name = "Expire_Mins")
    private final int expireMins = 2;

    @Column(name = "Create_Date")
    private LocalDate createDate;

    @Column(name = "Create_Time")
    private LocalTime createTime;

    @Column(name = "Email")
    private String email;

    @Column(name = "Verified")
    private Boolean verified = false;

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public String getOtpValue() {
        return otpValue;
    }

    public void setOtpValue(String otpValue) {
        this.otpValue = otpValue;
    }

    public int getExpireMins() {
        return expireMins;
    }

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public LocalTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalTime createTime) {
        this.createTime = createTime;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getVerified() {
        return verified;
    }

    public void setVerified(Boolean verified) {
        this.verified = verified;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
