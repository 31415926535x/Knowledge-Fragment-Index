package tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum WebContentTypeEnum {


    /**
     * 未知
     */
    UNKNOWN("Unknown"),

    /**
     * csdn
     */
    CSDN("csdn"),

    /**
     * 微信公众号
     */
    WE_CHAT("WeChat"),
    ;


    private final String type;


    public static WebContentTypeEnum getType(String type) {
        for (WebContentTypeEnum value : WebContentTypeEnum.values()) {
            if (value.getType().equalsIgnoreCase(type)) {
                return value;
            }
        }
        return null;
    }

}
