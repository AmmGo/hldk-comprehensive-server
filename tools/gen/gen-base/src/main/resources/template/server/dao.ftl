package ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixDao?lower_case};

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixEntity?lower_case}.${entityName?cap_first};
import java.util.List;

/**
 * @author ${codeConfig.creatName}
 * @date ${.now}
 * ${codeTable.comment}数据访问层
 */
@Mapper
@Repository
public interface ${entityName?cap_first+codeConfig.suffixDao?cap_first} extends BaseMapper<${entityName?cap_first}> {

    /**
     * 分页查询
     * @param page
     * @param ${entityName?lower_case}
     * @return
     */
    Page<${entityName?cap_first}> findPageList(@Param("page") Page page, @Param("e")${entityName?cap_first} ${entityName?lower_case});

}