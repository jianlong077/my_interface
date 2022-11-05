//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.buildmodle;

import com.db.DataSourceConfig;
import com.util.ToolUtil;
import java.io.Serializable;
import java.util.Properties;

public class BaseModle implements Serializable {
    private String projectName;
    private String proCategory;
    private String proModle;
    private String entityName;
    private String baseJavaPath;
    private String baseJavaPathOut;
    private String baseXmlPathOut;
    private String entityUlrName;
    private String dbTableName;
    private Control control;
    private Domain domain;
    private Entity entity;
    private EntityVO entityVO;
    private Mapper mapper;
    private MapperAdditionXml mapperAdditionXml;
    private MapperXml mapperXml;
    private Service service;
    private ServiceImport serviceImport;
    private Boolean entityIfToApi;
    private Boolean ifAllCover;
    private String out_java_base = "\\src\\main\\java\\";
    private String out_xml_base = "\\src\\main\\resources\\mapper\\";
    private DataSourceConfig b;

    public BaseModle() {
        Properties p = ToolUtil.getProperties("generator.properties");
        String user_dir = ToolUtil.getParentBeforeTow() + "\\";
        this.projectName=p.getProperty("projectName");
        this.proCategory=p.getProperty("proCategory");
        this.proModle=p.getProperty("proModle");
        this.entityUlrName=ToolUtil.FirstLowerCase(p.getProperty("entityName"));
        this.baseJavaPath = p.getProperty("baseJavaPath") + "." + p.getProperty("proCategory") + "." + p.getProperty("proModle");
        this.baseJavaPathOut = user_dir + p.getProperty("projectName") + this.out_java_base + this.baseJavaPath.replace(".", "\\");
        this.baseXmlPathOut = user_dir + p.getProperty("projectName") + this.out_xml_base + p.getProperty("proCategory") + "\\" + p.getProperty("proModle");
        this.entityName = p.getProperty("entityName");
        this.dbTableName = p.getProperty("dbTableName");
        this.entityIfToApi=Boolean.valueOf(p.getProperty("entityIfToApi")) ;
        this.ifAllCover=Boolean.valueOf(p.getProperty("ifAllCover")) ;
        DataSourceConfig b = new DataSourceConfig(p.getProperty("dbDriver"), p.getProperty("dbUrl"), p.getProperty("dbUserName"), p.getProperty("dbPassword"));
        this.control = new Control(this);
        this.domain = new Domain(this);
        this.entity = new Entity(this, b.getColumnNames(this.dbTableName));
        this.entityVO = new EntityVO(this);
        this.mapper = new Mapper(this);
        this.mapperAdditionXml = new MapperAdditionXml(this);
        this.mapperXml = new MapperXml(this);
        this.service = new Service(this);
        this.serviceImport = new ServiceImport(this);
    }

    public void outJava() {
        this.control.outJava(this);
        this.domain.outJava(this);
        this.entity.outJava(this);
        this.entityVO.outJava(this);
        this.mapper.outJava(this);
        this.mapperAdditionXml.outJava(this);
        this.mapperXml.outJava(this);
        this.service.outJava(this);
        this.serviceImport.outJava(this);
    }

    public BaseModle buildDB(String DRIVER, String URL, String USERNAME, String PASSWORD) {
        this.b = this.b = new DataSourceConfig(DRIVER, URL, USERNAME, PASSWORD);
        return this;
    }

    public String getBaseJavaPath() {
        return this.baseJavaPath;
    }

    public void setBaseJavaPath(String baseJavaPath) {
        this.baseJavaPath = baseJavaPath;
    }

    public String getBaseJavaPathOut() {
        return this.baseJavaPathOut;
    }

    public void setBaseJavaPathOut(String baseJavaPathOut) {
        this.baseJavaPathOut = baseJavaPathOut;
    }

    public String getBaseXmlPathOut() {
        return this.baseXmlPathOut;
    }

    public void setBaseXmlPathOut(String baseXmlPathOut) {
        this.baseXmlPathOut = baseXmlPathOut;
    }

    public DataSourceConfig getB() {
        return this.b;
    }

    public void setB(DataSourceConfig b) {
        this.b = b;
    }

    public String getEntityName() {
        return this.entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public Control getControl() {
        return this.control;
    }

    public void setControl(Control control) {
        this.control = control;
    }

    public Domain getDomain() {
        return this.domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public Entity getEntity() {
        return this.entity;
    }

    public void setEntity(Entity entity) {
        this.entity = entity;
    }

    public EntityVO getEntityVO() {
        return this.entityVO;
    }

    public void setEntityVO(EntityVO entityVO) {
        this.entityVO = entityVO;
    }

    public Mapper getMapper() {
        return this.mapper;
    }

    public void setMapper(Mapper mapper) {
        this.mapper = mapper;
    }

    public MapperAdditionXml getMapperAdditionXml() {
        return this.mapperAdditionXml;
    }

    public void setMapperAdditionXml(MapperAdditionXml mapperAdditionXml) {
        this.mapperAdditionXml = mapperAdditionXml;
    }

    public MapperXml getMapperXml() {
        return this.mapperXml;
    }

    public void setMapperXml(MapperXml mapperXml) {
        this.mapperXml = mapperXml;
    }

    public Service getService() {
        return this.service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public ServiceImport getServiceImport() {
        return this.serviceImport;
    }

    public void setServiceImport(ServiceImport serviceImport) {
        this.serviceImport = serviceImport;
    }

    public String getDbTableName() {
        return this.dbTableName;
    }

    public void setDbTableName(String dbTableName) {
        this.dbTableName = dbTableName;
    }

    public Boolean getEntityIfToApi() {
        return entityIfToApi;
    }

    public void setEntityIfToApi(Boolean entityIfToApi) {
        this.entityIfToApi = entityIfToApi;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProCategory() {
        return proCategory;
    }

    public void setProCategory(String proCategory) {
        this.proCategory = proCategory;
    }

    public String getProModle() {
        return proModle;
    }

    public void setProModle(String proModle) {
        this.proModle = proModle;
    }

    public String getEntityUlrName() {
        return entityUlrName;
    }

    public void setEntityUlrName(String entityUlrName) {
        this.entityUlrName = entityUlrName;
    }

    public Boolean getIfAllCover() {
        return ifAllCover;
    }

    public void setIfAllCover(Boolean ifAllCover) {
        this.ifAllCover = ifAllCover;
    }
}
