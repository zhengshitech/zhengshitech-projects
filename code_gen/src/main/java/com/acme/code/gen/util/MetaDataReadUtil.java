package com.acme.code.gen.util;

import com.acme.code.gen.entity.ColumnConstant;
import com.acme.code.gen.entity.ColumnDesc;
import com.acme.code.gen.entity.TableDesc;
import com.acme.code.gen.exception.GenerationException;
import com.acme.code.gen.util.DataBaseUtil;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

import static com.acme.code.gen.entity.ColumnConstant.*;
import static com.acme.code.gen.entity.ColumnConstant.TYPE_NAME;
import static com.acme.code.gen.entity.TableConstant.REMARKS;
import static com.acme.code.gen.entity.TableConstant.TABLE_NAME;
import static com.acme.code.gen.entity.TableConstant.*;
import static com.acme.code.gen.util.JavaTypeUtil.getType;
import static com.acme.code.gen.util.StringKitUtil.lowerCaseFirstLetter;
import static com.acme.code.gen.util.StringKitUtil.replaceUnderLineAndUpperCase;

/**
 * 读取数据库表，表中的列基础信息
 *
 * @author H
 */
public class MetaDataReadUtil {

    private MetaDataReadUtil() {

    }


    public static Map<String, TableDesc> readTablesInfo() {
        Connection conn = DataBaseUtil.getConnection();
        try {
            assert conn != null;
            DatabaseMetaData databaseMetaData = conn.getMetaData();
            String dbSchema = conn.getSchema();
            String dbCatalog = conn.getCatalog();
            Map<String, TableDesc> tableDescMap = readTablesInfo(databaseMetaData, dbSchema, dbCatalog);
            for (Map.Entry<String, TableDesc> tableDescEntry : tableDescMap.entrySet()) {
                setTableColumnsInfo(databaseMetaData, dbSchema, dbCatalog, tableDescEntry.getKey(), tableDescEntry.getValue());
            }

            return tableDescMap;
        } catch (SQLException e) {
            throw new GenerationException(e.getMessage(), e.getCause());
        } finally {
            DataBaseUtil.closeConnectioin(conn);
        }
    }

    private static Map<String, TableDesc> readTablesInfo(DatabaseMetaData databaseMetaData, String dbSchema, String dbCatalog) throws SQLException {

        Map<String, TableDesc> metaDataMap = new ConcurrentHashMap<>(16);
        ResultSet rs = databaseMetaData.getTables(dbCatalog, dbSchema, TABLE_NAME_PATTERN, TABLE_TYPES);
        while (rs.next()) {
            TableDesc table = getTableInfo(rs, dbCatalog, dbSchema);
            metaDataMap.put(table.getName(), table);
        }
        return metaDataMap;
    }

    private static TableDesc getTableInfo(ResultSet rs, String dbCatalog, String dbSchema) throws SQLException {
        String tableName = rs.getString(TABLE_NAME);
        TableDesc desc = new TableDesc(tableName, rs.getString(REMARKS));
        desc.setSchem(dbSchema);
        desc.setCat(dbCatalog);
        desc.setType(rs.getString(TABLE_TYPE));
        return desc;
    }


    private static void setTableColumnsInfo(DatabaseMetaData databaseMetaData, String dbSchema, String dbCatalog, String tableName, TableDesc table) throws SQLException {

        //主键列
        Set<ColumnDesc> primaryKeys = getPrimaryKeys(databaseMetaData, dbSchema, dbCatalog, tableName);
        table.getPrmaryKeys().addAll(primaryKeys);
        //普通列
        Set<ColumnDesc> allColumns = getColumns(databaseMetaData, dbSchema, dbCatalog, tableName);
        table.getColumns().addAll(allColumns);
    }

    private static Set<ColumnDesc> getPrimaryKeys(DatabaseMetaData databaseMetaData, String dbSchema, String dbCatalog, String tableName) throws SQLException {
        ResultSet rs = databaseMetaData.getPrimaryKeys(dbCatalog, dbSchema, tableName);
        return getColumnInfos(dbSchema, dbCatalog, rs, true);
    }

    private static Set<ColumnDesc> getColumnInfos(String dbSchema, String dbCatalog, ResultSet rs, boolean isPrimaryKey) throws SQLException {
        List<ColumnDesc> columns = new ArrayList<>(16);
        if (rs != null) {
            while (rs.next()) {
                columns.add(getColumnInfo(rs, dbCatalog, dbSchema, isPrimaryKey));
            }
            rs.close();
        }
        //将字段按照数据库进行排序
        Collections.sort(columns);
        Set<ColumnDesc> sortedColumns = new LinkedHashSet<>(16);
        sortedColumns.addAll(columns);
        return sortedColumns;
    }

    private static Set<ColumnDesc> getColumns(DatabaseMetaData databaseMetaData, String dbSchema, String dbCatalog, String tableName) throws SQLException {
        ResultSet rs = databaseMetaData.getColumns(dbCatalog, dbSchema, tableName, COLUMN_TABLE_PATTERNS);
        return getColumnInfos(dbSchema, dbCatalog, rs, false);
    }

    private static ColumnDesc getColumnInfo(ResultSet rs, String dbCatalog, String dbSchema, boolean isPrimaryKey) throws SQLException {
        ColumnDesc column = new ColumnDesc();
        column.setPrimaryKey(isPrimaryKey);
        column.setTableCat(dbCatalog);
        column.setTableSchem(dbSchema);
        column.setColumnName(rs.getString(COLUMN_NAME));
        if (isPrimaryKey) {
            column.setKeySeq(rs.getString(KEY_SEQ));
            column.setPkName(rs.getString(PK_NAME));
        } else {
            column.setTypeName(rs.getString(TYPE_NAME));
            column.setDataType(rs.getInt(DATA_TYPE));
            column.setColumnSize(rs.getInt(COLUMN_SIZE));
            column.setNullabe(rs.getBoolean(NULLABLE));
            column.setRemarks(rs.getString(ColumnConstant.REMARKS));
            column.setColunmDef(rs.getString(COLUMN_DEF));
            column.setSqlDataType(rs.getInt(SQL_DATA_TYPE));
            column.setSqlDatetimeSub(rs.getString(SQL_DATETIME_SUB));
            column.setCharOctetLength(rs.getInt(CHAR_OCTET_LENGTH));
            column.setOrdinalPosition(rs.getInt(ORDINAL_POSITION));
            column.setIsNullable(rs.getString(IS_NULLABLE));
            column.setScopeCatalog(rs.getString(SCOPE_CATALOG));
            column.setScopeSchema(rs.getString(SCOPE_SCHEMA));
            column.setScopeTable(rs.getString(SCOPE_TABLE));
            column.setSourceDataType(rs.getString(SOURCE_DATA_TYPE));
            column.setAutoIncrement(rs.getString(IS_AUTOINCREMENT));
            column.setGeneratedColumn(rs.getString(IS_GENERATEDCOLUMN));
            //辅助生成java代码使用
            column.setJavaFieldName(lowerCaseFirstLetter(replaceUnderLineAndUpperCase(column.getColumnName())));
            column.setJavaFieldType(getType(column.getDataType(),column.getColumnSize(),column.getDecimalDigits()));
        }
        return column;
    }
}
