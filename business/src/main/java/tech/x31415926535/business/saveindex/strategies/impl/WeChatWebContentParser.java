package tech.x31415926535.business.saveindex.strategies.impl;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.strategies.AbstractContentParser;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.bo.KnowledgeFragmentInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.FragmentProcessStatusEnum;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.WebContentTypeEnum;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.util.Spider;

import java.time.LocalDateTime;

/**
 * date: 2023/6/7 22:58
 * author: 31415926535x
 */
@Component
public class WeChatWebContentParser extends AbstractContentParser {


    private static final String LOG_TITLE = "WeChatWebContentParser";
    private static final Logger LOG = LoggerFactory.getLogger(WeChatWebContentParser.class);

    @Override
    public WebContentTypeEnum parseUrlType(String url) {
        return StringUtils.contains(url, "mp.weixin.qq.com") ? WebContentTypeEnum.WE_CHAT : null;
    }

    @Override
    public KnowledgeFragmentInfo crawlerAndParseContent(String url) {
        String html = null;
        try {
            html = Spider.getResponseContent(url);
            LOG.info(LOG_TITLE, html);
        } catch (Exception e) {
            e.printStackTrace();
        }
        Document document = Jsoup.parse(html);
        Element titleArticle = document.getElementById("activity-name");
        Element author = document.getElementById("js_name");
        Element summary = document.getElementById("js_content");

        return KnowledgeFragmentInfo.builder()
                .title(StringUtils.trim(titleArticle.text()))
                .author(StringUtils.trim(author.text()))
                .href(url)
                .summary(StringUtils.trim(summary.text()))
                .webContentTypeEnum(WebContentTypeEnum.UNKNOWN)
                .status(FragmentProcessStatusEnum.NOT_STARTED)
                .dataChangeCreateTime(LocalDateTime.now()).build();
    }


}

