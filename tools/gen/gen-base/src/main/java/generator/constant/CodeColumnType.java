package generator.constant;

/**
 * 内部字段类型
 *
 * @author JueYue on 2017/9/21.
 */
public enum CodeColumnType {

    OBJECT("Object"),
    STRING("String"),
    CHAR("char"),
    BOOLEAN("Boolean"),
    SHORT("Short"),
    LONG("Long"),
    BYTE_ARR("byte[]"),
    BYTE("byte"),
    DATE("Date"),
    BIG_DECIMAL("BigDecimal"),
    DOUBLE("Double"),
    FLOAT("Float"),
    INTEGER("Integer"),
    ;


    private String type;

    CodeColumnType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
