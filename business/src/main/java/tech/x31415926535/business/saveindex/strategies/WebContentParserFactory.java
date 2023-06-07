package tech.x31415926535.business.saveindex.strategies;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;
import tech.x31415926535.business.saveindex.strategies.impl.CsdnWebContentParser;
import tech.x31415926535.business.saveindex.strategies.impl.DefaultWebContentParser;
import tech.x31415926535.business.saveindex.strategies.impl.WeChatWebContentParser;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.enums.save.WebContentTypeEnum;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.util.Map;
import java.util.Objects;

/**
 * date: 2023/1/2 22:14
 * author: 31415926535x
 */
@Component
public class WebContentParserFactory {

    private static final Map<WebContentTypeEnum, WebContentParser> MAP = Maps.newHashMap();

    @Resource
    private DefaultWebContentParser defaultWebContentParser;

    @Resource
    private CsdnWebContentParser csdnWebContentParser;

    @Resource
    private WeChatWebContentParser weChatWebContentParser;

    @PostConstruct
    public void init() {
        // todo
        MAP.put(WebContentTypeEnum.CSDN, csdnWebContentParser);
        MAP.put(WebContentTypeEnum.WE_CHAT, weChatWebContentParser);
        MAP.put(WebContentTypeEnum.UNKNOWN, defaultWebContentParser);
    }


    public static WebContentTypeEnum parseAndGetType(String url) {
        return MAP.values().stream().map(m -> m.parseUrlType(url)).filter(Objects::nonNull).findFirst().orElse(WebContentTypeEnum.UNKNOWN);
    }


    public static WebContentParser getParser(WebContentTypeEnum typeEnum) {
        return MAP.get(typeEnum);
    }


}
