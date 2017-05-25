package com.challenge.model;

import java.util.Date;

public class VoteRecord {
    private Integer id;

    private String mobile;

    private String voteResult;

    private String voteGroup;

    private Date voteDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getVoteResult() {
        return voteResult;
    }

    public void setVoteResult(String voteResult) {
        this.voteResult = voteResult == null ? null : voteResult.trim();
    }

    public String getVoteGroup() {
        return voteGroup;
    }

    public void setVoteGroup(String voteGroup) {
        this.voteGroup = voteGroup == null ? null : voteGroup.trim();
    }

    public Date getVoteDate() {
        return voteDate;
    }

    public void setVoteDate(Date voteDate) {
        this.voteDate = voteDate;
    }
}