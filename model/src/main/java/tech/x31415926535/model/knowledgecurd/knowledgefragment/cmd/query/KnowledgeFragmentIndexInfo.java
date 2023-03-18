package tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.query;

import lombok.Data;

import java.sql.Timestamp;

/**
 * date: 2023/3/18 22:16
 * author: 31415926535x
 */
@Data
public class KnowledgeFragmentIndexInfo {

    /**
     * 知识碎片主键
     */
    private String infoId;

    /**
     * 信息的类型（url、文章、片段、一言）
     */
    private String infoType;


    /**
     * 来源（社区、公众号、git等）
     */
    private String source;

    /**
     * 资源所在的uri
     */
    private String uri;

    /**
     * 摘要
     */
    private String summary;

    /**
     * 自定义tags（逗号分隔）
     */
    private String tags;

    /**
     * 创建时间
     */
    private Timestamp dataChangeCrateTime;

    /**
     * 数据更新时间
     */
    private Timestamp dataChangeLastTime;

}
