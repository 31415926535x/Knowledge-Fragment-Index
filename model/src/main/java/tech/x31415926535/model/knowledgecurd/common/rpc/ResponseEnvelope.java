package tech.x31415926535.model.knowledgecurd.common.rpc;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class ResponseEnvelope<T> {
    @Getter
    private Integer code;
    @Getter
    private String message;
    @Getter
    private T data;

    public ResponseEnvelope(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }
}