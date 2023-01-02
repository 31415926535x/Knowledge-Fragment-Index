package tech.x31415926535.web.controller.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import tech.x31415926535.model.knowledgecurd.common.exception.RequestValidateException;

import javax.servlet.http.HttpServletRequest;


/**
 * date: 2023/1/2 19:02
 * author: 31415926535x
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);
    private static final String LOG_TITLE = "GlobalExceptionHandler";

    /**
     * 最大的异常，不期望出现；所有潜在异常都应该在业务中做捕获/转换
     *
     * @param request 请求
     * @param ex      异常内容
     * @return 返回失败请求
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public ResponseEntity exceptionHandler(HttpServletRequest request, Exception ex) {
        LOG.error(LOG_TITLE, "service crash an exception and no try/catch: {}", ex);
        return ResponseEntity.internalServerError().build();
    }

    /**
     * 请求入参校验失败
     * todo 后续增加对此异常的次数埋点、监控
     *
     * @param request 请求
     * @param ex      异常内容
     * @return 非法请求结果
     */
    @ResponseBody
    @ExceptionHandler(value = RequestValidateException.class)
    public ResponseEntity requestValidateException(HttpServletRequest request, Exception ex) {
        LOG.error(LOG_TITLE, "controller request check failed: {}", ex);
        return ResponseEntity.badRequest().body(ex.getMessage());
    }


}
