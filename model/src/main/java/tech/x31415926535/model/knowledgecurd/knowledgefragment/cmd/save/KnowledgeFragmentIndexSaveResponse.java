package tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save;

import lombok.Data;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.SaveTransactionStatusEnum;

/**
 * date: 2023/1/2 18:45
 * author: 31415926535x
 */
@Data
public class KnowledgeFragmentIndexSaveResponse {

    /**
     * 保存结果
     */
    private SaveTransactionStatusEnum saveTransactionStatusEnum;
    

    public static KnowledgeFragmentIndexSaveResponse buildFailed() {
        KnowledgeFragmentIndexSaveResponse response = new KnowledgeFragmentIndexSaveResponse();
        response.setSaveTransactionStatusEnum(SaveTransactionStatusEnum.FAILED);
        return response;
    }
}
