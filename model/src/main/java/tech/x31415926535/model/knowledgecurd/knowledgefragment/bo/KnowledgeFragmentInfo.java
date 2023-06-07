package tech.x31415926535.model.knowledgecurd.knowledgefragment.bo;

import lombok.Builder;
import lombok.Data;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.FragmentProcessStatusEnum;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.WebContentTypeEnum;

import java.time.LocalDateTime;

/**
 * date: 2023/1/2 21:37
 * author: 31415926535x
 */
@Data
@Builder
public class KnowledgeFragmentInfo {

    /**
     * 标题
     */
    private String title;

    /**
     * tag
     */
    private String tags;

    /**
     * 作者
     */
    private String author;

    /**
     * 原文链接
     */
    private String href;

    /**
     * 摘要内容
     */
    private String summary;

    /**
     * 当前处理状态
     */
    private FragmentProcessStatusEnum status;

    /**
     * 平台
     */
    private WebContentTypeEnum webContentTypeEnum;

    /**
     * 加入时间
     */
    private LocalDateTime dataChangeCreateTime;


}
