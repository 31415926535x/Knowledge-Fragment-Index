package tech.x31415926535.model.knowledgecurd.notion.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum NotionFragmentStatusEnum {

    /**
     * 首次添加，且未开始处理
     */
    NOT_STARTED("NotStarted"),

    /**
     * 处理中
     */
    IN_PROGRESS("InProgress"),

    /**
     * 处理完成
     */
    DONE("Done"),
    ;

    private final String status;

    public NotionFragmentStatusEnum getStatus(String status) {
        for (NotionFragmentStatusEnum value : NotionFragmentStatusEnum.values()) {
            if (value.getStatus().equalsIgnoreCase(status)) {
                return value;
            }
        }
        return null;
    }


}
