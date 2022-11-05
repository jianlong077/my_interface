package com.db;

/*
 * Copyright (c) 2011-2021, baomidou (jobob@qq.com).
 * <p>
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * <p>
 * https://www.apache.org/licenses/LICENSE-2.0
 * <p>
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据库配置
 *
 * @author YangHu, hcl, hubin
 * @since 2016/8/30
 */
public class DataSourceConfig {
    private final static Logger LOGGER = LoggerFactory.getLogger(DataSourceConfig.class);

    private   String DRIVER = "com.mysql.jdbc.Driver";
    private   String URL = "jdbc:mysql://localhost:3306/erp_test?useUnicode=true&characterEncoding=utf8";
    private   String USERNAME = "root";
    private   String PASSWORD = "root";

    private static final String SQL = "SELECT * FROM ";// 数据库操作


/*
*  this.DRIVER = "com.mysql.jdbc.Driver";
        this.URL = "jdbc:mysql://localhost:3306/erp_test?useUnicode=true&characterEncoding=utf8";
        this.USERNAME = "root";
        this.ASSWORD = "root";*/
    public DataSourceConfig(String DRIVER,String URL,String USERNAME,String PASSWORD ) {
        this.DRIVER = DRIVER;
        this.URL = URL;
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
         try {
                Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            LOGGER.error("can not load jdbc driver", e);
        }
    }

    /**
     * 获取数据库连接
     *
     * @return
     */
    public  Connection getConnection() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(this.URL, this.USERNAME, this.PASSWORD);
        } catch (SQLException e) {
            LOGGER.error("get connection failure", e);
        }
        return conn;
    }

    /**
     * 关闭数据库连接
     * @param conn
     */
    public static void closeConnection(Connection conn) {
        if(conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                LOGGER.error("close connection failure", e);
            }
        }
    }
    /**
     * 获取表中所有字段名称
     * @param tableName 表名
     * @return
     */
    public  List<DbColumDetail> getColumnNames(String tableName) {
        List<DbColumDetail> columnNames = new ArrayList<>();
        //与数据库的连接
        Connection conn = getConnection();
        PreparedStatement pStemt = null;
        String tableSql = SQL + tableName;
        try {
            //获取主键
            ResultSet rsKeys=conn.getMetaData().getPrimaryKeys(conn.getCatalog().toUpperCase(),conn.getMetaData().getUserName().toUpperCase(),tableName.toUpperCase());
            String keyName="";
            while (rsKeys.next()) {
                keyName=rsKeys.getString("COLUMN_NAME");
                break;
            }
            pStemt = conn.prepareStatement(tableSql);
            //结果集元数据
            ResultSetMetaData rsmd = pStemt.getMetaData();
            //表列数
            int size = rsmd.getColumnCount();
            for (int i = 0; i < size; i++) {
                String columnName=rsmd.getColumnName(i + 1);
                boolean flag=false;
                if(columnName.equals(keyName)){
                    flag=true;
                }
                columnNames.add(new DbColumDetail(columnName,rsmd.getColumnTypeName(i + 1),"",flag) );
            }
            ResultSet rs = pStemt.executeQuery("show full columns from " + tableName);
            int i=0;
            while (rs.next()) {
                columnNames.get(i++).setColumRemark(rs.getString("Comment"));
            }


        } catch (SQLException e) {
            LOGGER.error("getColumnNames failure", e);
        } finally {
            if (pStemt != null) {
                try {
                    pStemt.close();
                    closeConnection(conn);
                } catch (SQLException e) {
                    LOGGER.error("getColumnNames close pstem and connection failure", e);
                }
            }
        }
        return columnNames;
    }
}
