package tech.x31415926535.business.saveindex.strategies;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.strategies.impl.DefaultWebContentParser;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.WebContentTypeEnum;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;

/**
 * date: 2023/1/2 22:14
 * author: 31415926535x
 */
@Component
public class WebContentParserFactory {

    private static final Map<WebContentTypeEnum, WebContentParser> MAP = Maps.newHashMap();

    @Resource
    private DefaultWebContentParser defaultWebContentParser;

    @PostConstruct
    public void init() {
        // todo
        MAP.put(WebContentTypeEnum.UNKNOWN, defaultWebContentParser);
    }


    public static WebContentTypeEnum parseAndGetType(String url) {
        return MAP.values().stream().map(m -> m.parseUrlType(url)).findFirst().orElse(WebContentTypeEnum.UNKNOWN);
    }


    public static WebContentParser getParser(WebContentTypeEnum typeEnum) {
        return MAP.get(typeEnum);
    }


}
