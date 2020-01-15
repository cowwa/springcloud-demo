package com.example.servermybatisplus.service.impl;

import com.example.servermybatisplus.entity.CaseFollowupRecord;
import com.example.servermybatisplus.entity.PersonalPerAddr;
import com.example.servermybatisplus.service.ICaseFollowupRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author: cowwa
 * @Date: 2019/12/11 14:29
 * @Description:
 */
@Component
public class CaseFollowupRecordServiceFetch {


    //ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    ICaseFollowupRecordService caseFollowupRecordService;

    Logger logger= LoggerFactory.getLogger(CaseFollowupRecordServiceFetch.class);


    @Async("asyncServiceExecutor")
    public void fecthData(){
       /* BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        // 拼接查询条件
        //queryBuilder.must(QueryBuilders.termQuery("status", 1));
        try {
            SearchQuery searchQuery = new NativeSearchQueryBuilder()
                    .withIndices("his_case_followup_record_01")
                    .withTypes("case_followup_record")
                    .withQuery(queryBuilder)
                    .withPageable(PageRequest.of(0, 1000))
                    .build();
            // 滚动查询
            ScrolledPage<CaseFollowupRecord> scroll = elasticsearchTemplate.startScroll( 5000, searchQuery, CaseFollowupRecord.class);
            // 判断是否有内容
            while (scroll.hasContent()) {
                caseFollowupRecordService.dataDumpRecord(scroll.getContent());
                //取下一页，scrollId在es服务器上可能会发生变化，需要用最新的。发起continueScroll请求会重新刷新快照保留时间
                scroll = elasticsearchTemplate.continueScroll(scroll.getScrollId(), 5000, CaseFollowupRecord.class);
            }
            // 最后释放查询
            elasticsearchTemplate.clearScroll(scroll.getScrollId());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }*/
    }
}
