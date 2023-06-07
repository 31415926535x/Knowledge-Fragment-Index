package tech.x31415926535.business.saveindex.converter;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.bo.KnowledgeFragmentInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.query.KnowledgeFragmentIndexInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.dto.KnowledgeFragmentIndexBasicInfoDto;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

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
        dto.setTitle(info.getTitle());
        dto.setAuthor(info.getAuthor());
        dto.setUri(info.getHref());
        dto.setSummary(info.getSummary());
        dto.setTags(info.getTags());
        return dto;
    }

    public List<KnowledgeFragmentIndexInfo> convertInfo(List<KnowledgeFragmentIndexBasicInfoDto> list) {
        return list.stream().map(l -> {
            KnowledgeFragmentIndexInfo info = new KnowledgeFragmentIndexInfo();
            info.setInfoId(l.getInfoId());
            info.setInfoType(l.getInfoType());
            info.setTags(l.getTags());
            info.setAuthor(l.getAuthor());
            info.setUri(l.getUri());
            info.setTitle(l.getTitle());
            info.setSummary(l.getSummary());
            info.setSource(l.getSource());
            info.setDataChangeLastTime(l.getDataChangeLastTime());
            info.setDataChangeCrateTime(l.getDataChangeCrateTime());
            return info;
        }).collect(Collectors.toList());
    }
}

