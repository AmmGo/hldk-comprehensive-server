package ${codeConfig.serverPackageName}.${codeConfig.moduleName}.dto;

import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixEntity?lower_case}.${entityName?cap_first};
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;


/**
* @author ${codeConfig.creatName}
* @date ${.now}
* ${codeTable.comment}数据展示层
*/
@Getter
@Setter
@ApiModel(value = "${codeTable.comment}数据展示层")
public class ${entityName?cap_first}Vo extends ${entityName?cap_first}{}
