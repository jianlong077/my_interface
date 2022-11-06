package com.haichao.blog.blog.entity;
import java.io.Serializable;
import java.lang.String;
public class  BlogDetailsTop implements Serializable{
private String  cguid;
private String  name;
private String  status;

public String getCguid() {
        return this.cguid;
        }
public void setCguid(String cguid) {
        this.cguid = cguid;
        }
public String getName() {
        return this.name;
        }
public void setName(String name) {
        this.name = name;
        }
public String getStatus() {
        return this.status;
        }
public void setStatus(String status) {
        this.status = status;
        }
@Override
public String toString() {
        return "BlogDetailsTop{" +
                "cguid=" + cguid +
                ", name=" + name +
                ", status=" + status +
        "}";
        }
        }