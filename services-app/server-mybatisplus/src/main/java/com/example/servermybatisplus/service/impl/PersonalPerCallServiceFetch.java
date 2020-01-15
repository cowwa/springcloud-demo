package com.example.servermybatisplus.service.impl;

import com.example.servermybatisplus.entity.CaseFollowupRecord;
import com.example.servermybatisplus.entity.PersonalPerCall;
import com.example.servermybatisplus.service.IPersonalPerCallService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

/**
 * @author: cowwa
 * @Date: 2019/12/11 14:32
 * @Description:
 */
@Component
public class PersonalPerCallServiceFetch {

   /* @Autowired
    ElasticsearchTemplate elasticsearchTemplate;*/

    @Autowired
    IPersonalPerCallService personalPerCallService;

    Logger logger= LoggerFactory.getLogger(PersonalPerCallServiceFetch.class);

    @Async("asyncServiceExecutor")
    public void fecthData(){
        /*BoolQueryBuilder queryBuilder = QueryBuilders.boolQuery();
        // 拼接查询条件
        //queryBuilder.must(QueryBuilders.termQuery("status", 1));
        try {
            SearchQuery searchQuery = new NativeSearchQueryBuilder()
                    .withIndices("personal_per_call_01")
                    .withTypes("personal_per_call")
                    .withQuery(queryBuilder)
                    .withPageable(PageRequest.of(0, 1000))
                    .build();
            // 滚动查询
            ScrolledPage<PersonalPerCall> scroll = elasticsearchTemplate.startScroll(5000, searchQuery, PersonalPerCall.class);
            // 判断是否有内容
            while (scroll.hasContent()) {
                personalPerCallService.dataDumpRecord(scroll.getContent());
                //取下一页，scrollId在es服务器上可能会发生变化，需要用最新的。发起continueScroll请求会重新刷新快照保留时间
                scroll = elasticsearchTemplate.continueScroll(scroll.getScrollId(), 5000, PersonalPerCall.class);
            }
            // 最后释放查询
            elasticsearchTemplate.clearScroll(scroll.getScrollId());
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
        }*/
    }

}
