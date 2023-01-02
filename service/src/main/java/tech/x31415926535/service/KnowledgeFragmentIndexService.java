package tech.x31415926535.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.processor.SaveKnowledgeFragmentIndexProcessor;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveRequest;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveResponse;
import tech.x31415926535.service.converter.SaveKnowledgeFragmentIndexConverter;

import javax.annotation.Resource;

/**
 * date: 2023/1/2 18:39
 * author: 31415926535x
 */
@Component
public class KnowledgeFragmentIndexService {

    private static final Logger LOG = LoggerFactory.getLogger(KnowledgeFragmentIndexService.class);
    private static final String LOG_TITLE = "KnowledgeFragmentIndexService";

    @Resource
    private SaveKnowledgeFragmentIndexProcessor saveKnowledgeFragmentIndexProcessor;

    @Resource
    private SaveKnowledgeFragmentIndexConverter saveKnowledgeFragmentIndexConverter;


    public ResponseEntity<KnowledgeFragmentIndexSaveResponse> save(KnowledgeFragmentIndexSaveRequest request) {
        return saveKnowledgeFragmentIndexConverter.convertSaveResponse(saveKnowledgeFragmentIndexProcessor.save(request));
    }
}
