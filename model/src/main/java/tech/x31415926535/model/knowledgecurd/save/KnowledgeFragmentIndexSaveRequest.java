package tech.x31415926535.model.knowledgecurd.save;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * date: 2023/1/2 18:26
 * author: 31415926535x
 */
@Data
@ApiModel("保存碎片")
public class KnowledgeFragmentIndexSaveRequest {

    @ApiModelProperty("链接/文章内容")
    private String url;

}
