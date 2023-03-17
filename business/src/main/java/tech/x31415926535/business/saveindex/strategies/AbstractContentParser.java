package tech.x31415926535.business.saveindex.strategies;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.bo.KnowledgeFragmentInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveRequest;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.WebContentTypeEnum;


/**
 * date: 2023/1/2 21:33
 * author: 31415926535x
 */
@Component
public abstract class AbstractContentParser implements WebContentParser {


    private static final Logger LOG = LoggerFactory.getLogger(AbstractContentParser.class);
    private static final String LOG_TITLE = "AbstractContentParser";


    public KnowledgeFragmentInfo process(KnowledgeFragmentIndexSaveRequest request) {

        // 1、解析入参，并选择合适的策略类
        WebContentTypeEnum webContentTypeEnum = WebContentParserFactory.parseAndGetType(request.getUrl());
        LOG.info(LOG_TITLE, "parse type is: {}", webContentTypeEnum.getType());
        WebContentParser parser = WebContentParserFactory.getParser(webContentTypeEnum);

        // 2、爬取获取网页上所有的内容; 转换、提取所需要的内容
        KnowledgeFragmentInfo result = parser.crawlerAndParseContent(request.getUrl());

        // 4、build done
        LOG.info(LOG_TITLE, "parse content is: {}", result);

        return result;
    }


    /**
     * 解析url并获取是哪个平台的内容（无法解析的兜底为 未知，仅保存 url+title）
     *
     * @param url 链接
     * @return 类型
     */
    @Override
    public abstract WebContentTypeEnum parseUrlType(String url);

    /**
     * 爬取文章内容
     *
     * @param url
     * @return
     */
    @Override
    public abstract KnowledgeFragmentInfo crawlerAndParseContent(String url);

}
