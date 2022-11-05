package com.db;

import com.util.ToolUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * ToJavaTypeName
 * BIT¡¢ FLOAT¡¢CHAR¡¢TIMESTAMP¡¢OTHER¡¢ UNDEFINED¡¢TINYINT¡¢REAL¡¢VARCHAR¡¢BINARY¡¢BLOB¡¢ NVARCHAR¡¢SMALLINT¡¢DOUBLE¡¢LONGVARCHAR¡¢VARBINARY¡¢CLOB¡¢NCHAR¡¢INTEGER¡¢NUMERIC¡¢DATE¡¢LONGVARBINARY¡¢BOOLEAN ¡¢NCLOB¡¢BIGINT¡¢DECIMAL¡¢TIME¡¢NULL¡¢CURSOR
 */
public class DbToMybatisToJavaTypeName {
    static Logger logger = LoggerFactory.getLogger(DbToMybatisToJavaTypeName.class);
   public static void ToJavaTypeName(DbColumDetail dbColumDetail){
       String name=dbColumDetail.getColumType().toUpperCase();
       String mybatisType="";
       String javaType="";
       String javajavaPath="";
       switch (name){
           case "CHAR"://                                  java.lang.String
               mybatisType="CHAR";
               javaType="String";
               javajavaPath="java.lang.String";
               break;
           case "VARCHAR":                             // java.lang.String
               mybatisType="VARCHAR";
               javaType="String";
               javajavaPath="java.lang.String";
               break;
           case "LONGVARCHAR":                   // java.lang.String
               mybatisType="LONGVARCHAR";
               javaType="String";
               javajavaPath="java.lang.String";
               break;
           case "NUMERIC":                      // java.math.BigDecimal
               mybatisType="NUMERIC";
               javaType="BigDecimal";
               javajavaPath="java.math.BigDecimal";
               break;
           case "DECIMAL":                        // java.math.BigDecimal
               mybatisType="mybatisType";
               javaType="BigDecimal";
               javajavaPath="java.math.BigDecimal";
               break;
           case "BIT":                                     // java.lang.Boolean
               mybatisType="BIT";
               javaType="Boolean";
               javajavaPath="java.lang.Boolean";
               break;
           case "BOOLEAN":                          //java.lang.Boolean
               mybatisType="BOOLEAN";
               javaType="Boolean";
               javajavaPath="java.lang.Boolean";
               break;
           case "TINYINT":                                 // byte
               mybatisType="TINYINT";
               javaType="byte";
               javajavaPath=null;
               break;
           case "SMALLINT":                            //  java.lang.Short
               mybatisType="SMALLINT";
               javaType="Short";
               javajavaPath="java.lang.Short";
               break;
           case "INT":                              //  java.lang.Integer INT
               mybatisType="INTEGER";
               javaType="Integer";
               javajavaPath="java.lang.Integer";
               break;
           case "INTEGER":
               mybatisType="INTEGER";
               javaType="Integer";
               javajavaPath="java.lang.Integer";
               break;
           case "BIGINT":                                 //  java.lang.Long
               mybatisType="BIGINT";
               javaType="Long";
               javajavaPath="java.lang.Long";
               break;
           case "REAL":                                   //  java.lang.Float
               mybatisType="REAL";
               javaType="Float";
               javajavaPath="java.lang.Float";
               break;
           case "FLOAT":                                 // double
               mybatisType="FLOAT";
               javaType="Double";
               javajavaPath="java.lang.Double";
               break;
           case "DOUBLE":                              //double
               mybatisType="DOUBLE";
               javaType="Double";
               javajavaPath="java.lang.Double";
               break;
           case "BINARY":                              //byte[]
               mybatisType="BINARY";
               javaType="byte[]";
               javajavaPath=null;
               break;
           case "VARBINARY":                         //byte[]
               mybatisType="VARBINARY";
               javaType="byte[]";
               javajavaPath=null;
               break;
           case "LONGVARBINARY":               //byte[]
               mybatisType="LONGVARBINARY";
               javaType="byte[]";
               javajavaPath=null;
               break;
           case "DATE":                                 //java.util.Date
               mybatisType="DATE";
               javaType="Date";
               javajavaPath="java.util.Date";
               break;
           case "TIME":                               // java.util.Date
               mybatisType="TIME";
               javaType="Date";
               javajavaPath="java.util.Date";
               break;
           case "TIMESTAMP":                     //java.util.Date ª¡DATETIME
               mybatisType="TIMESTAMP";
               javaType="Date";
               javajavaPath="java.util.Date";
               break;
           case "DATETIME":                     //java.util.Date ª¡
               mybatisType="TIMESTAMP";
               javaType="Date";
               javajavaPath="java.util.Date";
               break;
           case "CLOB":                                 // Clob
               mybatisType="CLOB";
               javaType="byte[]";
               javajavaPath=null;
               break;
           case "LONGCLOB":                                 // Clob
               mybatisType="CLOB";
               javaType="byte[]";
               javajavaPath=null;
               break;
           case "BLOB":                                 //  Blob LONGBLOB
               mybatisType="BLOB";
               javaType="byte[]";
               javajavaPath=null;
               break;
           case "LONGBLOB":                                 //  Blob LONGBLOB
               mybatisType="BLOB";
               javaType="byte[]";
               javajavaPath=null;
               break;
           default :
               System.out.println("db_name_type£º"+ name);
               logger.info( "db_name_type£º{}",name);

       }
       dbColumDetail.setColumType(mybatisType);
       dbColumDetail.setJavaType(javaType);
       dbColumDetail.setJavaTypeImprot(javajavaPath);
   }

}
