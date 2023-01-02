package tech.x31415926535.business.saveindex.strategies.impl;

import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.strategies.AbstractContentParser;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.WebContentTypeEnum;
import tech.x31415926535.model.knowledgecurd.notion.cmd.NotionKnowledgeFragmentTable;
import tech.x31415926535.model.knowledgecurd.notion.enums.NotionFragmentStatusEnum;

import java.time.LocalDateTime;

/**
 * date: 2023/1/2 22:11
 * author: 31415926535x
 */
@Component
public class DefaultWebContentParser extends AbstractContentParser {
    @Override
    public WebContentTypeEnum parseUrlType(String url) {
        return WebContentTypeEnum.UNKNOWN;
    }

    @Override
    public NotionKnowledgeFragmentTable crawlerAndParseContent(String url) {
        return NotionKnowledgeFragmentTable.builder().title(url)
                .author("own")
                .webContentTypeEnum(WebContentTypeEnum.UNKNOWN)
                .status(NotionFragmentStatusEnum.NOT_STARTED)
                .dataChangeCreateTime(LocalDateTime.now()).build();
    }
}
