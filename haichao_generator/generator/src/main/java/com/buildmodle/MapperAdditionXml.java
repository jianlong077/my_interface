//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import java.io.Serializable;

public class MapperAdditionXml implements Serializable {
    private String xmlPathOut;
    private String template_vm = "mapperXmlAdd.java.vm";

    public MapperAdditionXml(BaseModle baseModle) {
        this.xmlPathOut = baseModle.getBaseXmlPathOut() + "\\" + baseModle.getEntityName() + "MapperAdd.xml";
    }

    public void outJava(BaseModle modle) {
        BaseTemplate.buildMain(this.xmlPathOut, this.template_vm, modle, modle.getIfAllCover());
    }
}
