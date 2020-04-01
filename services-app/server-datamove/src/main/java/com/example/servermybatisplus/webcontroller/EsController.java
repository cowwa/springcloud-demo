package com.example.servermybatisplus.webcontroller;

import com.example.servermybatisplus.entity.ImportDataExcelRecord;
import com.example.servermybatisplus.service.ICaseFollowupRecordService;
import com.example.servermybatisplus.service.impl.BaseCaseServiceFetch;
import com.example.servermybatisplus.service.impl.BaseCaseServiceFetchHis;
import com.example.servermybatisplus.service.impl.CaseFollowupRecordServiceFetch;
import com.example.servermybatisplus.service.impl.CaseFollowupRecordServiceFetchHis;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author: cowwa
 * @Date: 2019/12/5 17:44
 * @Description:
 */
@RestController
@RequestMapping("/es")
@Api(value = "操作es数据库", description = "操作es数据库")
public class EsController {

    @Autowired
    ICaseFollowupRecordService caseFollowupRecordService;


    @Autowired
    CaseFollowupRecordServiceFetch caseFollowupRecordServiceFetch;

    @Autowired
    CaseFollowupRecordServiceFetchHis caseFollowupRecordServiceFetchHis;

    @Autowired
    BaseCaseServiceFetch baseCaseServiceFetch;


    @Autowired
    BaseCaseServiceFetchHis baseCaseServiceFetchHis;

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;


    private Logger logger= LoggerFactory.getLogger(EsController.class);

    @GetMapping("/fetchDataFromEs")
    @ApiModelProperty(notes = "获取es数据",value = "获取es数据")
    @Async("asyncServiceExecutor")
    public void fetchDataFromEs(){

        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        // 拼接查询条件(2019-01-01之后的催记)
        queryBuilder.must(QueryBuilders.matchQuery("importDataExcelStatus.keyword","CONFIRMED"));
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withIndices("import_data_excel_record")
                .withTypes("import_data_excel_record")
                .withQuery(queryBuilder)
                .withPageable(PageRequest.of(0, 1000))
                .build();
        List<ImportDataExcelRecord> list=  elasticsearchTemplate.queryForList(searchQuery, ImportDataExcelRecord.class);
        Set<String> operSets=new HashSet<>();
        list.forEach(importDataExcelRecord -> {
            operSets.add(importDataExcelRecord.getSeqNo());
        });
        logger.info("获取拉取数据的批次号:size:{},{}",operSets.size(),operSets);

        logger.info("移动record");
        caseFollowupRecordServiceFetch.fecthData();
        logger.info("移动recordHIS");
        caseFollowupRecordServiceFetchHis.fecthData(operSets);
        logger.info("移动base");
        baseCaseServiceFetch.fecthData();
        logger.info("移动baseHis");
        baseCaseServiceFetchHis.fecthData(operSets);

    }

}
