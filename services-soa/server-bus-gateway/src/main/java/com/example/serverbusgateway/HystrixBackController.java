package com.example.serverbusgateway;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
public class HystrixBackController {

    @ApiOperation(value = "熔断降级返回处理",notes = "熔断降级返回处理")
    @GetMapping("/downtimeBack")
    public ResponseData downtimeBack() throws Exception{
        log.info("网关熔断服务返回处理结果");
        return new ResponseData("80000","服务器繁忙，请稍后再试",null);
    }
}
