package com.hldk.emergency.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hldk.emergency.modules.app.service.IBillService;
import com.hldk.emergency.modules.app.entity.Bill;
import com.hldk.emergency.modules.app.constant.BillConstant;
import com.hldk.common.core.annotation.Insert;
import com.hldk.common.core.annotation.Update;
import com.hldk.common.core.base.BaseServiceController;
import com.hldk.common.core.base.ResponseJson;
import com.hldk.common.core.util.CheckUtil;
import com.hldk.common.logging.annotation.*;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import java.util.List;

/**
 * @author yjl
 * @date 2023-5-31 10:35:34
 * 
 */
@RestController
@RequestMapping(value = "bill")
@LogApi("")
public class BillController extends BaseServiceController {

    @Resource
    private IBillService billService;

    @LogMethod("新增")
    @PostMapping("insert")
    public ResponseJson insert(@RequestBody @Validated(Insert.class) Bill bill) {
        billService.save(bill);
        return buildSuccessResult();
    }


    @LogMethod("修改")
    @PostMapping("update")
    public ResponseJson update(@RequestBody @Validated(Update.class) Bill bill) {
        billService.updateById(bill);
        return buildSuccessResult();
    }


    @LogMethod("根据ID删除")
    @DeleteMapping("deleteById")
    public ResponseJson deleteById(Integer id) {
        CheckUtil.isNotNull(id,"id不得为空");
        billService.removeById(id);
        return buildSuccessResult();
    }

    @LogMethod("根据ID获取")
    @GetMapping("findById")
    public ResponseJson findById(Integer id) {
        CheckUtil.isNotNull(id, "id不得为空");
        Bill bill = billService.getById(id);
        return buildSuccessResult(bill);
    }

    @LogMethod("列表查询")
    @GetMapping("list")
    public ResponseJson list(Bill bill) {
        QueryWrapper queryWrapper = createQueryWrapper(bill);
        List<Bill> list = billService.list(queryWrapper);
        return buildSuccessResult(list);
    }

    @LogMethod("分页查询")
    @GetMapping("pageList")
    public ResponseJson pageList(Bill bill,Page page) {
        QueryWrapper queryWrapper = createQueryWrapper(bill);
        queryWrapper.orderByDesc(BillConstant.ID);
        Page<Bill> pageList = billService.page(page, queryWrapper);
        return buildSuccessResult(pageList);
    }

    @LogMethod("根据ID获取")
    @GetMapping("findByIdName")
    public ResponseJson findByIdTypeName(Integer id) {
        CheckUtil.isNotNull(id, "id不得为空");
        Bill bill = billService.getByIdType(id);
        return buildSuccessResult(bill);
    }
}