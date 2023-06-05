package generator.apifox;

import com.hldk.common.mod.brush.BrushUtil;
import com.hldk.common.util.core.CollectionUtil;
import com.hldk.common.util.core.JsonUtil;
import generator.constant.CodeColumn;
import generator.constant.CodeTable;
import generator.utils.WriteUtil;
import lombok.Getter;

import java.util.*;

/**
 * @author Administrator on 2022/8/11.
 * @version 1.0
 */
public class BuildApiFox {


    private String path;
    private CodeTable codeTable;
    private String modName;
    private StringBuffer sb = new StringBuffer("{\"apifoxProject\":\"1.0.0\",\"info\":{\"name\":\"示例项目\",\"description\":\"\",\"mockRule\":{\"rules\":[],\"enableSystemRule\":true}},\"responseCollection\":[{\"jsonSchema\":{\"type\":\"object\",\"properties\":{\"code\":{\"type\":\"integer\"},\"message\":{\"type\":\"string\",\"mock\":{\"mock\":\"Not found\"}}},\"required\":[\"code\",\"message\"],\"x-apifox-orders\":[\"code\",\"message\"]},\"defaultEnable\":false,\"name\":\"记录不存在\",\"code\":404,\"contentType\":\"json\",\"id\":\"75640509\"},{\"jsonSchema\":{\"type\":\"object\",\"properties\":{\"code\":{\"type\":\"integer\",\"mock\":{\"mock\":\"401\"}},\"message\":{\"type\":\"string\",\"mock\":{\"mock\":\"Invalid Param\"}}},\"required\":[\"code\",\"message\"],\"x-apifox-orders\":[\"code\",\"message\"]},\"defaultEnable\":false,\"name\":\"参数不正确\",\"code\":401,\"contentType\":\"json\",\"id\":\"75640510\"},{\"jsonSchema\":{\"type\":\"object\",\"properties\":{},\"x-apifox-orders\":[]},\"defaultEnable\":false,\"name\":\"修改成功\",\"code\":200,\"contentType\":\"json\",\"id\":\"75640511\"},{\"jsonSchema\":{\"type\":\"object\",\"properties\":{},\"x-apifox-orders\":[]},\"defaultEnable\":false,\"name\":\"新建成功\",\"code\":201,\"contentType\":\"json\",\"id\":\"75640512\"}],\"apiCollection\":[{\"name\":\"根目录\",\"parentId\":0,\"serverId\":\"\",\"description\":\"\",\"preProcessors\":[],\"postProcessors\":[],\"auth\":{},\"items\":[{\"name\":\"测试接口\",\"api\":{\"id\":\"33781434\",\"method\":\"get\",\"path\":\"/test/test\",\"parameters\":{\"query\":[{\"required\":false,\"description\":\"字符串\",\"type\":\"string\",\"name\":\"str\",\"sampleValue\":\"asd\"},{\"required\":false,\"description\":\"数字\",\"type\":\"integer\",\"name\":\"int\",\"sampleValue\":\"123\"},{\"required\":false,\"description\":\"数组\",\"type\":\"array\",\"name\":\"array\",\"sampleValue\":[\"1\",\"2\",\"3\",\"4\"]},{\"required\":false,\"description\":\"数字\",\"type\":\"number\",\"name\":\"number\",\"sampleValue\":\"123456789\"}],\"header\":[{\"required\":false,\"description\":\"head说明\",\"type\":\"string\",\"name\":\"hhhhhead\",\"sampleValue\":\"123123123\"}]},\"auth\":{},\"commonParameters\":{\"query\":[],\"body\":[],\"cookie\":[],\"header\":[]},\"responses\":[{\"id\":\"81498064\",\"name\":\"成功\",\"code\":200,\"contentType\":\"json\",\"jsonSchema\":{\"type\":\"object\",\"properties\":{\"code\":{\"type\":\"integer\"},\"msg\":{\"type\":\"string\"},\"data\":{\"type\":\"object\",\"properties\":{\"id\":{\"type\":\"null\",\"description\":\"id说明\",\"title\":\"id\"},\"name\":{\"type\":\"string\",\"title\":\"名称\",\"description\":\"名称说明\"},\"icon\":{\"type\":\"string\",\"title\":\"图标\",\"description\":\"图标说明\"},\"parentId\":{\"type\":\"null\",\"title\":\"父级ID\",\"description\":\"父级ID说明\"},\"path\":{\"type\":\"string\",\"title\":\"路由\",\"description\":\"路由说明\"}},\"required\":[\"id\",\"name\",\"icon\",\"parentId\",\"path\"],\"x-apifox-orders\":[\"id\",\"name\",\"icon\",\"parentId\",\"path\"]}},\"required\":[\"code\",\"msg\",\"data\"],\"x-apifox-orders\":[\"code\",\"msg\",\"data\"]}}],\"responseExamples\":[{\"name\":\"成功示例\",\"data\":\"{\\n    \\\"code\\\": 200,\\n    \\\"msg\\\": \\\"success\\\",\\n    \\\"data\\\": \\\"数据\\\"\\n}\",\"responseId\":81498064,\"ordering\":1}],\"requestBody\":{\"type\":\"application/json\",\"parameters\":[],\"jsonSchema\":{\"type\":\"object\",\"properties\":{\"body\":{\"type\":\"integer\"}},\"required\":[\"body\"],\"x-apifox-orders\":[\"body\"]}},\"description\":\"说明说明说明\",\"tags\":[\"宠物\"],\"status\":\"developing\",\"serverId\":\"\",\"operationId\":\"\",\"sourceUrl\":\"\",\"ordering\":10,\"cases\":[],\"mocks\":[],\"customApiFields\":\"{}\",\"advancedSettings\":{},\"mockScript\":{}}}]}],\"schemaCollection\":[{\"name\":\"根目录\",\"items\":[{\"name\":\"宠物店\",\"items\":[{\"name\":\"Pet\",\"id\":\"#/definitions/14179209\",\"description\":\"\",\"schema\":{\"jsonSchema\":{\"required\":[\"name\",\"photoUrls\",\"id\",\"category\",\"tags\",\"status\"],\"type\":\"object\",\"properties\":{\"id\":{\"type\":\"integer\",\"format\":\"int64\",\"minimum\":1,\"maximum\":5000,\"mock\":{\"mock\":\"@natural\"},\"description\":\"宠物ID编号\"},\"category\":{\"$ref\":\"#/definitions/14179210\",\"description\":\"分组\"},\"name\":{\"type\":\"string\",\"example\":\"doggie\",\"description\":\"名称\",\"mock\":{\"mock\":\"@cword(3)\"}},\"photoUrls\":{\"type\":\"array\",\"xml\":{\"name\":\"photoUrl\",\"wrapped\":true},\"items\":{\"type\":\"string\",\"mock\":{\"mock\":\"@image\"}},\"description\":\"照片URL\"},\"tags\":{\"type\":\"array\",\"xml\":{\"name\":\"tag\",\"wrapped\":true},\"items\":{\"$ref\":\"#/definitions/14179211\"},\"description\":\"标签\"},\"status\":{\"type\":\"string\",\"description\":\"宠物销售状态\",\"enum\":[\"available\",\"pending\",\"sold\"]}},\"xml\":{\"name\":\"Pet\"},\"x-apifox-orders\":[\"id\",\"category\",\"name\",\"photoUrls\",\"tags\",\"status\"]}}},{\"name\":\"Category\",\"id\":\"#/definitions/14179210\",\"description\":\"\",\"schema\":{\"jsonSchema\":{\"type\":\"object\",\"properties\":{\"id\":{\"type\":\"integer\",\"format\":\"int64\",\"minimum\":1,\"description\":\"分组ID编号\"},\"name\":{\"type\":\"string\",\"mock\":{\"mock\":\"@cword(2)\"},\"description\":\"分组名称\"}},\"xml\":{\"name\":\"Category\"},\"x-apifox-orders\":[\"id\",\"name\"]}}},{\"name\":\"Tag\",\"id\":\"#/definitions/14179211\",\"description\":\"\",\"schema\":{\"jsonSchema\":{\"type\":\"object\",\"properties\":{\"id\":{\"type\":\"integer\",\"format\":\"int64\",\"minimum\":1,\"description\":\"标签ID编号\"},\"name\":{\"type\":\"string\",\"mock\":{\"mock\":\"@cword(4)\"},\"description\":\"标签名称\"}},\"xml\":{\"name\":\"Tag\"},\"x-apifox-orders\":[\"id\",\"name\"]}}}]}]}],\"environments\":[{\"baseUrl\":\"http://127.0.0.1\",\"baseUrls\":{\"default\":\"http://127.0.0.1\"},\"parameters\":{},\"variables\":[],\"name\":\"测试环境\",\"type\":\"normal\",\"visibility\":\"protected\",\"ordering\":0,\"id\":\"4705447\"},{\"baseUrl\":\"http://127.0.0.1\",\"baseUrls\":{\"default\":\"http://127.0.0.1\"},\"parameters\":{},\"variables\":[],\"name\":\"正式环境\",\"type\":\"normal\",\"visibility\":\"protected\",\"ordering\":0,\"id\":\"4705448\"},{\"baseUrl\":\"http://127.0.0.1:4523/mock/1367688\",\"baseUrls\":{\"default\":\"http://127.0.0.1:4523/mock/undefined\"},\"parameters\":{},\"variables\":[],\"name\":\"本地 Mock\",\"type\":\"mock\",\"visibility\":\"protected\",\"ordering\":0,\"id\":\"4705449\"},{\"baseUrl\":\"\",\"baseUrls\":{\"default\":\"\"},\"parameters\":{},\"variables\":[],\"name\":\"云端 Mock\",\"type\":\"cloudMock\",\"visibility\":\"protected\",\"ordering\":0,\"id\":\"4705450\"}],\"commonScripts\":[],\"globalVariables\":[],\"commonParameters\":null,\"projectSetting\":{\"apiStatuses\":[\"developing\",\"testing\",\"released\",\"deprecated\"],\"servers\":[{\"id\":\"default\",\"name\":\"默认服务\"}],\"preProcessors\":[],\"postProcessors\":[],\"auth\":{},\"cloudMock\":{\"security\":\"free\",\"token\":\"B0m6XljmSdIH5DYb8TDv27IXDqwBft2f\",\"enable\":false,\"tokenKey\":\"apifoxToken\"},\"initialDisabledMockIds\":[],\"id\":\"1117667\"}}");

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public BuildApiFox(String modName, CodeTable codeTable) {
        this.codeTable = codeTable;
        this.modName = modName;
    }

    public void outPrint() {
        Map<String, Object> map = JsonUtil.toMap(sb.toString());
        List apiCollections = (List) map.get("apiCollection");
        Map apiCollection = (Map) apiCollections.get(0);
        apiCollection.put("name", codeTable.getComment());
        List<ApiItem> items = new ArrayList<>();
        items.add(createDict());
        items.add(createInsert());
        items.add(createUpdate());
        items.add(createList());
        items.add(createPageList());
        items.add(createDelete());
        items.add(createFindById());
        apiCollection.put("items", items);
        WriteUtil.writer(path, modName + ".json", JsonUtil.toJSON(map));
    }

    private ApiItem createDict() {
        Propertie data = new Propertie("object", "字典", "字典");
        createAllColumn(data);
        return createApiItem(Month.DICT, data, createEntityJson());
    }


    private ApiItem createInsert() {
        return createApiItem(Month.INSERT, createBase());
    }

    private ApiItem createUpdate() {
        return createApiItem(Month.UPDATE, createBase());
    }

    private ApiItem createList() {
        Propertie base = createBase();
        Propertie data = new Propertie("array", "返回集合数据", "返回集合数据");
        createAllColumn(data);
        base.putProperties("data", data);
        return createApiItem(Month.LIST, base, createEntityJson());
    }

    private ApiItem createPageList() {
        Propertie base = createBase();
        Propertie data = new Propertie("object", "数据资源", "数据资源");
        Propertie records = new Propertie("array", "分页数据", "分页数据");
        createAllColumn(records);
        data.putProperties("records", records);
        data.putProperties("total", "integer", "总数", "总数");
        data.putProperties("size", "integer", "每页显示条数", "每页显示条数");
        data.putProperties("current", "integer", "当前页", "当前页");
        data.putProperties("pages", "integer", "当前分页总页数", "当前分页总页数");
        base.putProperties("data", data);
        return createApiItem(Month.PAGE_LIST, base, createEntityJson());
    }

    private ApiItem createDelete() {
        Parameter query = new Parameter();
        query.setRequired(true);
        query.setName("id");
        query.setDescription("根据ID删除");
        query.setType("integer");
        query.setSampleValue("0");
        Propertie base = createBase();
        return createApiItem(Month.DELETE_BY_ID, base, null, query);
    }

    private ApiItem createFindById() {
        Parameter query = new Parameter();
        query.setRequired(true);
        query.setName("id");
        query.setDescription("根据ID查询");
        query.setType("integer");
        query.setSampleValue("0");
        return createApiItem(Month.FIND_BY_ID, createBase(), null, query);
    }

    private ApiItem createApiItem(Month month, Propertie propertie) {
        return createApiItem(month, propertie, null, null);
    }

    private ApiItem createApiItem(Month month, Propertie propertie, Map responsesExampleMap, Parameter... parameters) {
        ApiItem apiItem = new ApiItem();
        apiItem.setName(month.getName());
        Api api = new Api();
        String apiId = getId(10);
        api.setId(apiId);
        api.setMethod(month.getMonth());
        api.setPath("/" + modName + "/" + month.getPath());
        String responsesId = getId(10);
        api.addResponses(new ApiResponses(responsesId, propertie));
        api.addResponseExamples(null != responsesExampleMap ? new ApiResponseExample(responsesId, responsesExampleMap) : new ApiResponseExample(responsesId));
        api.setRequestBody(createApiRequestBody(month.getType()));
        api.setDescription(modName + month.getMsg());
        api.setOrdering(month.getOrder());

        if (CollectionUtil.isNotEmpty(parameters)) {
            for (Parameter parameter : parameters) {
                api.putQueryParameters(parameter);
            }

        }
        if (month.getOrder() == 3 ||
                month.getOrder() == 4 ||
                month.getOrder() == 0) {
            putParameters(api);
        } else {
            api.putHeaderParameters(getHeadParameters());
        }
        apiItem.setApi(api);
        return apiItem;
    }

    private Parameter getHeadParameters() {
        Parameter head = new Parameter();
        head.setRequired(true);
        head.setName("TOKEN");
        head.setDescription("验证参数");
        head.setSampleValue(UUID.randomUUID().toString().replace("-", ""));
        return head;
    }

    private void putParameters(Api api) {
        api.putParameters("path", null);
        api.putHeaderParameters(getHeadParameters());
        List<CodeColumn> columnList = codeTable.getColumnList();
        for (CodeColumn codeColumn : columnList) {
            if (codeColumn.getColumnName().equals("id")
                    || codeColumn.getColumnName().equals("creator_id")
                    || codeColumn.getColumnName().equals("update_id")
                    || codeColumn.getColumnName().equals("create_time")
                    || codeColumn.getColumnName().equals("update_time")

            ) {
                continue;
            }
            Parameter query = new Parameter();
            query.setRequired(codeColumn.getNullable());
            query.setName(codeColumn.getName());
            query.setDescription(codeColumn.getColumnComment() + "匹配查询");
            query.setType(codeColumn.getType());
            query.setSampleValue("");
            api.putQueryParameters(query);
        }
    }

    private Propertie createBase() {
        Propertie properties = new Propertie();
        properties.setType("object");
        properties.addRequireds("code", "msg", "data");
        properties.addXApifoxOrderss("code", "msg", "data");
        properties.putProperties("code", "integer", "状态码", "状态码");
        properties.putProperties("msg", "string", "消息", "消息");
        return properties;
    }

    private void createAllColumn(Propertie propertie) {
        List<CodeColumn> columnList = codeTable.getColumnList();
        for (CodeColumn codeColumn : columnList) {
            String type = codeColumn.getType().toLowerCase();
            if (type.equals("date")) {
                type = "string";
            }
            if (codeColumn.getName().equals("isDelete")) {
                continue;
            }
            propertie.putItems(codeColumn.getName(), type, codeColumn.getColumnComment(), null);
        }
    }

    private Map createEntityJson() {
        Map map = new HashMap();
        List<CodeColumn> columnList = codeTable.getColumnList();
        for (CodeColumn codeColumn : columnList) {
            if (codeColumn.getName().equals("isDelete")){
                continue;
            }
            String key = codeColumn.getName();
            Object value = new Object();
            if (codeColumn.getType().equals("String")) {
                value = "str";
            } else if (codeColumn.getType().equals("Integer")) {
                value = 1;
            } else if (codeColumn.getType().equals("Double")) {
                value = 1d;
            } else if (codeColumn.getType().equals("Long")) {
                value = 1L;
            } else if (codeColumn.getType().equals("Date")) {
                value = new Date();
            } else {
                value = "";
            }
            map.put(key, value);
        }
        return map;
    }

    /**
     * @param type 0 无参 1有参 2新增 3修改
     * @return
     */
    private ApiRequestBody createApiRequestBody(int type) {
        ApiRequestBody apiRequestBody = new ApiRequestBody();
        apiRequestBody.setType("application/json");
        apiRequestBody.setParameters(new ArrayList());
        Propertie jsonSchema = new Propertie();
        jsonSchema.setType("object");
        if (type >= 1) {
            List<CodeColumn> columnList = codeTable.getColumnList();
            for (CodeColumn codeColumn : columnList) {
                if (type  <= 2 && type>0 && (
                        codeColumn.getColumnName().equals("creator_id") ||
                                codeColumn.getColumnName().equals("update_id") ||
                                codeColumn.getColumnName().equals("create_time") ||
                                codeColumn.getColumnName().equals("update_time") ||
                                codeColumn.getColumnName().equals("is_delete")
                )) {
                    continue;
                }
                if (type == 2 && type>0 && codeColumn.getName().equals("id")) {
                    continue;
                }
                jsonSchema.putProperties(codeColumn.getName(), codeColumn.getType().toLowerCase(), codeColumn.getColumnComment(), codeColumn.getColumnComment());
                jsonSchema.addXApifoxOrderss(codeColumn.getName());
                if (codeColumn.getNullable()) {
                    jsonSchema.addRequired(codeColumn.getName());
                }

            }
        }

        apiRequestBody.setJsonSchema(jsonSchema);
        return apiRequestBody;
    }

    private String getId(int length) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < length; i++) {
            sb.append(BrushUtil.randomInt(1, 9));
        }
        return sb.toString();
    }

    @Getter
    enum Month {
        //新增
        DICT(0, "字典", "view", "dict", "字段CODE 对应 非接口", 0),
        INSERT(1, "新增", "post", "insert", "新增一条数据", 2),
        UPDATE(2, "修改", "post", "update", "根据ID修改一条数据", 1),
        LIST(3, "集合查询", "get", "list", "根据条件查询集合", 0),
        PAGE_LIST(4, "分页查询", "get", "pageList", "根据条件分页查询集合", 0),
        FIND_BY_ID(5, "ID查询", "get", "findById", "根据ID查询单条数据", 0),
        DELETE_BY_ID(6, "ID删除", "delete", "deleteById", "根据ID删除单条数据", 0),
        ;
        private Integer order;
        private String name;
        private String month;
        private String path;
        private String msg;
        private int type;

        Month(Integer order, String name, String month, String path, String msg, int type) {
            this.order = order;
            this.name = name;
            this.month = month;
            this.path = path;
            this.msg = msg;
            this.type = type;
        }
    }


}
