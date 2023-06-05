package generator.apifox;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.*;

/**
 * @author Administrator on 2022/8/11.
 * @version 1.0
 */
@Data
public class Propertie {

    private String type ="null";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String description;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String title;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private LinkedHashMap<String, Propertie> properties;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Propertie items;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<String> required;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    @JsonProperty("x-apifox-orders")
    private List<String> xApifoxOrders;


    public Propertie() {
    }

    public Propertie(String type) {
        this.type = type;
    }

    public Propertie(String type, String description, String title) {
        this.type = type;
        this.description = description;
        this.title = title;
    }

    public void putProperties(String key, String type){
        if (null == this.properties){
            this.properties = new LinkedHashMap<>();
        }
        Propertie properties = new Propertie();
        properties.setType(type);
        this.properties.put(key,properties);
    }

    public void putItems(String key,String type,String title,String description){
        if (null == this.items){
            this.items = new Propertie();
        }
        items.setType("object");
        items.setDescription("数组实体");
        items.setTitle("数组实体");
        items.putProperties(key,type,title,description);
    }


    public void putProperties(String key,String type,String title,String description){
        if (null == this.properties){
            this.properties = new LinkedHashMap<>();
        }
        Propertie properties = new Propertie();
        properties.setType(type);
        properties.setTitle(title);
        properties.setDescription(description);
        this.properties.put(key,properties);
    }


    public void putProperties(String key, Propertie properties){
        if (null == this.properties){
            this.properties = new LinkedHashMap<>();
        }
        this.properties.put(key,properties);
    }

    public void addRequired(String required){
        if (null == this.required){
            this.required = new ArrayList<>();
        }
        this.required.add(required);
    }

    public void addRequireds(String ... requireds){
        for (String required : requireds) {
            addRequired(required);
        }
    }



    public void addXApifoxOrders(String xApifoxOrders){
        if (null == this.xApifoxOrders){
            this.xApifoxOrders = new ArrayList<>();
        }
        this.xApifoxOrders.add(xApifoxOrders);
    }

    public void addXApifoxOrderss(String ... xApifoxOrderss){
        for (String xApifoxOrders : xApifoxOrderss) {
            addXApifoxOrders(xApifoxOrders);
        }
    }
}
