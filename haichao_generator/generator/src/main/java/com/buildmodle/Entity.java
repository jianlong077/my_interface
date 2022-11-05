//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import com.db.DbColumDetail;
import com.util.ToolUtil;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;

public class Entity implements Serializable {
    private String nameUppeCase;
    private String nameLowerCase;
    private String javaPathOut;
    private String javaPathParent;
    private String javaPath;
    private Set<String> impprotTypes = new HashSet();
    private List<DbColumDetail> dbColumDetails;
    private String template_vm = "entity.java.vm";

    public Entity(BaseModle baseModle, List<DbColumDetail> dbColumDetails) {
        this.nameUppeCase = baseModle.getEntityName();
        this.nameLowerCase = ToolUtil.FirstLowerCase(baseModle.getEntityName());
        if(!baseModle.getEntityIfToApi()) {
            this.javaPathOut = baseModle.getBaseJavaPathOut() + "\\entity\\" + baseModle.getEntityName() + ".java";
        }else{
            this.javaPathOut = baseModle.getBaseJavaPathOut().replace(baseModle.getProjectName(),baseModle.getProjectName()+"_api") + "\\entity\\" + baseModle.getEntityName() + ".java";
        }
        this.javaPathParent = baseModle.getBaseJavaPath() + ".entity";
        this.javaPath = baseModle.getBaseJavaPath() + ".entity." + baseModle.getEntityName();
        this.dbColumDetails = dbColumDetails;
        if (dbColumDetails != null) {
            Iterator var3 = dbColumDetails.iterator();

            while(var3.hasNext()) {
                DbColumDetail d = (DbColumDetail)var3.next();
                if (StringUtils.isNotBlank(d.getJavaTypeImprot())) {
                    this.impprotTypes.add(d.getJavaTypeImprot());
                }
            }
        }

    }

    public void outJava(BaseModle modle) {
        BaseTemplate.buildMain(this.javaPathOut, this.template_vm, modle, true);
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

    public List<DbColumDetail> getDbColumDetails() {
        return this.dbColumDetails;
    }

    public void setDbColumDetails(List<DbColumDetail> dbColumDetails) {
        this.dbColumDetails = dbColumDetails;
    }

    public Set<String> getImpprotTypes() {
        return this.impprotTypes;
    }

    public void setImpprotTypes(Set<String> impprotTypes) {
        this.impprotTypes = impprotTypes;
    }
}
