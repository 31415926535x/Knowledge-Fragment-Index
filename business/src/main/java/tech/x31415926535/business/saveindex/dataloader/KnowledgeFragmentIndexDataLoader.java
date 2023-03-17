package tech.x31415926535.business.saveindex.dataloader;

import knowledgecurd.knowledgefragment.curd.KnowledgeFragmentIndexDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.converter.KnowledgeFragmentInfoConverter;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.bo.KnowledgeFragmentInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.dto.KnowledgeFragmentIndexBasicInfoDto;

import javax.annotation.Resource;

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

    public void save(KnowledgeFragmentInfo info) {

        KnowledgeFragmentIndexBasicInfoDto dto = converter.convert(info);
        LOG.info(LOG_TITLE, dto);
        dao.save(dto);
    }
}



