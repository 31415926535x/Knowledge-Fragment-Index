package tech.x31415926535.business.saveindex.strategies;


import tech.x31415926535.model.knowledgecurd.knowledgefragment.bo.KnowledgeFragmentInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.WebContentTypeEnum;

public interface WebContentParser {


    /**
     * 解析url并获取是哪个平台的内容（无法解析的兜底为 未知，仅保存 url+title）
     *
     * @param url 链接
     * @return 类型
     */
    WebContentTypeEnum parseUrlType(String url);

    /**
     * 爬取文章内容
     *
     * @param url
     * @return
     */
    KnowledgeFragmentInfo crawlerAndParseContent(String url);


}
