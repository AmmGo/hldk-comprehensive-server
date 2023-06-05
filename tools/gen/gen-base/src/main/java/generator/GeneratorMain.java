package generator;

import generator.apifox.BuildApiFox;
import generator.config.CodeBuild;
import generator.config.CodeConfig;
import generator.utils.ConnectionUtil;

/**
 * @author Administrator
 */
//public class GeneratorMain {
//    public static void main(String[] args) {
//        CodeConfig codeConfig = new CodeConfig();
//        /**
//         * 连接参数
//         */
//        codeConfig.setDriver("com.mysql.cj.jdbc.Driver");
//        codeConfig.setUrl("jdbc:mysql://192.168.119.248:3306/hldk_comprehensive_spt_emergency?useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai");
//        codeConfig.setUserName("root");
//        codeConfig.setPassword("hldk1119");
//        codeConfig.setDatabaseName("hldk_comprehensive_spt_emergency");
//        List<String> strings = Arrays.asList(
//                "risk",
//                "risk_control_type",
//                "risk_hidden_danger",
//                "risk_inspection",
//                "risk_inspection_record",
//                "risk_read_record"
//        );
//        codeConfig.setTableName("app_test");
//        codeConfig.setPreFix("");
//        codeConfig.setDictCode("");
//        /**
//         * 项目参数
//         */
//        codeConfig.setCreatName("mq");
//
//        /**
//         * 是否 逻辑删除 有name 才会生成 为空默认不生成
//         */
//        codeConfig.setDeleteColumnName(null);
//        /**
//         * 服务参数
//         */
//        codeConfig.setCreateServer(false);
//        codeConfig.setServerPath("F:\\hldk-javaWork\\hldk-comprehensive-server\\emergency\\src\\main\\java\\com\\hldk\\emergency\\modules");
//        codeConfig.setServerPackageName("com.hldk.emergency.modules");
//        codeConfig.setCreateServerController(false);
//        codeConfig.setCreateServerService(false);
//        codeConfig.setCreateServerEntity(false);
//        codeConfig.setCreateServerDao(false);
//        codeConfig.setCreateServerConstant(false);
//        codeConfig.setCreateServerDto(false);
//        //XML 参数
//        codeConfig.setServerXmlPath("F:\\hldk-javaWork\\hldk-comprehensive-server\\emergency\\src\\main\\resources\\mapper\\modules");
//        codeConfig.setCreateServerXml(false);
//        //测试类
//        /**
//         * vue参数
//         */
//        codeConfig.setCreateVue(true);
//        codeConfig.setVuePath("F:\\VUE");
//        codeConfig.setCreateVuePageTable(true);
//        codeConfig.setCreateVuePageInfo(true);
//        codeConfig.setCreateVueZhJs(false);
//        for (String string : strings) {
//            codeConfig.setTableName(string);
//            codeConfig.setModuleName(NameUtil.underlineToHump(string));
//            ConnectionUtil.init(codeConfig);
//            CodeBuild codeBuild = new CodeBuild(codeConfig);
//            BuildApiFox buildApiFox = new BuildApiFox(codeBuild.getEntityName(), codeBuild.getCodeTable());
//            buildApiFox.setPath("F:\\apifoxJson\\hldk-comprehensive-server");
//            buildApiFox.outPrint();
//            codeBuild.write();
//        }
//
//    }

//}
public class GeneratorMain {
    public static void main(String[] args) {
        CodeConfig codeConfig = new CodeConfig();
        /**
         * 连接参数
         */
        codeConfig.setDriver("com.mysql.cj.jdbc.Driver");
        codeConfig.setUrl("jdbc:mysql://localhost/mylife?useUnicode=true&characterEncoding=UTF8&serverTimezone=Asia/Shanghai");
        codeConfig.setUserName("root");
        codeConfig.setPassword("123456");
        codeConfig.setDatabaseName("mylife");
        codeConfig.setTableName("life_bill");
//        codeConfig.setPreFix("sys_");
        codeConfig.setPreFix("life_");
        codeConfig.setModuleName("app");
        codeConfig.setDictCode("");
        /**
         * 项目参数
         */
        codeConfig.setCreatName("yjl");

        /**
         * 是否 逻辑删除 有name 才会生成 为空默认不生成
         */
        codeConfig.setDeleteColumnName(null);
        /**
         * 服务参数
         */
        codeConfig.setCreateServer(true);
        codeConfig.setServerPath("F:\\HLWork\\HLXIDEA\\hldk-comprehensive-server\\emergency\\src\\main\\java\\com\\hldk\\emergency\\modules");
        codeConfig.setServerPackageName("com.hldk.emergency.modules");
        codeConfig.setCreateServerController(true);
        codeConfig.setCreateServerService(true);
        codeConfig.setCreateServerEntity(true);
        codeConfig.setCreateServerDao(true);
        codeConfig.setCreateServerConstant(true);
        codeConfig.setCreateServerDto(true);
        //XML 参数
        codeConfig.setServerXmlPath("F:\\HLWork\\HLXIDEA\\hldk-comprehensive-server\\emergency\\src\\main\\resources\\mapper\\modules");
        codeConfig.setCreateServerXml(true);
        //测试类
        /**
         * vue参数
         */
        codeConfig.setCreateVue(true);
        codeConfig.setVuePath("E:\\VUE");
        codeConfig.setCreateVuePageTable(true);
        codeConfig.setCreateVuePageInfo(true);
        codeConfig.setCreateVueZhJs(false);

        ConnectionUtil.init(codeConfig);
        CodeBuild codeBuild = new CodeBuild(codeConfig);
        BuildApiFox buildApiFox = new BuildApiFox(codeBuild.getEntityName(), codeBuild.getCodeTable());
        buildApiFox.setPath("E:\\apifoxJson\\hldk-comprehensive-server");
        buildApiFox.outPrint();
        codeBuild.write();

    }
}