package ${codeConfig.serverPackageName}.${codeConfig.moduleName}.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;


/**
* @author ${codeConfig.creatName}
* @date ${.now}
* ${codeTable.comment}表单提交类
*/
@Getter
@Setter
@ApiModel(value = "${codeTable.comment}表单提交类")
public class ${entityName?cap_first}From{
<#if codeTable.columnList??>
<#--循环生成变量-->
    <#list codeTable.columnList as column>
        <#if column.name != "createTime"
        && column.name != "updateTime"
        && column.name != "creatorId"
        && column.name != "updateId"
        && column.name != "isDelete"
        >
    @ApiModelProperty(value = "${column.columnComment!""}")
    <#if column.nullable && column.name != "id">
    @NotNull(message = "${column.columnComment!""} 不得为空")
    </#if>
    private ${column.type} ${column.name};

        </#if>
    </#list>
</#if>}
