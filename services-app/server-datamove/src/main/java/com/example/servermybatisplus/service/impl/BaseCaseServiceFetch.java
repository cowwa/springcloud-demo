package com.example.servermybatisplus.service.impl;

import com.example.servermybatisplus.entity.BaseCase;
import com.example.servermybatisplus.entity.CaseFollowupRecord;
import com.example.servermybatisplus.service.IBaseCaseService;
import com.example.servermybatisplus.service.ICaseFollowupRecordService;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.unit.TimeValue;
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

/**
 * @author: cowwa
 * @Date: 2019/12/11 14:29
 * @Description:
 */
@Component
public class BaseCaseServiceFetch {

    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    IBaseCaseService baseCaseService;

    Logger logger= LoggerFactory.getLogger(BaseCaseServiceFetch.class);



    public void fecthData(){
        try {
            SearchQuery searchQuery = new NativeSearchQueryBuilder()
                    .withIndices("base_case")
                    .withTypes("base_case")
                    .withPageable(PageRequest.of(0, 10000))
                    .build();
            // 滚动查询
            ScrolledPage<BaseCase> scroll = elasticsearchTemplate.startScroll( 60000, searchQuery, BaseCase.class);
            // 判断是否有内容
            while (scroll.hasContent()) {

                //取下一页，scrollId在es服务器上可能会发生变化，需要用最新的。发起continueScroll请求会重新刷新快照保留时间
                try {
                    scroll = elasticsearchTemplate.continueScroll(scroll.getScrollId(), 60000, BaseCase.class);
                }catch (Exception e){
                    logger.error(e.getMessage().concat("滚动失败，睡眠5秒重新获取"),e);
                    Thread.sleep(5000);
                    scroll = elasticsearchTemplate.continueScroll(scroll.getScrollId(), 60000, BaseCase.class);
                }
            }
            // 最后释放查询
            elasticsearchTemplate.clearScroll(scroll.getScrollId());
            logger.info("BaseCase获取数据完成");
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }
    }
}
