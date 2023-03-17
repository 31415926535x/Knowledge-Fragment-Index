package tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum FragmentProcessStatusEnum {

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

    public FragmentProcessStatusEnum getStatus(String status) {
        for (FragmentProcessStatusEnum value : FragmentProcessStatusEnum.values()) {
            if (value.getStatus().equalsIgnoreCase(status)) {
                return value;
            }
        }
        return null;
    }


}
