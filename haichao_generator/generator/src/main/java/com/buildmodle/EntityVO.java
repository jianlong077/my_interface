//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import com.util.ToolUtil;
import java.io.Serializable;

public class EntityVO implements Serializable {
    private String nameUppeCase;
    private String nameLowerCase;
    private String javaPathOut;
    private String javaPathParent;
    private String javaPath;
    private String template_vm = "entityVO.java.vm";

    public EntityVO(BaseModle baseModle) {
        this.nameUppeCase = baseModle.getEntityName() + "VO";
        this.nameLowerCase = ToolUtil.FirstLowerCase(this.nameUppeCase);
        if(!baseModle.getEntityIfToApi()) {
            this.javaPathOut = baseModle.getBaseJavaPathOut() + "\\entity\\vo\\" + baseModle.getEntityName() + "VO.java";
        }else{
            this.javaPathOut = baseModle.getBaseJavaPathOut().replace(baseModle.getProjectName(),baseModle.getProjectName()+"_api") + "\\entity\\vo\\" + baseModle.getEntityName() + "VO.java";
        }
        this.javaPathParent = baseModle.getBaseJavaPath() + ".entity.vo";
        this.javaPath = baseModle.getBaseJavaPath() + ".entity.vo." + baseModle.getEntityName() + "VO";
    }

    public void outJava(BaseModle modle) {
        BaseTemplate.buildMain(this.javaPathOut, this.template_vm, modle, false);
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
