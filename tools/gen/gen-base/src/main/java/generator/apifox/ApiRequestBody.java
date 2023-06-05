package generator.apifox;

import lombok.Data;

import java.util.List;

/**
 * @author Administrator on 2022/8/11.
 * @version 1.0
 */
@Data
public class ApiRequestBody {
    private String type;
    private List parameters ;
    private Propertie jsonSchema;

}
