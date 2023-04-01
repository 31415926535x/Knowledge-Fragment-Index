package tech.x31415926535.business.saveindex.processor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.dataloader.KnowledgeFragmentIndexDataLoader;
import tech.x31415926535.business.saveindex.strategies.AbstractContentParser;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.bo.KnowledgeFragmentInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveRequest;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveResponse;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.SaveTransactionStatusEnum;

import javax.annotation.Resource;

/**
 * date: 2023/1/2 18:49
 * author: 31415926535x
 */
@Component
public class SaveKnowledgeFragmentIndexProcessor {


    private static final Logger LOG = LoggerFactory.getLogger(SaveKnowledgeFragmentIndexProcessor.class);
    private static final String LOG_TITLE = "SaveKnowledgeFragmentIndexProcessor";


    @Resource
    private AbstractContentParser parser;


    @Resource
    private KnowledgeFragmentIndexDataLoader dataLoader;

    public KnowledgeFragmentIndexSaveResponse save(KnowledgeFragmentIndexSaveRequest request) {

        try {
            // 1、判断是url还是单纯的文章内容; 选择合适的爬取、解析处理器
            KnowledgeFragmentInfo knowledgeFragmentInfo = parser.process(request);

            // 2、拼接模板

            // 3、保存db
            SaveTransactionStatusEnum saveTransactionStatusEnum = dataLoader.save(knowledgeFragmentInfo);

            // 4、保存到notion指定的页面中

            // 5、返回结果
            KnowledgeFragmentIndexSaveResponse result = new KnowledgeFragmentIndexSaveResponse();
            result.setSaveTransactionStatusEnum(saveTransactionStatusEnum);

            return result;
        } catch (Exception ex) {
            LOG.error(LOG_TITLE, "save failed: {}", ex);
        }
        return KnowledgeFragmentIndexSaveResponse.buildFailed();
    }
}
