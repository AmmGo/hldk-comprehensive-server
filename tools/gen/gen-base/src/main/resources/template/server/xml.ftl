<!DOCTYPE mapper
        PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixDao?lower_case}.${entityName?cap_first+codeConfig.suffixDao?cap_first}">
    <resultMap id="${entityName?uncap_first}Map" type="${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixEntity?lower_case}.${entityName?cap_first}">
        <#if codeTable.columnList??>
        <#--循环生成变量-->
            <#list codeTable.columnList as column>
        <result column="${column.columnName}" property="${column.name}"/>
            </#list>
        </#if>
    </resultMap>
    <sql id="allColumn">
        <#if codeTable.columnList??><#list codeTable.columnList as column>a.${column.columnName} as `${column.columnName}`<#if column_has_next>,</#if></#list></#if>
    </sql>

    <sql id="tableName">
        ${codeTable.tableName} a
    </sql>

    <sql id="where">
        <if test="null!=e">
            <#if codeTable.columnList??>
            <#--循环生成变量-->
            <#list codeTable.columnList as column>
            <#if column.name != "isDelete">
            <#if column.type=="String">
            <#if column.name == "name">
            <if test="e.${column.name} != null and e.${column.name} != ''">
                AND a.${column.columnName} like concat('%',${"#"+"{e."+column.name+"}"},'%')
            </if>
            <#else>
            <if test="e.${column.name} != null and e.${column.name} != ''">
                AND a.${column.columnName} = ${"#"+"{e."+column.name+"}"}
            </if>
            </#if>
            <#else>
            <if test="e.${column.name} != null">
                AND a.${column.columnName} = ${"#"+"{e."+column.name+"}"}
            </if>
            </#if>
            </#if>
            </#list>
            <#list codeTable.columnList as column><#if column.name == "isDelete">AND a.is_delete = 0</#if></#list>
            </#if>
        </if>
    </sql>


    <select id="findPageList" resultType="${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixEntity?lower_case}.${entityName?cap_first}">
        SELECT <include refid="allColumn"></include>
        FROM <include refid="tableName"></include>
        <where>
            <include refid="where"></include>
        </where>
        ORDER BY a.id desc
    </select>



</mapper>

