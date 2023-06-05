package ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixConstant};

/**
* @author ${codeConfig.creatName}
* @date ${.now}
* ${codeTable.comment}常量类
*/
public class ${entityName?cap_first+codeConfig.suffixConstant?cap_first} {

<#if codeTable.columnList??>
<#--循环生成变量-->
<#list codeTable.columnList as column>
    /**${column.columnComment!""}**/
    public static final String ${column.columnName?upper_case} = "${column.columnName}";

</#list>
</#if>
}