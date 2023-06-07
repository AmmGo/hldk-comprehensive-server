package com.hldk.emergency.modules.app.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hldk.emergency.modules.app.entity.Bill;
import com.hldk.emergency.modules.app.entity.BillMonthQueryAmount;
import com.hldk.emergency.modules.app.entity.BillTypeQueryAmount;
import com.hldk.emergency.utils.DoMainMap;

import java.util.List;

/**
 * @author yjl
 * @date 2023-5-31 10:35:34
 * 业务逻辑层
 */
public interface IBillService extends IService<Bill> {

    /**
     * 添加附加信息
     *
     * @param bill
     */
    void addInfo(Bill bill);

    /**
     * 添加附加信息
     *
     * @param list
     */
    void addInfo(List<Bill> list);

    /**
     * 添加附加信息
     *
     * @param pageList
     */
    void addInfo(Page<Bill> pageList);

    /**
     * 分页查询
     *
     * @param bill
     * @param page
     * @return
     */
    Page<Bill> findPageList(Page page, Bill bill);


    Bill getByIdType(Integer id);

    String getLastBalance();

    Bill getLastBill();

    DoMainMap getBillCountAmount();

    List<BillMonthQueryAmount> getBillMonthQueryAmount(String month);

    List<BillTypeQueryAmount> getBillTypeQueryAmount();

    List<Bill> getDayConsumption(String day);

}
