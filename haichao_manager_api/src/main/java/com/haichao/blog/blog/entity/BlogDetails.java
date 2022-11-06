package com.haichao.blog.blog.entity;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
public class  BlogDetails implements Serializable{
private String  cguid;
private String  classId;
private String  tagId;
private Integer  status;
private String  name;
private String  details;
private String  userId;
private Date  lastTime;
private String  code;
private String  remark;

public String getCguid() {
        return this.cguid;
        }
public void setCguid(String cguid) {
        this.cguid = cguid;
        }
public String getClassId() {
        return this.classId;
        }
public void setClassId(String classId) {
        this.classId = classId;
        }
public String getTagId() {
        return this.tagId;
        }
public void setTagId(String tagId) {
        this.tagId = tagId;
        }
public Integer getStatus() {
        return this.status;
        }
public void setStatus(Integer status) {
        this.status = status;
        }
public String getName() {
        return this.name;
        }
public void setName(String name) {
        this.name = name;
        }
public String getDetails() {
        return this.details;
        }
public void setDetails(String details) {
        this.details = details;
        }
public String getUserId() {
        return this.userId;
        }
public void setUserId(String userId) {
        this.userId = userId;
        }
public Date getLastTime() {
        return this.lastTime;
        }
public void setLastTime(Date lastTime) {
        this.lastTime = lastTime;
        }
public String getCode() {
        return this.code;
        }
public void setCode(String code) {
        this.code = code;
        }
public String getRemark() {
        return this.remark;
        }
public void setRemark(String remark) {
        this.remark = remark;
        }
@Override
public String toString() {
        return "BlogDetails{" +
                "cguid=" + cguid +
                ", classId=" + classId +
                ", tagId=" + tagId +
                ", status=" + status +
                ", name=" + name +
                ", details=" + details +
                ", userId=" + userId +
                ", lastTime=" + lastTime +
                ", code=" + code +
                ", remark=" + remark +
        "}";
        }
        }