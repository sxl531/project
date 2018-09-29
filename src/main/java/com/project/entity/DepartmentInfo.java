package com.project.entity;

import java.sql.Timestamp;

public class DepartmentInfo {
    private int id; //主键
    private Timestamp creationTime; //创建时间
    public  int deleted;    //启用标志
    private Timestamp lastUpdateTime;   //最后更新时间
    private String name;    //部门名称
    private int parentId;   //上级部门id
    private String wgId;    //部门编号
    private String fullname;//部门全称
    private String scope;   //部门区域

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreationTime() {
        return creationTime;
    }

    public void setCreationTime(Timestamp creationTime) {
        this.creationTime = creationTime;
    }

    public int getDeleted() {
        return deleted;
    }

    public void setDeleted(int deleted) {
        this.deleted = deleted;
    }

    public Timestamp getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Timestamp lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public String getWgId() {
        return wgId;
    }

    public void setWgId(String wgId) {
        this.wgId = wgId;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
