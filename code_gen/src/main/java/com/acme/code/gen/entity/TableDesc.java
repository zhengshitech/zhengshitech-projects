package com.acme.code.gen.entity;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 数据库表描述
 *
 * @author H
 */
public class TableDesc {

    private String cat;
    private String schem;
    private String name;
    private String type;
    private String remarks;


    private String typeCat;
    private String typeSchem;
    private String typeName;
    private String selfReferencingColName;
    private String refGeneration;

    private String tableRemarks;

    private Set<ColumnDesc> columns = new LinkedHashSet<>(16);
    private Set<ColumnDesc> prmaryKeys = new LinkedHashSet<>(1);

    public TableDesc() {
    }

    public TableDesc(String name, String remarks) {
        this.name = name;
        this.remarks = remarks;
    }

    public String getCat() {
        return cat;
    }

    public void setCat(String cat) {
        this.cat = cat;
    }

    public String getSchem() {
        return schem;
    }

    public void setSchem(String schem) {
        this.schem = schem;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getTypeCat() {
        return typeCat;
    }

    public void setTypeCat(String typeCat) {
        this.typeCat = typeCat;
    }

    public String getTypeSchem() {
        return typeSchem;
    }

    public void setTypeSchem(String typeSchem) {
        this.typeSchem = typeSchem;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getSelfReferencingColName() {
        return selfReferencingColName;
    }

    public void setSelfReferencingColName(String selfReferencingColName) {
        this.selfReferencingColName = selfReferencingColName;
    }

    public String getRefGeneration() {
        return refGeneration;
    }

    public void setRefGeneration(String refGeneration) {
        this.refGeneration = refGeneration;
    }

    public String getTableRemarks() {
        return tableRemarks;
    }

    public void setTableRemarks(String tableRemarks) {
        this.tableRemarks = tableRemarks;
    }

    public Set<ColumnDesc> getColumns() {
        return columns;
    }

    public void setColumns(Set<ColumnDesc> columns) {
        this.columns = columns;
    }

    public Set<ColumnDesc> getPrmaryKeys() {
        return prmaryKeys;
    }

    public void setPrmaryKeys(Set<ColumnDesc> prmaryKeys) {
        this.prmaryKeys = prmaryKeys;
    }
}
