package generator.config;

import generator.constant.CodeColumn;
import generator.constant.CodeTable;
import generator.utils.NameUtil;
import generator.utils.ReadUtil;
import generator.utils.WriteUtil;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author Administrator
 */
@Getter
@Setter
public class CodeBuild {
    private String entityName;
    private CodeConfig codeConfig;
    private CodeTable codeTable;

    public CodeBuild(CodeConfig codeConfig) {
        this.codeConfig = codeConfig;
        this.codeTable = ReadUtil.getCodeTable(codeConfig);
        this.entityName = NameUtil.underlineToHump(codeConfig.getTableName().replace(codeConfig.getPreFix(), ""));

    }

    public void write() {
        System.out.println("开始生成代码");
        if (codeConfig.isCreateServer()) {
            String baseServerPath = codeConfig.getServerPath() + "\\" + codeConfig.getModuleName();
            if (codeConfig.isCreateServerController()) {
                WriteUtil.writerJava(baseServerPath + "\\" + NameUtil.getFieldHumpName(codeConfig.getSuffixController()),
                        NameUtil.capFirst(entityName) + NameUtil.getEntityHumpName(codeConfig.getSuffixController()) + ".java",
                        "/server/controller.ftl", this);
                System.out.println(String.format("%s生成完毕", "server-controller模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "server-controller模块"));
            }
            if (codeConfig.isCreateServerService()) {
                WriteUtil.writerJava(baseServerPath + "\\" + NameUtil.getFieldHumpName(codeConfig.getSuffixService()),
                        "I" + NameUtil.capFirst(entityName) + NameUtil.getEntityHumpName(codeConfig.getSuffixService()) + ".java",
                        "/server/service.ftl", this);
                WriteUtil.writerJava(baseServerPath + "\\" + NameUtil.getFieldHumpName(codeConfig.getSuffixService()) + "\\impl",
                        NameUtil.capFirst(entityName) + NameUtil.getEntityHumpName(codeConfig.getSuffixService()) + ".java",
                        "/server/serviceimpl.ftl", this);
                System.out.println(String.format("%s生成完毕", "server-service模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "server-service模块"));
            }
            if (codeConfig.isCreateServerDao()) {
                WriteUtil.writerJava(baseServerPath + "\\" + NameUtil.getFieldHumpName(codeConfig.getSuffixDao()),
                        NameUtil.capFirst(entityName) + NameUtil.getEntityHumpName(codeConfig.getSuffixDao()) + ".java",
                        "/server/dao.ftl", this);
                System.out.println(String.format("%s生成完毕", "server-dao模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "server-dao模块"));
            }
            if (codeConfig.isCreateServerEntity()) {
                WriteUtil.writerJava(baseServerPath + "\\" + NameUtil.getFieldHumpName(codeConfig.getSuffixEntity()),
                        NameUtil.capFirst(entityName) + ".java",
                        "/server/entity.ftl", this);
                System.out.println(String.format("%s生成完毕", "server-entity模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "server-entity模块"));
            }
            if (codeConfig.isCreateServerConstant()) {
                WriteUtil.writerJava(baseServerPath + "\\" + NameUtil.getFieldHumpName(codeConfig.getSuffixConstant()),
                        NameUtil.capFirst(entityName) + NameUtil.getEntityHumpName(codeConfig.getSuffixConstant()) + ".java",
                        "/server/constant.ftl", this);
                System.out.println(String.format("%s生成完毕", "server-constant模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "server-constant模块"));
            }

            if (codeConfig.isCreateServerXml()) {
                WriteUtil.writerJava(codeConfig.getServerXmlPath() + "\\" + codeConfig.getModuleName(),
                        NameUtil.capFirst(entityName) + NameUtil.getEntityHumpName(codeConfig.getSuffixXml()) + ".xml",
                        "/server/xml.ftl", this);
                System.out.println(String.format("%s生成完毕", "server-xml模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "server-xml模块"));
            }

            if (codeConfig.isCreateServerTest()) {
                WriteUtil.writerJava(codeConfig.getServerTestPath() + "\\" + codeConfig.getModuleName(),
                        NameUtil.capFirst(entityName) + "Test.java",
                        "/server/test.ftl", this);
                System.out.println(String.format("%s生成完毕", "server-test模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "server-test模块"));
            }

//            if (codeConfig.isCreateServerDto()) {
//                WriteUtil.writerJava(baseServerPath+"\\"+NameUtil.getFieldHumpName("dto"),
//                        NameUtil.capFirst(entityName)+NameUtil.getEntityHumpName("Vo")+".java",
//                        "/server/vo.ftl", this);
//                WriteUtil.writerJava(baseServerPath+"\\"+NameUtil.getFieldHumpName("dto"),
//                        NameUtil.capFirst(entityName)+NameUtil.getEntityHumpName("Query")+".java",
//                        "/server/query.ftl", this);
//                WriteUtil.writerJava(baseServerPath+"\\"+NameUtil.getFieldHumpName("dto"),
//                        NameUtil.capFirst(entityName)+NameUtil.getEntityHumpName("From")+".java",
//                        "/server/from.ftl", this);
//                System.out.println(String.format("%s生成完毕", "server-dto模块"));
//            }else{
//                System.out.println(String.format("%s放弃生成", "server-dto模块"));
//            }


            System.out.println(String.format("%s生成完毕", "server模块"));
        } else {
            System.out.println(String.format("%s放弃生成", "server模块"));
        }
        if (codeConfig.isCreateAPI()) {
            String baseApiPath = codeConfig.getApiPath() + "\\" + codeConfig.getModuleName();
            if (codeConfig.isCreateAPIController()) {
                WriteUtil.writerJava(baseApiPath + "\\" + NameUtil.getFieldHumpName(codeConfig.getSuffixController()),
                        NameUtil.capFirst(entityName) + NameUtil.getEntityHumpName(codeConfig.getSuffixController()) + ".java",
                        "/api/controller.ftl", this);
                System.out.println(String.format("%s生成完毕", "api-controller模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "api-controller模块"));
            }
            if (codeConfig.isCreateAPIEntity()) {
                WriteUtil.writerJava(baseApiPath + "\\" + NameUtil.getFieldHumpName(codeConfig.getSuffixEntity()),
                        NameUtil.capFirst(entityName) + ".java",
                        "/api/entity.ftl", this);
                System.out.println(String.format("%s生成完毕", "api-controller模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "api-controller模块"));
            }
            System.out.println(String.format("%s生成完毕", "API模块"));
        } else {
            System.out.println(String.format("%s放弃生成", "API模块"));
        }
        if (codeConfig.isCreateVue()) {
            String baseApiPath = codeConfig.getVuePath() + "\\" + codeConfig.getModuleName();
            if (codeConfig.isCreateVuePageTable()) {
                WriteUtil.writerJava(baseApiPath + "\\",
                        "Table.vue",
                        "/vue/vue-pages-table.ftl", this);
                System.out.println(String.format("%s生成完毕", "api-controller模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "api-controller模块"));
            }
            if (codeConfig.isCreateVuePageInfo()) {
                WriteUtil.writerJava(baseApiPath + "\\components",
                        "TableSave.vue",
                        "/vue/vue-pages-save.ftl", this);
                System.out.println(String.format("%s生成完毕", "api-controller模块"));
            } else {
                System.out.println(String.format("%s放弃生成", "api-controller模块"));
            }
            System.out.println(String.format("%s生成完毕", "API模块"));
        } else {
            System.out.println(String.format("%s放弃生成", "Vue模块"));
        }
        if (codeConfig.isCreateVueZhJs()) {

            List<CodeColumn> columnList = codeTable.getColumnList();
            //循环columnList  取出codeColumn中的字段名和字段注释 拼接生成json格式的字符串 写入到zh.js文件中
            StringBuilder sb = new StringBuilder();
            for (CodeColumn codeColumn : columnList) {
                String fieldName = NameUtil.getFieldHumpName(codeColumn.getColumnName());
                if(codeColumn.getIsKey() == 1){
                    continue;
                }
                if(fieldName.equals("creatorId") || fieldName.equals("updateId") || fieldName.equals("createTime") || fieldName.equals("updateTime")){
                    continue;
                }
                sb.append(""+fieldName+":\'"+codeColumn.getColumnComment()+"\',");
            }
            //通过文件输出流将字符串写入到zh.js文件中，不存在则创建
            String str = sb.toString();
            str = str.substring(0,str.length()-1);
            str = entityName + ":{"+str+"}";
            String filePath = codeConfig.getVuePath() + "\\" + codeConfig.getModuleName();
            String fileName = "zh.js";
            WriteUtil.writer(filePath,fileName,str);
            System.out.println("国际化JS生成完成");
        }
        System.out.println("代码生成完毕");
    }

}
