//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import com.util.ToolUtil;
import java.io.Serializable;

public class Domain implements Serializable {
    private String nameUppeCase;
    private String nameLowerCase;
    private String javaPathOut;
    private String javaPathParent;
    private String javaPath;
    private String template_vm = "domain.java.vm";

    public Domain(BaseModle baseModle) {
        this.nameUppeCase = baseModle.getEntityName() + "Domain";
        this.nameLowerCase = ToolUtil.FirstLowerCase(this.nameUppeCase);
        this.javaPathOut = baseModle.getBaseJavaPathOut() + "\\domain\\" + baseModle.getEntityName() + "Domain.java";
        this.javaPathParent = baseModle.getBaseJavaPath() + ".domain";
        this.javaPath = baseModle.getBaseJavaPath() + ".domain." + baseModle.getEntityName() + "Domain";
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
