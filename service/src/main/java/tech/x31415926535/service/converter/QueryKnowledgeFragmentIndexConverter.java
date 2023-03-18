package tech.x31415926535.service.converter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tech.x31415926535.model.knowledgecurd.common.rpc.ResponseEnvelope;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.query.KnowledgeFragmentIndexInfo;

import java.util.List;

/**
 * date: 2023/3/18
 * author: 31415926535x
 */
@Component
public class QueryKnowledgeFragmentIndexConverter {

    private static final String LOG_TITLE = "QueryKnowledgeFragmentIndexConverter";
    private static final Logger LOG = LoggerFactory.getLogger(QueryKnowledgeFragmentIndexConverter.class);


    public static ResponseEntity<ResponseEnvelope<List<KnowledgeFragmentIndexInfo>>> converter(List<KnowledgeFragmentIndexInfo> response) {
        return ResponseEntity.ok(new ResponseEnvelope<>(HttpStatus.OK.value(), HttpStatus.OK.getReasonPhrase(), response));
    }
}