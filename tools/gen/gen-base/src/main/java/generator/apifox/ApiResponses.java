package generator.apifox;

import lombok.Data;

/**
 * @author Administrator on 2022/8/11.
 * @version 1.0
 */
@Data
public class ApiResponses {
    private String id;
    private String name = "成功";
    private Integer code = 200;
    private String contentType = "json";
    private Propertie jsonSchema;

    public ApiResponses() {
    }


    public ApiResponses(String id, Propertie jsonSchema) {
        this.id = id;
        this.jsonSchema = jsonSchema;
    }
}
