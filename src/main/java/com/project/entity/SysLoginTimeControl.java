package com.project.entity;

import java.util.Date;

public class SysLoginTimeControl {
    private int id;

    private String controlName;

    private Date startTime;

    private Date endTime;

    private int createUserId;

    private Date createTime;

    private String commens;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getControlName() {
        return controlName;
    }

    public void setControlName(String controlName) {
        this.controlName = controlName == null ? null : controlName.trim();
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public int getCreateUserId() {
        return createUserId;
    }

    public void setCreateUserId(int createUserId) {
        this.createUserId = createUserId;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCommens() {
        return commens;
    }

    public void setCommens(String commens) {
        this.commens = commens == null ? null : commens.trim();
    }
}