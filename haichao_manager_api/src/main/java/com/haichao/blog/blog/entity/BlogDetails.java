package com.haichao.blog.blog.entity;
import java.io.Serializable;
import java.lang.String;
import java.lang.Integer;
public class  BlogDetails implements Serializable{
private String  cguid;
private String  classId;
private String  tagId;
private String  status;
private String  name;
private byte[]  details;
private Integer  userId;

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
public String getStatus() {
        return this.status;
        }
public void setStatus(String status) {
        this.status = status;
        }
public String getName() {
        return this.name;
        }
public void setName(String name) {
        this.name = name;
        }
public byte[] getDetails() {
        return this.details;
        }
public void setDetails(byte[] details) {
        this.details = details;
        }
public Integer getUserId() {
        return this.userId;
        }
public void setUserId(Integer userId) {
        this.userId = userId;
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
        "}";
        }
        }