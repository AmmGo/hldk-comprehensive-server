package generator.apifox;

import lombok.Data;

/**
 * @author Administrator on 2022/8/15.
 * @version 1.0
 */
@Data
public class Parameter {
    //是否必填
    private Boolean required = false;
    //参数名称
    private String name;
    //说明
    private String description ="根据查询";
    //参数类型
    private String type = "string";
    //示例值
    private String sampleValue = "aaa";
}
