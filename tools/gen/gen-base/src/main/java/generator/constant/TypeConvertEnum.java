package generator.constant;

/**
 * 数据类型转换
 *
 * @author by jueyue on 18-6-12.
 */
public enum TypeConvertEnum {


    ORACLE_BLOB(DBType.ORACLE, "BLOB", CodeColumnType.BYTE_ARR),
    ORACLE_CHAR(DBType.ORACLE, "CHAR", CodeColumnType.STRING),
    ORACLE_CLOB(DBType.ORACLE, "CLOB", CodeColumnType.STRING),
    ORACLE_DATE(DBType.ORACLE, "DATE", CodeColumnType.DATE),
    ORACLE_NUMBER(DBType.ORACLE, "NUMBER", CodeColumnType.BIG_DECIMAL),
    ORACLE_LONG(DBType.ORACLE, "LONG", CodeColumnType.STRING),
    ORACLE_SMALLINT(DBType.ORACLE, "SMALLINT", CodeColumnType.INTEGER),
    ORACLE_TIMESTAMP(DBType.ORACLE, "TIMESTAMP", CodeColumnType.DATE),
    ORACLE_RAW(DBType.ORACLE, "RAW", CodeColumnType.BYTE_ARR),
    ORACLE_VARCHAR2(DBType.ORACLE, "VARCHAR2", CodeColumnType.STRING),


    //----------------------------------------------------------------------
    SQLSERVER_TIMESTAMP(DBType.SQLSERVER, "TIMESTAMP", CodeColumnType.DATE),
    SQLSERVER_BIT(DBType.SQLSERVER, "BIT", CodeColumnType.BOOLEAN),
    SQLSERVER_CHAR(DBType.SQLSERVER, "CHAR", CodeColumnType.STRING),
    SQLSERVER_NCHAR(DBType.SQLSERVER, "NCHAR", CodeColumnType.STRING),
    SQLSERVER_DATETIME(DBType.SQLSERVER, "DATETIME", CodeColumnType.DATE),
    SQLSERVER_MONEY(DBType.SQLSERVER, "MONEY", CodeColumnType.BIG_DECIMAL),
    SQLSERVER_SMALLMONEY(DBType.SQLSERVER, "SMALLMONEY", CodeColumnType.BIG_DECIMAL),
    SQLSERVER_DECIMAL(DBType.SQLSERVER, "DECIMAL", CodeColumnType.BIG_DECIMAL),
    SQLSERVER_FLOAT(DBType.SQLSERVER, "FLOAT", CodeColumnType.DOUBLE),
    SQLSERVER_INT(DBType.SQLSERVER, "INT", CodeColumnType.INTEGER),
    SQLSERVER_IMAGE(DBType.SQLSERVER, "IMAGE", CodeColumnType.BYTE_ARR),
    SQLSERVER_TEXT(DBType.SQLSERVER, "TEXT", CodeColumnType.BYTE_ARR),
    SQLSERVER_BTEXT(DBType.SQLSERVER, "NTEXT", CodeColumnType.BYTE_ARR),
    SQLSERVER_XML(DBType.SQLSERVER, "XML", CodeColumnType.BYTE_ARR),
    SQLSERVER_NUMERIC(DBType.SQLSERVER, "NUMERIC", CodeColumnType.BIG_DECIMAL),
    SQLSERVER_REAL(DBType.SQLSERVER, "REAL", CodeColumnType.FLOAT),
    SQLSERVER_SMALLINT(DBType.SQLSERVER, "SMALLINT", CodeColumnType.SHORT),
    SQLSERVER_SMALL_DATETIME(DBType.SQLSERVER, "SMALLDATETIME", CodeColumnType.DATE),
    SQLSERVER_TINYINT(DBType.SQLSERVER, "TINYINT", CodeColumnType.BYTE),
    SQLSERVER_NVARCHAR(DBType.SQLSERVER, "NVARCHAR", CodeColumnType.STRING),
    SQLSERVER_VARBINARY(DBType.SQLSERVER, "VARBINARY", CodeColumnType.BYTE_ARR),
    SQLSERVER_VARCHAR(DBType.SQLSERVER, "VARCHAR", CodeColumnType.STRING),

    //---------------------------------------------------------------------
    DB2_BIGINT(DBType.DB2, "BIGINT", CodeColumnType.LONG),
    DB2_BLOB(DBType.DB2, "BLOB", CodeColumnType.BYTE_ARR),
    DB2_CHARACTER(DBType.DB2, "CHARACTER", CodeColumnType.STRING),
    DB2_GRAPHIC(DBType.DB2, "GRAPHIC", CodeColumnType.STRING),
    DB2_CLOB(DBType.DB2, "CLOB", CodeColumnType.STRING),
    DB2_DATE(DBType.DB2, "DATE", CodeColumnType.DATE),
    DB2_DECIMAL(DBType.DB2, "DECIMAL", CodeColumnType.BIG_DECIMAL),
    DB2_DOUBLE(DBType.DB2, "DOUBLE", CodeColumnType.DOUBLE),
    DB2_INTEGER(DBType.DB2, "INTEGER", CodeColumnType.INTEGER),
    DB2_LONGVARGRAPHIC(DBType.DB2, "LONGVARGRAPHIC", CodeColumnType.BYTE_ARR),
    DB2_LONGVARCHAR(DBType.DB2, "LONGVARCHAR", CodeColumnType.BYTE_ARR),
    DB2_REAL(DBType.DB2, "REAL", CodeColumnType.LONG),
    DB2_SMALLINT(DBType.DB2, "SMALLINT", CodeColumnType.SHORT),
    DB2_TIME(DBType.DB2, "TIME", CodeColumnType.DATE),
    DB2_TIMESTAMP(DBType.DB2, "TIMESTAMP", CodeColumnType.DATE),
    DB2_VARGRAPHIC(DBType.DB2, "VARGRAPHIC", CodeColumnType.STRING),
    DB2_VARCHAR(DBType.DB2, "VARCHAR", CodeColumnType.STRING),

    //------------------------------------------------------------
    MYSQL_BIGINT(DBType.MYSQL, "BIGINT", CodeColumnType.LONG),
    MYSQL_TINYBLOB(DBType.MYSQL, "TINYBLOB", CodeColumnType.BYTE_ARR),
    MYSQL_BIT(DBType.MYSQL, "BIT", CodeColumnType.BOOLEAN),
    MYSQL_ENUM(DBType.MYSQL, "ENUM", CodeColumnType.STRING),
    MYSQL_SET(DBType.MYSQL, "SET", CodeColumnType.STRING),
    MYSQL_CHAR(DBType.MYSQL, "CHAR", CodeColumnType.STRING),
    MYSQL_DATE(DBType.MYSQL, "DATE", CodeColumnType.DATE),
    MYSQL_YEAR(DBType.MYSQL, "YEAR", CodeColumnType.DATE),
    MYSQL_DECIMAL(DBType.MYSQL, "DECIMAL", CodeColumnType.BIG_DECIMAL),
    MYSQL_NUMERIC(DBType.MYSQL, "NUMERIC", CodeColumnType.BIG_DECIMAL),
    MYSQL_DOUBLE(DBType.MYSQL, "DOUBLE", CodeColumnType.DOUBLE),
    MYSQL_REAL(DBType.MYSQL, "REAL", CodeColumnType.DOUBLE),
    MYSQL_MEDIUMINT(DBType.MYSQL, "MEDIUMINT", CodeColumnType.INTEGER),
    MYSQL_BLOB(DBType.MYSQL, "BLOB", CodeColumnType.BYTE_ARR),
    MYSQL_MEDIUMBLOB(DBType.MYSQL, "MEDIUMBLOB", CodeColumnType.BYTE_ARR),
    MYSQL_LONGBLOB(DBType.MYSQL, "LONGBLOB", CodeColumnType.BYTE_ARR),
    MYSQL_FLOAT(DBType.MYSQL, "FLOAT", CodeColumnType.FLOAT),
    MYSQL_INT(DBType.MYSQL, "INT", CodeColumnType.INTEGER),
    MYSQL_SMALLINT(DBType.MYSQL, "SMALLINT", CodeColumnType.SHORT),
    MYSQL_TIME(DBType.MYSQL, "TIME", CodeColumnType.DATE),
    MYSQL_TIMESTAMP(DBType.MYSQL, "TIMESTAMP", CodeColumnType.DATE),
    MYSQL_DATETIME(DBType.MYSQL, "DATETIME", CodeColumnType.DATE),
    MYSQL_TINYINT(DBType.MYSQL, "TINYINT", CodeColumnType.INTEGER),
    MYSQL_VARBINARY(DBType.MYSQL, "VARBINARY", CodeColumnType.BYTE_ARR),
    MYSQL_BINARY(DBType.MYSQL, "BINARY", CodeColumnType.BYTE_ARR),
    MYSQL_VARCHAR(DBType.MYSQL, "VARCHAR", CodeColumnType.STRING),
    MYSQL_TINYTEXT(DBType.MYSQL, "TINYTEXT", CodeColumnType.STRING),
    MYSQL_TEXT(DBType.MYSQL, "TEXT", CodeColumnType.STRING),
    MYSQL_LONGTEXT(DBType.MYSQL, "LONGTEXT", CodeColumnType.STRING)
    ;

    private DBType db;
    private String dbType;
    private CodeColumnType type;

    TypeConvertEnum(DBType db, String dbType, CodeColumnType type) {
        this.db = db;
        this.dbType = dbType;
        this.type = type;
    }

    public static String getTypeByDb(DBType db, String dbType) {
        TypeConvertEnum[] types = TypeConvertEnum.values();
        for (int i = 0; i < types.length; i++) {
            if (types[i].db.equals(db) && types[i].dbType.equalsIgnoreCase(dbType)) {
                return types[i].type.getType();
            }
        }
        return null;
    }

    public DBType getDb() {
        return db;
    }

    public String getDbType() {
        return dbType;
    }

    public CodeColumnType getType() {
        return type;
    }

}
