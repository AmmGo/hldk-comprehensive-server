package com.hldk.emergency.modules.app.service.impl;

import com.hldk.emergency.modules.app.mapper.BillMapper;
import com.hldk.emergency.modules.app.entity.Bill;
import com.hldk.emergency.modules.app.service.IBillService;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author yjl
 * @date 2023-5-31 10:35:34
 *  业务逻辑层
 */
@Service
public class BillService extends ServiceImpl<BillMapper,Bill> implements IBillService {

    @Override
    public void addInfo(Bill bill) {

    }

    @Override
    public void addInfo(List<Bill> list) {

    }

    @Override
    public void addInfo(Page<Bill> pageList) {
        List<Bill> records = pageList.getRecords();
        addInfo(records);
        pageList.setRecords(records);
    }

    @Override
    public Page<Bill> findPageList(Page page, Bill bill) {
        return baseMapper.findPageList(page,bill);
    }

    @Override
    public Bill getByIdType(Integer id) {
        return  baseMapper.getByIdType(id);
    }
}
