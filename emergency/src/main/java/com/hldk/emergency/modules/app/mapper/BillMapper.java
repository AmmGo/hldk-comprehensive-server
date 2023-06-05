package com.hldk.emergency.modules.app.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import com.hldk.emergency.modules.app.entity.Bill;
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
     * @param page
     * @param bill
     * @return
     */
    Page<Bill> findPageList(@Param("page") Page page, @Param("e")Bill bill);


    Bill getByIdType(@Param("id") Integer id) ;

}