package tech.x31415926535.business.saveindex.processor;

import org.springframework.stereotype.Component;
import tech.x31415926535.model.knowledgecurd.save.KnowledgeFragmentIndexSaveRequest;
import tech.x31415926535.model.knowledgecurd.save.KnowledgeFragmentIndexSaveResponse;

/**
 * date: 2023/1/2 18:49
 * author: 31415926535x
 */
@Component
public class SaveKnowledgeFragmentIndexProcessor {


    public KnowledgeFragmentIndexSaveResponse save(KnowledgeFragmentIndexSaveRequest request) {
        // 1、判断是url还是单纯的文章内容

        // 2、选择合适的爬取、解析处理器

        // 3、拼接模板

        // 4、保存到notion指定的页面中

        // 5、返回结果
        return null;
    }
}
