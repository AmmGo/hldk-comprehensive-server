package ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixController};

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixService?lower_case}.${"I"+entityName?cap_first+codeConfig.suffixService?cap_first};
import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixEntity?lower_case}.${entityName?cap_first};
import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixConstant}.${entityName?cap_first+codeConfig.suffixConstant?cap_first};
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
 * @author ${codeConfig.creatName}
 * @date ${.now}
 * ${codeTable.comment}
 */
@RestController
@RequestMapping(value = "${entityName?uncap_first}")
@LogApi("${codeTable.comment}")
public class ${entityName?cap_first+codeConfig.suffixController?cap_first} extends BaseServiceController {

    @Resource
    private ${"I"+entityName?cap_first+codeConfig.suffixService?cap_first} ${entityName?uncap_first+codeConfig.suffixService?cap_first};

    @LogMethod("新增")
    @PostMapping("insert")
    public ResponseJson insert(@RequestBody @Validated(Insert.class) ${entityName?cap_first} ${entityName?uncap_first}) {
        ${entityName?uncap_first+codeConfig.suffixService?cap_first}.save(${entityName?uncap_first});
        return buildSuccessResult();
    }


    @LogMethod("修改")
    @PostMapping("update")
    public ResponseJson update(@RequestBody @Validated(Update.class) ${entityName?cap_first} ${entityName?uncap_first}) {
        ${entityName?uncap_first+codeConfig.suffixService?cap_first}.updateById(${entityName?uncap_first});
        return buildSuccessResult();
    }


    @LogMethod("根据ID删除")
    @DeleteMapping("deleteById")
    public ResponseJson deleteById(Integer id) {
        CheckUtil.isNotNull(id,"id不得为空");
        ${entityName?uncap_first+codeConfig.suffixService?cap_first}.removeById(id);
        return buildSuccessResult();
    }

    @LogMethod("根据ID获取")
    @GetMapping("findById")
    public ResponseJson findById(Integer id) {
        CheckUtil.isNotNull(id, "id不得为空");
        ${entityName?cap_first} ${entityName?uncap_first} = ${entityName?uncap_first+codeConfig.suffixService?cap_first}.getById(id);
        return buildSuccessResult(${entityName?uncap_first});
    }

    @LogMethod("列表查询")
    @GetMapping("list")
    public ResponseJson list(${entityName?cap_first} ${entityName?uncap_first}) {
        QueryWrapper queryWrapper = createQueryWrapper(${entityName?uncap_first});
        List<${entityName?cap_first}> list = ${entityName?uncap_first+codeConfig.suffixService?cap_first}.list(queryWrapper);
        return buildSuccessResult(list);
    }

    @LogMethod("分页查询")
    @GetMapping("pageList")
    public ResponseJson pageList(${entityName?cap_first} ${entityName?uncap_first},Page page) {
        QueryWrapper queryWrapper = createQueryWrapper(${entityName?uncap_first});
        queryWrapper.orderByDesc(${entityName?cap_first+codeConfig.suffixConstant?cap_first}.ID);
        Page<${entityName?cap_first}> pageList = ${entityName?uncap_first+codeConfig.suffixService?cap_first}.page(page, queryWrapper);
        return buildSuccessResult(pageList);
    }
}
