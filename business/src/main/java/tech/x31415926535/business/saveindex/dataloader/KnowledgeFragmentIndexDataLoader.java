package tech.x31415926535.business.saveindex.dataloader;

import knowledgecurd.knowledgefragment.curd.KnowledgeFragmentIndexDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.converter.KnowledgeFragmentInfoConverter;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.bo.KnowledgeFragmentInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.dto.KnowledgeFragmentIndexBasicInfoDto;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.SaveTransactionStatusEnum;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

/**
 * date: 2023/2/25
 * author: 31415926535x
 */
@Component
public class KnowledgeFragmentIndexDataLoader {

    private static final String LOG_TITLE = "KnowledgeFragmentIndexDataLoader";
    private static final Logger LOG = LoggerFactory.getLogger(KnowledgeFragmentIndexDataLoader.class);

    @Resource
    private KnowledgeFragmentInfoConverter converter;

    @Resource
    private KnowledgeFragmentIndexDao dao;

    public SaveTransactionStatusEnum save(KnowledgeFragmentInfo info) {

        KnowledgeFragmentIndexBasicInfoDto dto = converter.convert(info);
        LOG.info(LOG_TITLE, dto);
        KnowledgeFragmentIndexBasicInfoDto dbInfo = dao.queryFirst(dto.getUri());
        if (Objects.isNull(dbInfo)) {
            int result = 0;
            try {
                result = dao.save(dto);
            } catch (Exception ex) {
                LOG.error(LOG_TITLE, "save failed.");
            }
            if (result != 0) {
                return SaveTransactionStatusEnum.SUCCEED;
            }
            return SaveTransactionStatusEnum.FAILED;
        } else {
            LOG.info(LOG_TITLE, "exist uri");
            return SaveTransactionStatusEnum.REPEAT_INFO;
        }
    }

    public List<KnowledgeFragmentIndexBasicInfoDto> queryAll() {
        return dao.queryAll();
    }
}



