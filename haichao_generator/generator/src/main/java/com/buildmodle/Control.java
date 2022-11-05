//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import java.io.Serializable;

public class Control implements Serializable {
    private String nameUppeCase;
    private String javaPathOut;
    private String javaPathParent;
    private String javaPath;
    private String template_vm = "controller.java.vm";

    public Control(BaseModle baseModle) {
        this.nameUppeCase = baseModle.getEntityName() + "Control";
        this.javaPathOut = baseModle.getBaseJavaPathOut() + "\\control\\" + baseModle.getEntityName() + "Control.java";
        this.javaPathParent = baseModle.getBaseJavaPath() + ".control";
        this.javaPath = baseModle.getBaseJavaPath() + ".control." + baseModle.getEntityName() + "Control";
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
