package tech.x31415926535.business.saveindex.converter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.bo.KnowledgeFragmentInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.dto.KnowledgeFragmentIndexBasicInfoDto;

import java.util.UUID;

/**
 * date: 2023/2/25
 * author: 31415926535x
 */
@Component
public class KnowledgeFragmentInfoConverter {

    private static final String LOG_TITLE = " KnowledgeFragmentInfoConverter ";
    private static final Logger LOG = LoggerFactory.getLogger(KnowledgeFragmentInfoConverter.class);

    public KnowledgeFragmentIndexBasicInfoDto convert(KnowledgeFragmentInfo info) {
        KnowledgeFragmentIndexBasicInfoDto dto = new KnowledgeFragmentIndexBasicInfoDto();
        dto.setInfoId(UUID.randomUUID().toString());
        dto.setInfoType(info.getWebContentTypeEnum().getType());
        // dto.setSource(info);
        dto.setUri(info.getHref());
        // dto.setSummary(info.get);
        dto.setTags(info.getTags());
        return dto;
    }

}

