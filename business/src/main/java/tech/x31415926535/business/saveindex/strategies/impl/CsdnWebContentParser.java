package tech.x31415926535.business.saveindex.strategies.impl;

import org.apache.commons.lang3.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
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
 * date: 2023/6/7 22:53
 * author: 31415926535x
 */
@Component
public class CsdnWebContentParser extends AbstractContentParser {


    private static final String LOG_TITLE = "CsdnWebContentParser";
    private static final Logger LOG = LoggerFactory.getLogger(CsdnWebContentParser.class);

    @Override
    public WebContentTypeEnum parseUrlType(String url) {
        return StringUtils.contains(url, "csdn") ? WebContentTypeEnum.CSDN : null;
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
        Elements titleArticle = document.getElementsByClass("title-article");
        Elements articleType = document.getElementsByClass("article-type");
        Element summary = document.getElementById("article_content");
        Elements readCount = document.getElementsByClass("read-count");
        Elements author = document.getElementsByClass("follow-nickName ");
        return KnowledgeFragmentInfo.builder()
                .href(url)
                .author(author.text())
                .title(titleArticle.text())
                .summary(summary.text())
                .webContentTypeEnum(WebContentTypeEnum.UNKNOWN)
                .status(FragmentProcessStatusEnum.NOT_STARTED)
                .dataChangeCreateTime(LocalDateTime.now()).build();
    }


}
