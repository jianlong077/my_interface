//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import java.io.Serializable;

public class MapperXml implements Serializable {
    private String xmlPathOut;
    private String template_vm = "mapperXml.java.vm";

    public MapperXml(BaseModle baseModle) {
        this.xmlPathOut = baseModle.getBaseXmlPathOut() + "\\" + baseModle.getEntityName() + "Mapper.xml";
    }

    public void outJava(BaseModle modle) {
        BaseTemplate.buildMain(this.xmlPathOut, this.template_vm, modle, true);
    }
}
