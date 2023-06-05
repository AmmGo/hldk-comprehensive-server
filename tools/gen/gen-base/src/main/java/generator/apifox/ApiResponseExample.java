package generator.apifox;

import com.hldk.common.util.core.JsonUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator on 2022/8/15.
 * @version 1.0
 */
@Data
public class ApiResponseExample {
    private String name = "成功示例";
    private String data = "{\n    \"code\": 200,\n    \"msg\": \"success\",\n    \"data\": \"null\"\n}";
    private Long responseId;
    private Integer ordering = 1;


    public ApiResponseExample(String responseId) {
        this.responseId = Long.valueOf(responseId);
    }

    public ApiResponseExample(String responseId, Map map) {
        this.responseId = Long.valueOf(responseId);
        Map dataMap = JsonUtil.toMap(data);
        List list = new ArrayList();
        list.add(map);
        dataMap.put("data",list);
        this.data = JsonUtil.toJSON(dataMap);
    }
}
