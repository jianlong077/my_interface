//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import java.io.Serializable;

public class ServiceImport implements Serializable {
    private String nameUppeCase;
    private String javaPathOut;
    private String javaPathParent;
    private String javaPath;
    private String template_vm = "serviceImpl.java.vm";

    public ServiceImport(BaseModle baseModle) {
        this.nameUppeCase = baseModle.getEntityName() + "ServiceImp";
        this.javaPathOut = baseModle.getBaseJavaPathOut() + "\\service\\impl\\" + baseModle.getEntityName() + "ServiceImp.java";
        this.javaPathParent = baseModle.getBaseJavaPath() + ".service.impl";
        this.javaPath = baseModle.getBaseJavaPath() + ".service.impl." + baseModle.getEntityName() + "ServiceImp";
    }

    public void outJava(BaseModle modle) {
        BaseTemplate.buildMain(this.javaPathOut, this.template_vm, modle, modle.getIfAllCover());
    }

    public String getNameUppeCase() {
        return this.nameUppeCase;
    }

    public void setNameUppeCase(String nameUppeCase) {
        this.nameUppeCase = nameUppeCase;
    }

    public String getJavaPathOut() {
        return this.javaPathOut;
    }

    public void setJavaPathOut(String javaPathOut) {
        this.javaPathOut = javaPathOut;
    }

    public String getJavaPathParent() {
        return this.javaPathParent;
    }

    public void setJavaPathParent(String javaPathParent) {
        this.javaPathParent = javaPathParent;
    }

    public String getJavaPath() {
        return this.javaPath;
    }

    public void setJavaPath(String javaPath) {
        this.javaPath = javaPath;
    }
}
