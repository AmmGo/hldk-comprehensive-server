package generator.utils;

import com.hldk.common.util.core.CollectionUtil;
import generator.config.CodeConfig;
import generator.constant.CodeColumn;
import generator.constant.CodeTable;
import generator.constant.DBType;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * MySql数据库的实现类
 *
 * @author JueYue
 * @date 2014年12月21日
 */
@Slf4j
public class ReadUtil {

    private static String TABLE_SQL = "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.TABLES WHERE TABLE_NAME = '%s' AND TABLE_SCHEMA = '%s'";

    private static String ALL_TABLE_SQL = "SELECT TABLE_NAME,TABLE_COMMENT FROM information_schema.TABLES WHERE TABLE_SCHEMA = '%s'";

    private static String FIELDS_SQL = "SELECT column_name as fieldName, data_type as fieldType, column_comment, numeric_precision, numeric_scale as scale, character_maximum_length as charmaxLength,is_nullable as nullable,ordinal_position as sort from information_schema.columns where table_name = '%s' and table_schema = '%s'";

    private static String SCHEMA_SQL = "SELECT SCHEMA_NAME FROM information_schema.SCHEMATA WHERE SCHEMA_NAME != 'information_schema' AND SCHEMA_NAME !=  'mysql'";


    /**
     * 读取数据库表格属性
     */
    public static CodeTable getCodeTable(CodeConfig codeConfig) {
        try {
            CodeTable codeTable = getCodeTable(codeConfig.getDatabaseName(), codeConfig.getTableName(), TABLE_SQL);
            List<CodeColumn> codeColumns = getCodeColumns(codeConfig.getDatabaseName(), codeConfig.getTableName(), FIELDS_SQL);
            CollectionUtil.sort(codeColumns, "sort");
            codeTable.setColumnList(codeColumns);
            TableHandlerUtil.handlerFields(codeTable.getColumnList(), DBType.MYSQL);
            return codeTable;
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException("获取表格数据发生异常");
        }
    }

    public static List<CodeTable> getAllTable(CodeConfig codeConfig) {
        try {
            return getAllTable(codeConfig.getDatabaseName(), ALL_TABLE_SQL);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException("获取表格数据发生异常");
        }
    }

    private static List<CodeColumn> getCodeColumns(String dbName, String tableName, String sql) throws Exception {
        List<CodeColumn> list = new ArrayList<>();
        Statement statement = null;
        try {
            ResultSet rs = ConnectionUtil.createStatement()
                    .executeQuery(String.format(sql, tableName, dbName));
            CodeColumn column;
            String pk = getPk(tableName);
            while (rs.next()) {
                column = new CodeColumn();
                column.setColumnComment(rs.getString("column_comment"));
                column.setColumnName(rs.getString("fieldName"));
                column.setColumnType(rs.getString("fieldType"));
                column.setSort(rs.getInt("sort"));
                column.setIsKey(StringUtils.equals(column.getColumnName(), pk) ? 1 : 0);
                String nullable = rs.getString("nullable");
                column.setNullable(StringUtils.equalsIgnoreCase("NO",nullable) ? true : false);
                System.out.println("字段名称:" + column.getColumnName() + "===>" + column.getName() + "|||字段类型" + column.getColumnType() + "===>" + column.getType());
                list.add(column);
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException("查询表是否存在发生异常", e);
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return list;
    }

    private static CodeTable getCodeTable(String dbName, String tableName, String sql) throws Exception {
        Statement statement = null;
        try {
            ResultSet rs = ConnectionUtil.createStatement().executeQuery(String.format(sql, tableName, dbName));
            String dbTableName = null;
            String comment = null;
            while (rs.next()) {
                dbTableName = rs.getString(1);
                comment = rs.getString(2);
            }
            if (StringUtils.isEmpty(dbTableName)) {
                throw new IllegalArgumentException("表不存在");
            } else {
                CodeTable entity = new CodeTable();
                entity.setTableName(dbTableName);
                entity.setComment(comment);
                return entity;
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException("查询表是否存在发生异常", e);
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
    }

    private static List<CodeTable> getAllTable(String dbName, String sql) throws Exception {
        Statement statement = null;
        List<CodeTable> list = new ArrayList<CodeTable>();
        try {
            ResultSet rs = ConnectionUtil.createStatement().executeQuery(String.format(sql, dbName));
            String dbTableName = null;
            String comment = null;
            while (rs.next()) {
                dbTableName = rs.getString(1);
                comment = rs.getString(2);
                if (StringUtils.isEmpty(dbTableName)) {
                    throw new IllegalArgumentException("表不存在");
                } else {
                    CodeTable entity = new CodeTable();
                    entity.setTableName(dbTableName);
                    list.add(entity);
                }
            }
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            throw new IllegalArgumentException("查询表是否存在发生异常", e);
        } finally {
            if (statement != null) {
                statement.close();
                statement = null;
            }
        }
        return list;
    }

    /**
     * 获取主键
     *
     * @param tableName
     * @return
     */
    private static String getPk(String tableName) {
        try {
            DatabaseMetaData dbmd = ConnectionUtil.createThisDatabaseMetaData();
            ResultSet pk = dbmd.getPrimaryKeys(null, null, tableName);
            String pkName = "";
            while (pk.next()) {
                System.out.println("数据库名称:" + pk.getObject(1) + "|||表名:" + tableName + "|||主键名称:" + pk.getObject(4));
                pkName = String.valueOf(pk.getObject(4));
            }
            return pkName;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
