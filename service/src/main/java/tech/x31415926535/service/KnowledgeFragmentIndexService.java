package tech.x31415926535.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.processor.QueryKnowledgeFragmentIndexProcessor;
import tech.x31415926535.business.saveindex.processor.SaveKnowledgeFragmentIndexProcessor;
import tech.x31415926535.model.knowledgecurd.common.rpc.ResponseEnvelope;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.query.KnowledgeFragmentIndexInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveRequest;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveResponse;
import tech.x31415926535.service.converter.QueryKnowledgeFragmentIndexConverter;
import tech.x31415926535.service.converter.SaveKnowledgeFragmentIndexConverter;

import javax.annotation.Resource;
import java.util.List;

/**
 * date: 2023/1/2 18:39
 * author: 31415926535x
 */
@Component
public class KnowledgeFragmentIndexService {

    private static final Logger LOG = LoggerFactory.getLogger(KnowledgeFragmentIndexService.class);
    private static final String LOG_TITLE = "KnowledgeFragmentIndexService";

    @Resource
    private SaveKnowledgeFragmentIndexProcessor processor;

    @Resource
    private SaveKnowledgeFragmentIndexConverter saveKnowledgeFragmentIndexConverter;

    @Resource
    private QueryKnowledgeFragmentIndexProcessor queryKnowledgeFragmentIndexProcessor;


    public ResponseEntity<ResponseEnvelope<KnowledgeFragmentIndexSaveResponse>> save(KnowledgeFragmentIndexSaveRequest request) {
        return saveKnowledgeFragmentIndexConverter.convertSaveResponse(processor.save(request));
    }

    public ResponseEntity<ResponseEnvelope<List<KnowledgeFragmentIndexInfo>>> queryAll() {
        return QueryKnowledgeFragmentIndexConverter.converter(queryKnowledgeFragmentIndexProcessor.queryAll());
    }
}
