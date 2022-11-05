//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.util;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ToolUtil {
    public static String FirstLowerCase(String str) {
        String first = str.substring(0, 1);
        return first.toLowerCase() + str.substring(1, str.length());
    }

    public static Properties getProperties(String name) {
        String user_dir = getParentBeforeOne() + "\\" + name;
        InputStream in = null;
        Properties p = new Properties();

        try {
            in = new BufferedInputStream(new FileInputStream(user_dir));
            p.load(in);
        } catch (FileNotFoundException var5) {
            var5.printStackTrace();
        } catch (IOException var6) {
            var6.printStackTrace();
        }

        return p;
    }

    public static String getParentBeforeOne() {
        String user_dir = System.getProperty("user.dir");
        return user_dir;
    }

    public static String getParentBeforeTow() {
        String user_dir = new File(System.getProperty("user.dir")).getParent();
        return user_dir;
    }
}
