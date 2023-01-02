package tech.x31415926535.model.knowledgecurd.common.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * 服务入参校验失败异常
 * date: 2023/1/2 18:59
 * author: 31415926535x
 */
@Data
@AllArgsConstructor
public class RequestValidateException extends RuntimeException {

    private String code;
    private String msg;
}
