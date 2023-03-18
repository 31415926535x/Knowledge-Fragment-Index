package tech.x31415926535.web.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tech.x31415926535.model.knowledgecurd.common.rpc.ResponseEnvelope;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.query.KnowledgeFragmentIndexInfo;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveRequest;
import tech.x31415926535.model.knowledgecurd.knowledgefragment.cmd.save.KnowledgeFragmentIndexSaveResponse;
import tech.x31415926535.service.KnowledgeFragmentIndexService;
import tech.x31415926535.service.validate.SaveKnowledgeFragmentIndexValidate;

import javax.annotation.Resource;
import java.util.List;

/**
 * date: 2023/1/2 18:05
 * author: 31415926535x
 */
@RequestMapping("/knowledge")
@RestController
@ResponseBody
@Api(value = "知识碎片服务接口")
public class KnowledgeFragmentIndexHandler {

    private static final Logger LOG = LoggerFactory.getLogger(KnowledgeFragmentIndexHandler.class);
    private static final String LOG_TITLE = "KnowledgeFragmentIndexHandler";

    @Resource
    private KnowledgeFragmentIndexService service;

    @Resource
    private SaveKnowledgeFragmentIndexValidate validate;

    @ApiOperation("服务健康检查")
    @GetMapping("/checkHealth")
    public ResponseEntity<String> checkHealth() {
        return ResponseEntity.ok().body("checkHealthSucceed");
    }

    @ApiOperation("保存知识碎片")
    @PostMapping("/save")
    public ResponseEntity<ResponseEnvelope<KnowledgeFragmentIndexSaveResponse>> save(@RequestBody KnowledgeFragmentIndexSaveRequest request) {
        LOG.info(LOG_TITLE, request);

        validate.checkSaveRequest(request);

        return service.save(request);
    }


    @ApiOperation("查询所有内容")
    @PostMapping("/queryAll")
    public ResponseEntity<ResponseEnvelope<List<KnowledgeFragmentIndexInfo>>> queryAll() {
        return service.queryAll();
    }

}
