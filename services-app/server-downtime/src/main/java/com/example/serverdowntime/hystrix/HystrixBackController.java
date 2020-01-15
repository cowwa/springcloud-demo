package com.example.serverdowntime.hystrix;

import com.example.serverdowntime.config.CloudConfigGitTest;
import com.example.servicescore.BaseController;
import com.example.servicescore.exception.BusinessException;
import com.example.servicescore.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author: cowwa
 * @Date: 2019/12/30 15:19
 * @Description:
 */
@Slf4j
@Api(value = "熔断降级",description = "熔断降级")
@RestController
public class HystrixBackController extends BaseController {

    @Autowired
    CloudConfigGitTest cloudConfigGitTest;

    @ApiOperation(value = "熔断降级返回处理",notes = "熔断降级返回处理")
    @GetMapping("/downtimeBack")
    public ResponseData downtimeBack() throws BusinessException{
        log.info("熔断服务返回处理结果");
        return resFail("80000",null);
    }

    @ApiOperation(value = "测试cloud配置中心",notes = "测试cloud配置中心")
    @GetMapping("/testCloudConfig")
    public ResponseData testCloudConfig() throws BusinessException{
        log.info("测试cloud配置中心：{}",cloudConfigGitTest.test);
        return resFail("80000",null);
    }
}
