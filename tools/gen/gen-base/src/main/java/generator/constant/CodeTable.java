package generator.constant;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

/**
 * 表类
 * @author Administrator
 */
@Getter
@Setter
public class CodeTable implements Serializable{
    private static final long serialVersionUID = 1L;
    //表名
    private String tableName;
    //表注释
    private String comment;
    //所有字段
    private List<CodeColumn> columnList;


}
