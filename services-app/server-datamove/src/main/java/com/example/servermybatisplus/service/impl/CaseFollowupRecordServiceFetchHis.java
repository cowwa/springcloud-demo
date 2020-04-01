package com.example.servermybatisplus.service.impl;

import com.example.servermybatisplus.entity.CaseFollowupRecord;
import com.example.servermybatisplus.service.ICaseFollowupRecordService;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.ScrolledPage;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * @author: cowwa
 * @Date: 2019/12/11 14:29
 * @Description:
 */
@Component
public class CaseFollowupRecordServiceFetchHis {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    ICaseFollowupRecordService caseFollowupRecordService;

    Logger logger= LoggerFactory.getLogger(CaseFollowupRecordServiceFetchHis.class);



    public void fecthData(Set<String> opersets){
        BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        // 拼接查询条件(2019-01-01之后的催记)
        queryBuilder.must(QueryBuilders.termsQuery("operBatchNumber.keyword", opersets));
        try {
            SearchQuery searchQuery = new NativeSearchQueryBuilder()
                    .withIndices("his_case_followup_record")
                    .withTypes("case_followup_record")
                    .withQuery(queryBuilder)
                    .withPageable(PageRequest.of(0, 20000))
                    .build();
            logger.info("总条数:{}",elasticsearchTemplate.count(searchQuery));
            // 滚动查询
            ScrolledPage<CaseFollowupRecord> scroll = elasticsearchTemplate.startScroll( 60000, searchQuery, CaseFollowupRecord.class);
            // 判断是否有内容
            while (scroll.hasContent()) {
                caseFollowupRecordService.dataDumpRecord(scroll.getContent());
                //取下一页，scrollId在es服务器上可能会发生变化，需要用最新的。发起continueScroll请求会重新刷新快照保留时间
                try {
                    scroll = elasticsearchTemplate.continueScroll(scroll.getScrollId(), 60000, CaseFollowupRecord.class);
                }catch (Exception e){
                    logger.error(e.getMessage().concat("滚动失败，睡眠5秒重新获取"),e);
                    Thread.sleep(5000);
                    scroll = elasticsearchTemplate.continueScroll(scroll.getScrollId(), 60000, CaseFollowupRecord.class);
                }
            }
            // 最后释放查询
            elasticsearchTemplate.clearScroll(scroll.getScrollId());
            logger.info("hiscase_followup_record获取数据完成");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
