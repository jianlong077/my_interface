package com.db;

import org.apache.commons.text.CaseUtils;

public class DbColumDetail {
    private String columName;
    private String columType;
    private String columRemark;
    private String javaName;
    private String javaSetOrGetName;
    private String javaType;
    private String javaTypeImprot;
    private boolean ifKey;

    public DbColumDetail(String columName, String columType, String columRemark,boolean flag) {
        this.ifKey = flag;
        this.columName = columName;
        this.columType = columType;
        this.columRemark = columRemark;
        this.javaName = CaseUtils.toCamelCase(this.columName, false, new char[]{'_'});
        this.javaSetOrGetName =this.javaName.substring(0,1).toUpperCase().concat(this.javaName.substring(1));
        DbToMybatisToJavaTypeName.ToJavaTypeName(this);
    }

    public String getColumName() {
        return columName;
    }

    public void setColumName(String columName) {
        this.columName = columName;
    }

    public String getColumType() {
        return columType;
    }

    public void setColumType(String columType) {
        this.columType = columType;
    }

    public String getColumRemark() {
        return columRemark;
    }

    public void setColumRemark(String columRemark) {
        this.columRemark = columRemark;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaTypeImprot() {
        return javaTypeImprot;
    }

    public void setJavaTypeImprot(String javaTypeImprot) {
        this.javaTypeImprot = javaTypeImprot;
    }

    public String getJavaName() {
        return javaName;
    }

    public void setJavaName(String javaName) {
        this.javaName = javaName;
    }

    public String getJavaSetOrGetName() {
        return javaSetOrGetName;
    }

    public void setJavaSetOrGetName(String javaSetOrGetName) {
        this.javaSetOrGetName = javaSetOrGetName;
    }

    public boolean isIfKey() {
        return ifKey;
    }

    public void setIfKey(boolean ifKey) {
        this.ifKey = ifKey;
    }
}
