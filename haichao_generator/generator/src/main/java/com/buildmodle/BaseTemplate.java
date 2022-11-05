//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import com.util.ToolUtil;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Properties;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

public class BaseTemplate {
    public BaseTemplate() {
    }

    public static void buildMain(String outPutJavaPath, String template_vm, Object obj, boolean ifCover) {
        Properties p = new Properties();
        System.out.println(ToolUtil.getParentBeforeOne() + "\\templets");
        p.setProperty("resource.loader.file.path", ToolUtil.getParentBeforeOne() + "\\templets");
        p.setProperty("UTF-8", "UTF-8");
        VelocityEngine ve = new VelocityEngine();

        try {
            ve.init(p);
            Template template = ve.getTemplate(template_vm);
            VelocityContext root = new VelocityContext();
            root.put("obj", obj);
            File file = new File(outPutJavaPath);
            boolean exist = file.exists();
            if (!exist) {
                File parentFile = file.getParentFile();
                parentFile.mkdirs();
                Writer mywriter = new PrintWriter(new FileOutputStream(file));
                template.merge(root, mywriter);
                mywriter.flush();
            } else if (ifCover) {
                Writer mywriter = new PrintWriter(new FileOutputStream(file));
                template.merge(root, mywriter);
                mywriter.flush();
            }
        } catch (Exception var12) {
            var12.printStackTrace();
        }

    }
}
