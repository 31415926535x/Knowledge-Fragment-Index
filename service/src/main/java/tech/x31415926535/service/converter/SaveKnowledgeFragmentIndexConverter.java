package tech.x31415926535.service.converter;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tech.x31415926535.model.knowledgecurd.common.rpc.ResponseEnvelope;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveResponse;

import java.util.Objects;

/**
 * date: 2023/1/2 18:51
 * author: 31415926535x
 */
@Component
public class SaveKnowledgeFragmentIndexConverter {


    public ResponseEntity<ResponseEnvelope<KnowledgeFragmentIndexSaveResponse>> convertSaveResponse(KnowledgeFragmentIndexSaveResponse response) {
        if (Objects.isNull(response)) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(new ResponseEnvelope<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), response));
    }

}
