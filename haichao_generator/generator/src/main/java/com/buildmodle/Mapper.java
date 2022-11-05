//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import com.util.ToolUtil;
import java.io.Serializable;

public class Mapper implements Serializable {
    private String nameUppeCase;
    private String nameLowerCase;
    private String javaPathOut;
    private String javaPathParent;
    private String javaPath;
    private String template_vm = "mapper.java.vm";

    public Mapper(BaseModle baseModle) {
        this.nameUppeCase = baseModle.getEntityName() + "Mapper";
        this.nameLowerCase = ToolUtil.FirstLowerCase(this.nameUppeCase);
        this.javaPathOut = baseModle.getBaseJavaPathOut() + "\\mapper\\" + baseModle.getEntityName() + "Mapper.java";
        this.javaPathParent = baseModle.getBaseJavaPath() + ".mapper";
        this.javaPath = baseModle.getBaseJavaPath() + ".mapper." + baseModle.getEntityName() + "Mapper";
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

    public String getNameLowerCase() {
        return this.nameLowerCase;
    }

    public void setNameLowerCase(String nameLowerCase) {
        this.nameLowerCase = nameLowerCase;
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
