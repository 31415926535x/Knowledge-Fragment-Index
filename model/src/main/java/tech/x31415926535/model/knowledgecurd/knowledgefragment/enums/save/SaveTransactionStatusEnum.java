package tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * date: 2023/4/1 21:14
 * author: 31415926535x
 */
@Getter
@AllArgsConstructor
public enum SaveTransactionStatusEnum {

    /**
     * 保存成功，且是首次保存
     */
    SUCCEED("Succeed", "save succeed."),

    /**
     * 已有链接，不保存
     */
    REPEAT_INFO("RepeatInfo", "repeat info, will not save again."),

    /**
     * 保存失败
     */
    FAILED("Failed", "save failed"),
    ;

    /**
     * 保存状态
     */
    private final String status;

    /**
     * 描述
     */
    private final String desc;

}
