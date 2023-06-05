package ${codeConfig.serverPackageName}.${codeConfig.moduleName}.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.hldk.common.core.annotation.TableQw;
import com.hldk.common.core.enums.TableQwE;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;


/**
* @author ${codeConfig.creatName}
* @date ${.now}
* ${codeTable.comment}查询条件层
*/
@Getter
@Setter
@ApiModel(value = "${codeTable.comment}查询条件层")
public class ${entityName?cap_first}Query{
<#if codeTable.columnList??>
<#--循环生成变量--><#list codeTable.columnList as column>
        <#if column.name != "createTime"
        && column.name != "updateTime"
        && column.name != "creatorId"
        && column.name != "updateId"
        && column.name != "isDelete"
        >
    @ApiModelProperty(value = "${column.columnComment!""} 查询")
    @TableQw(type = TableQwE.EQ,value = "${column.columnName}")
    private ${column.type} ${column.name};

        </#if>
    </#list>
</#if>}
