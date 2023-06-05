package ${codeConfig.serverTestPackageName}.${codeConfig.moduleName};

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import ${codeConfig.serverPackageName}.${codeConfig.moduleName}.${codeConfig.suffixService}.${"I"+entityName?cap_first+codeConfig.suffixService?cap_first};

import javax.annotation.Resource;

/**
* @author ${codeConfig.creatName}
* @date ${.now}
* ${codeTable.comment} 测试类
*/
@SpringBootTest
@Slf4j
public class  ${entityName?cap_first+"Test"} {
    @Resource
    private ${"I"+entityName?cap_first+codeConfig.suffixService?cap_first} ${entityName?uncap_first+codeConfig.suffixService?cap_first};

    @Test
    void test(){

    }
}
