package ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixService?lower_case}.impl;

import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixDao?lower_case}.${entityName?cap_first+codeConfig.suffixDao?cap_first};
import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixEntity?lower_case}.${entityName?cap_first};
import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixService?lower_case}.${"I"+entityName?cap_first+codeConfig.suffixService?cap_first};
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
 * @author ${codeConfig.creatName}
 * @date ${.now}
 * ${codeTable.comment} 业务逻辑层
 */
@Service
public class ${entityName?cap_first+codeConfig.suffixService?cap_first} extends ServiceImpl<${entityName?cap_first+codeConfig.suffixDao?cap_first},${entityName?cap_first}> implements ${"I"+entityName?cap_first+codeConfig.suffixService?cap_first} {

    @Override
    public void addInfo(${entityName?cap_first} ${entityName?uncap_first}) {

    }

    @Override
    public void addInfo(List<${entityName?cap_first}> list) {

    }

    @Override
    public void addInfo(Page<${entityName?cap_first}> pageList) {
        List<${entityName?cap_first}> records = pageList.getRecords();
        addInfo(records);
        pageList.setRecords(records);
    }

    @Override
    public Page<${entityName?cap_first}> findPageList(Page page, ${entityName?cap_first} ${entityName?uncap_first}) {
        return baseMapper.findPageList(page,${entityName?uncap_first});
    }
}
