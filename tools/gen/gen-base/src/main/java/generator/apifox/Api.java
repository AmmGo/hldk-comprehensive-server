package generator.apifox;

import com.hldk.common.util.core.JsonUtil;
import lombok.Data;

import java.util.*;

/**
 * @author Administrator on 2022/8/11.
 * @version 1.0
 */
@Data
public class Api {
    private String id;
    private String method;
    private String path;
    private LinkedHashMap<String,List<Parameter>> parameters;
    private List auth = new ArrayList();
    private LinkedHashMap commonParameters = new LinkedHashMap();
    private List<ApiResponses> responses;
    private List<ApiResponseExample> responseExamples;
    private ApiRequestBody requestBody;
    private String description;
    private List tags = new ArrayList<>();
    private String status = "developing";
    private String serverId = "";
    private String operationId = "";
    private String sourceUrl = "";
    private Integer ordering = 10;
    private List cases = new ArrayList();
    private List mocks = new ArrayList();
    private String customApiFields = "{}";
    private Map advancedSettings = new HashMap();
    private Map mockScript = new HashMap();

    {
        commonParameters.put("query", new ArrayList<>());
        commonParameters.put("body", new ArrayList<>());
        commonParameters.put("cookie", new ArrayList<>());
        commonParameters.put("header", new ArrayList<>());
    }

    public Api() {
    }

    public void addResponses(ApiResponses apiResponses){
        if (null == responses){
            responses = new ArrayList<>();
        }
        responses.add(apiResponses);
    }

    public void addResponseExamples(ApiResponseExample apiResponseExample){
        if (null == responseExamples){
            responseExamples = new ArrayList<>();
        }
        responseExamples.add(apiResponseExample);
    }

    public void putQueryParameters(Parameter parameter){
        String key = "query";
        putParameters(key,parameter);
    }
    public void putHeaderParameters(Parameter parameter){
        String key = "head";
        putParameters(key,parameter);
    }

    public void putParameters(String key,Parameter parameter){
        if (null == parameters){
            parameters = new LinkedHashMap<>();
        }
        List<Parameter> parameterList= parameters.get(key);
        if (null == parameterList){
            parameterList = new ArrayList<>();
        }
        if (null!=parameter){
            parameterList.add(parameter);
        }
        parameters.put(key,parameterList);
    }
}
