package tech.x31415926535.model.knowledgecurd.notion.cmd;

import lombok.Builder;
import lombok.Data;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.WebContentTypeEnum;
import tech.x31415926535.model.knowledgecurd.notion.enums.NotionFragmentStatusEnum;

import java.time.LocalDateTime;

/**
 * date: 2023/1/2 21:37
 * author: 31415926535x
 */
@Data
@Builder
public class NotionKnowledgeFragmentTable {

    /**
     * 标题
     */
    private String title;

    /**
     * tag
     */
    private String tag;

    /**
     * 作者
     */
    private String author;

    /**
     * 原文链接
     */
    private String href;

    /**
     * 当前处理状态
     */
    private NotionFragmentStatusEnum status;

    /**
     * 平台
     */
    private WebContentTypeEnum webContentTypeEnum;

    /**
     * 加入时间
     */
    private LocalDateTime dataChangeCreateTime;


}
