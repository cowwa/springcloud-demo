package com.example.servermybatisplus.webController;

import com.example.servermybatisplus.entity.BaseCase;
import com.example.servermybatisplus.entity.Personal;
import com.example.servermybatisplus.service.ICaseFollowupRecordService;
import com.example.servermybatisplus.service.IPersonalService;
import com.example.servermybatisplus.service.impl.CaseFollowupRecordServiceFetch;
import com.example.servermybatisplus.service.impl.PersonalDataFetchService;
import com.example.servermybatisplus.service.impl.PersonalPerAddrServiceFetch;
import com.example.servermybatisplus.service.impl.PersonalPerCallServiceFetch;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    PersonalDataFetchService personalDataFetchService;

    @Autowired
    CaseFollowupRecordServiceFetch caseFollowupRecordServiceFetch;

    @Autowired
    PersonalPerAddrServiceFetch personalPerAddrServiceFetch;

    @Autowired
    PersonalPerCallServiceFetch personalPerCallServiceFetch;

    @Autowired
    IPersonalService personalService;


    private Logger logger= LoggerFactory.getLogger(EsController.class);

    @GetMapping("/fetchDataFromEs")
    @ApiModelProperty(notes = "获取es数据",value = "获取es数据")
    public void fetchDataFromEs(){
        //personalDataFetchService.fecthData();

        //personalPerCallServiceFetch.fecthData();

        //personalPerAddrServiceFetch.fecthData();

        caseFollowupRecordServiceFetch.fecthData();
    }

}
