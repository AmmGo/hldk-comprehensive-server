package com.hldk.emergency.modules.app.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;


/**
 * @author yjl
 * @date 2023-5-31 10:35:34
 * 实体类
 */
@Data
@TableName(value = "life_bill")
public class BillMonthQueryAmount {


    @TableField
    private String amount;

    @TableField
    private String date;

}
