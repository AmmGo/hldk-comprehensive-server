package generator.config;

import generator.utils.ConnectionUtil;
import generator.utils.NameUtil;
import generator.utils.WriteUtil;
import lombok.Data;

import java.sql.Connection;

/**
 * @author Administrator on 2021/4/28.
 * @version 1.0
 */
@Data
public class CodeConfig {
    //创建人
    private String creatName;
    //驱动
    private String driver;
    //mysql url
    private String url;
    //mysql 账号
    private String userName;
    //mysql 密码
    private String password;
    //需要生成的表名称
    private String tableName;
    //数据库名
    private String databaseName;
    //模块名称
    private String moduleName;
    //表前缀去除
    private String preFix;
    //vue 生成地址
    private String vuePath;
    //服务代码生成地址
    private String serverPath;
    //服务XML生成地址
    private String serverXmlPath;
    //服务测试类生成地址
    private String serverTestPath;

    //API代码生成地址
    private String apiPath;
    //逻辑删除的字段名称
    private String deleteColumnName;
    //服务名称(用于生成API不用则不填)
    private String apiServerName;
    //项目的包名称
    private String serverPackageName;
    //项目的包名称
    private String serverTestPackageName;
    //项目的包名称
    private String apiPackageName;
    //最终实体名称
    private String entityName;

    //关联字典
    private String dictCode;

    private boolean createServer = false;
    //是否创建controller
    private boolean createServerController = false;
    //是否创建service
    private boolean createServerService = false;
    //是否创建entity
    private boolean createServerEntity = false;
    //是否创建dao
    private boolean createServerDao = false;
    //是否创建xml
    private boolean createServerXml = false;
    //是否创建常量类
    private boolean createServerConstant = false;
    //是否创建测试类
    private boolean createServerTest = false;
    //是否创建DTO
    private boolean createServerDto = false;


    private boolean createVue = false;
    //是否创建Vue列表页面
    private boolean createVuePageTable = false;
    //是否创建Vue详情页面
    private boolean createVuePageInfo = false;
    //是否创建API
    private boolean createAPI = false;
    //是否创建API Controller
    private boolean createAPIController = false;
    //是否创建API entity
    private boolean createAPIEntity = false;

    //Controller后缀
    private String suffixController = "controller";
    //service后缀
    private String suffixService = "Service";
    //entity后缀
    private String suffixEntity = "Entity";
    //dao层后缀
    private String suffixDao = "Mapper";
    //xml后缀
    private String suffixXml = "Mapper";
    //constant 后缀
    private String suffixConstant = "constant";

    //Vue 后缀
    private String suffixVuePageList = "Table";

    //Vue 后缀
    private String suffixVuePageInfo = "Save";

    private boolean createVueZhJs = false;

}
