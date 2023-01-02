package tech.x31415926535.service.validate;

import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import tech.x31415926535.model.knowledgecurd.common.exception.RequestValidateException;
import tech.x31415926535.model.knowledgecurd.save.KnowledgeFragmentIndexSaveRequest;

import java.util.Objects;

/**
 * date: 2023/1/2 18:57
 * author: 31415926535x
 */
@Component
public class SaveKnowledgeFragmentIndexValidate {

    public void checkSaveRequest(KnowledgeFragmentIndexSaveRequest request) {
        if (Objects.isNull(request)) {
            throw new RequestValidateException(HttpStatus.BAD_REQUEST.name(), "request is null.");
        }

        if (StringUtils.isBlank(request.getUrl())) {
            throw new RequestValidateException(HttpStatus.BAD_REQUEST.name(), "url is blank, will not process.");
        }
    }

}
