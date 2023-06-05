package ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixEntity?lower_case};

import java.util.Date;

import lombok.Data;
import javax.validation.constraints.*;
import com.hldk.common.core.annotation.*;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
* @author ${codeConfig.creatName}
* @date ${.now}
* ${codeTable.comment}实体类
*/
@Data
@TableName(value = "${codeTable.tableName!""}")
public class ${entityName?cap_first}{
<#if codeTable.columnList??>
<#--循环生成变量-->
<#list codeTable.columnList as column>
    /**${column.columnComment}**/
    <#if column.isKey == 1>
    @TableId(type =  IdType.AUTO)
    @NotNull(groups = {Update.class})
    <#else>
    <#if column.name == "createTime">
    @TableField(fill = FieldFill.INSERT)
    <#elseif column.name == "updateTime">
    @TableField(fill = FieldFill.INSERT_UPDATE)
    <#elseif column.name == "enterpriseId">
    @TableField(fill = FieldFill.INSERT)
    <#elseif column.name == "creatorId">
    @TableField(fill = FieldFill.INSERT)
    <#elseif column.name == "updateId">
    @TableField(fill = FieldFill.INSERT_UPDATE)
    <#elseif column.name == "isDelete">
    @TableField
    @TableLogic
    @JsonIgnore
    <#else>
    @TableField
    </#if>
    </#if>
    <#if column.nullable && column.isKey != 1 >
    <#if column.type == "String">
    @NotBlank(groups = {Insert.class, Update.class},message= "${column.columnComment}不得为空")
    <#else>
    @NotNull(groups = {Insert.class, Update.class},message= "${column.columnComment}不得为空")
    </#if>
    </#if>
    private ${column.type} ${column.name};

</#list>
</#if>}
