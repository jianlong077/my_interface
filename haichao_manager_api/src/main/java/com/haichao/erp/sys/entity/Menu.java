package com.haichao.erp.sys.entity;
import java.io.Serializable;
import java.util.Date;
import java.lang.String;
import java.lang.Integer;
public class  Menu implements Serializable{
private String  code;
private String  name;
private String  cguidParent;
private String  action;
private Integer  level;
private String  type;
private String  auditStatus;
private String  status;
private String  outCode;
private String  cguid;
private Date  lastUpdateTime;

public String getCode() {
        return this.code;
        }
public void setCode(String code) {
        this.code = code;
        }
public String getName() {
        return this.name;
        }
public void setName(String name) {
        this.name = name;
        }
public String getCguidParent() {
        return this.cguidParent;
        }
public void setCguidParent(String cguidParent) {
        this.cguidParent = cguidParent;
        }
public String getAction() {
        return this.action;
        }
public void setAction(String action) {
        this.action = action;
        }
public Integer getLevel() {
        return this.level;
        }
public void setLevel(Integer level) {
        this.level = level;
        }
public String getType() {
        return this.type;
        }
public void setType(String type) {
        this.type = type;
        }
public String getAuditStatus() {
        return this.auditStatus;
        }
public void setAuditStatus(String auditStatus) {
        this.auditStatus = auditStatus;
        }
public String getStatus() {
        return this.status;
        }
public void setStatus(String status) {
        this.status = status;
        }
public String getOutCode() {
        return this.outCode;
        }
public void setOutCode(String outCode) {
        this.outCode = outCode;
        }
public String getCguid() {
        return this.cguid;
        }
public void setCguid(String cguid) {
        this.cguid = cguid;
        }
public Date getLastUpdateTime() {
        return this.lastUpdateTime;
        }
public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
        }
@Override
public String toString() {
        return "Menu{" +
                "code=" + code +
                ", name=" + name +
                ", cguidParent=" + cguidParent +
                ", action=" + action +
                ", level=" + level +
                ", type=" + type +
                ", auditStatus=" + auditStatus +
                ", status=" + status +
                ", outCode=" + outCode +
                ", cguid=" + cguid +
                ", lastUpdateTime=" + lastUpdateTime +
        "}";
        }
        }