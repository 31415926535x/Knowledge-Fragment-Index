package tech.x31415926535.business.saveindex.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.converter.KnowledgeFragmentInfoConverter;
import tech.x31415926535.business.saveindex.dataloader.KnowledgeFragmentIndexDataLoader;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.query.KnowledgeFragmentIndexInfo;

import javax.annotation.Resource;
import java.util.List;

/**
 * date: 2023/3/18
 * author: 31415926535x
 */
@Component
public class QueryKnowledgeFragmentIndexProcessor {

    private static final String LOG_TITLE = "QueryKnowledgeFragmentIndexProcessor";
    private static final Logger LOG = LoggerFactory.getLogger(QueryKnowledgeFragmentIndexProcessor.class);

    @Resource
    private KnowledgeFragmentIndexDataLoader dataLoader;

    @Resource
    private KnowledgeFragmentInfoConverter converter;

    public List<KnowledgeFragmentIndexInfo> queryAll() {
        return converter.convertInfo(dataLoader.queryAll());
    }
}
