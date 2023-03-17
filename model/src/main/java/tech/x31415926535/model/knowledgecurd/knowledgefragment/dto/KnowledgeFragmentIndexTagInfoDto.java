package tech.x31415926535.model.knowledgecurd.knowledgefragment.dto;

import lombok.Data;

import java.sql.Timestamp;

/**
 * date: 2023/2/25 20:58
 * author: 31415926535x
 */
@Data
public class KnowledgeFragmentIndexTagInfoDto {

    /**
     * 自增主键
     */
    private Long Id;

    /**
     * 知识碎片Tag主键(uuid)
     */
    private String tagId;

    /**
     * tag
     */
    private String tag;

    /**
     * 创建时间
     */
    private Timestamp dataChangeCrateTime;

    /**
     * 数据更新时间
     */
    private Timestamp dataChangeLastTime;


}
