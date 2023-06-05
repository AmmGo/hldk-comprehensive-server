package ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixService?lower_case};

import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixEntity?lower_case}.${entityName?cap_first};
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @author ${codeConfig.creatName}
 * @date ${.now}
 * ${codeTable.comment} 业务逻辑层
 */
public interface ${"I"+entityName?cap_first+codeConfig.suffixService?cap_first} extends IService<${entityName?cap_first}> {

    /**
     * 添加附加信息
     *
     * @param ${entityName?uncap_first}
     */
    void addInfo(${entityName?cap_first} ${entityName?uncap_first});

    /**
     * 添加附加信息
     *
     * @param list
     */
    void addInfo(List<${entityName?cap_first}> list);

    /**
     * 添加附加信息
     *
     * @param pageList
     */
    void addInfo(Page<${entityName?cap_first}> pageList);

    /**
     * 分页查询
     * @param ${entityName?uncap_first}
     * @param page
     * @return
     */
    Page<${entityName?cap_first}> findPageList(Page page,${entityName?cap_first} ${entityName?uncap_first});

}
