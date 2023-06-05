package generator.utils;


import generator.constant.CodeColumn;
import generator.constant.CodeColumnType;
import generator.constant.TypeConvertEnum;
import generator.constant.DBType;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

/**
 * 表处理通用类
 */
public class TableHandlerUtil {

    private TableHandlerUtil() {

    }

    /**
     * 处理一遍字段,根据字段类型做合适的处理
     */
    public static void handlerFields(List<CodeColumn> fields, DBType dbType) {
        for (CodeColumn codeColumn : fields) {
            codeColumn.setName(NameUtil.getFieldHumpName(codeColumn.getColumnName()));
            codeColumn.setType(convertType(dbType, codeColumn.getColumnType()));
        }


        CodeColumn entity;
        for (int i = 0, le = fields.size(); i < le; i++) {
            entity = fields.get(i);

        }
    }

    /**
     * 处理字段名称
     */
    public static String getFieldName(String fieldName, String comment) {
        if (StringUtils.isNotBlank(comment)) {
            String[] nameAndComment = comment.split(",");
            return nameAndComment[0];
        }
        return NameUtil.getEntityHumpName(fieldName);
    }
    public static String convertType(String dataType) {
        return convertType(DBType.MYSQL,dataType);
    }
    /**
     * 转换类型
     */
    public static String convertType(DBType dbType,String dataType) {
        dataType = dataType.toUpperCase();
        String type = TypeConvertEnum.getTypeByDb(dbType, dataType);
        if (type == null) {
            return CodeColumnType.OBJECT.getType();
        }
        return type;
    }


}
