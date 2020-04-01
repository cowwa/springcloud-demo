package com.example.servermybatisplus.webcontroller;



import com.example.servermybatisplus.service.impl.DataDumpServiceImpl;
import com.example.servicescore.BaseController;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cowwa
 * @since 2019-12-06
 */
@RestController
@RequestMapping("/case-followup-record")
public class CaseFollowupRecordController extends BaseController {

    @Autowired
    DataDumpServiceImpl dataDumpService;


    @GetMapping("/dataDumpRecord")
    @ApiOperation(value = "转储催记信息",notes = "转储催记信息")
    public void dataDumpRecord(String index){
        dataDumpService.dataDumpRecord(index);
    }
}
