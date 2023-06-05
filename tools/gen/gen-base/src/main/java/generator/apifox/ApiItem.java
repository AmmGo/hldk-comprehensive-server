package generator.apifox;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator on 2022/8/11.
 * @version 1.0
 */
@Data
public class ApiItem {
    private String name;
    private Api api;

    public ApiItem() {
    }

    public ApiItem(String name, Api api) {
        this.name = name;
        this.api = api;
    }
}
