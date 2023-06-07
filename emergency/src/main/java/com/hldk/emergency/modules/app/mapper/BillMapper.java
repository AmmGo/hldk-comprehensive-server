package com.hldk.emergency.modules.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hldk.emergency.modules.app.entity.Bill;
import com.hldk.emergency.modules.app.entity.BillMonthQueryAmount;
import com.hldk.emergency.modules.app.entity.BillTypeQueryAmount;
import com.hldk.emergency.utils.DoMainMap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author yjl
 * @date 2023-5-31 10:35:34
 * 数据访问层
 */
@Mapper
@Repository
public interface BillMapper extends BaseMapper<Bill> {

    /**
     * 分页查询
     *
     * @param page
     * @param bill
     * @return
     */
    Page<Bill> findPageList(@Param("page") Page page, @Param("e") Bill bill);


    Bill getByIdType(@Param("id") Integer id);


    String getLastBalance();

    Bill getLastBill();

    DoMainMap getCountAmount();

    List<BillMonthQueryAmount> getBillMonthQueryAmount(@Param("month") String month);

    List<BillTypeQueryAmount> getBillTypeQueryAmount();

}