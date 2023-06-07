package com.hldk.emergency.modules.app.entity;

import java.util.Date;

import lombok.Data;
import javax.validation.constraints.*;
import com.hldk.common.core.annotation.*;
import com.baomidou.mybatisplus.annotation.*;
import com.fasterxml.jackson.annotation.JsonIgnore;


/**
* @author yjl
* @date 2023-5-31 10:35:34
* 实体类
*/
@Data
@TableName(value = "life_bill")
public class Bill{
    /****/
    @TableId(type =  IdType.AUTO)
    @NotNull(groups = {Update.class})
    private Integer id;

    /**消费名称**/
    @TableField
    private String name;

    /**消费金额**/
    @TableField
    private String money;

    /**消费类型**/
    @TableField
    private String type;

    /**消费类型名称**/
    @TableField
    private String typeName;

    /**是否是消费或者收入0消费1收入**/
    @TableField
    private Integer pay;

    /**备注**/
    @TableField
    private String memo;

    /**余额**/
    @TableField
    private String balance;

    /**消费时间**/
    @TableField
    private Date time;

}
