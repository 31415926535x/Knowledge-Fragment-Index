package knowledgecurd.knowledgefragment.curd;


import knowledgecurd.knowledgefragment.mapper.KnowledgeFragmentIndexBaseInfoMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.dto.KnowledgeFragmentIndexBasicInfoDto;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * date: 2023/2/25
 * author: 31415926535x
 */
@Repository
public class KnowledgeFragmentIndexDao {

    private static final String LOG_TITLE = "KnowledgeFragmentIndexDao ";
    private static final Logger LOG = LoggerFactory.getLogger(KnowledgeFragmentIndexDao.class);


    @Resource
    private KnowledgeFragmentIndexBaseInfoMapper mapper;

    public int save(KnowledgeFragmentIndexBasicInfoDto dto) {
        Objects.requireNonNull(dto);
        int result = mapper.insert(dto);
        if (result == 0) {
            LOG.error(LOG_TITLE, "insert failed.");
        }
        return result;
    }

}

