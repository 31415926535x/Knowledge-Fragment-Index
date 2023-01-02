package tech.x31415926535.service.converter;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tech.x31415926535.model.knowledgecurd.save.KnowledgeFragmentIndexSaveResponse;

import java.util.Objects;

/**
 * date: 2023/1/2 18:51
 * author: 31415926535x
 */
@Component
public class SaveKnowledgeFragmentIndexConverter {


    public ResponseEntity<KnowledgeFragmentIndexSaveResponse> convertSaveResponse(KnowledgeFragmentIndexSaveResponse response) {
        if (Objects.isNull(response)) {
            return ResponseEntity.internalServerError().build();
        }
        return ResponseEntity.ok(response);
    }

}
