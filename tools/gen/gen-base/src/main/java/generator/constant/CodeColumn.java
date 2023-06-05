package generator.constant;

import generator.utils.NameUtil;
import generator.utils.TableHandlerUtil;
import lombok.Getter;
import lombok.Setter;

/**
 * 字段类
 * @author Administrator
 */
@Getter
@Setter
public class CodeColumn {
    //是否主键 1是0否
    private Integer isKey;

    //数据库字段名称
    private String columnName;
    //数据库字段类型
    private String columnType;
    //类型
    private String type;
    //名称
    private String name;
    //注释
    private String columnComment;
    //排序
    private Integer sort;
    //是否必填 1是0否
    private Boolean nullable;

    public void setColumnName(String columnName) {
        this.columnName = columnName;
        this.name =  NameUtil.getFieldHumpName(columnName);
    }

    public void setColumnType(String columnType) {
        this.columnType = columnType;
        this.type =  TableHandlerUtil.convertType(columnType);
    }
}
