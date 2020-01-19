package com.example.serverwebflux.serverwebflux;

import com.example.serverwebflux.entity.Personal;
import com.example.serverwebflux.repository.PersonalRepository;
import com.example.servicescore.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

/**
 * @author: cowwa
 * @Date: 2020/1/17 10:33
 * @Description: Webflux服务器推送事件
 */
@RestController("/sse")
@Api(value = "webflux服务器推送事件",description = "webflux服务器推送事件")
@Slf4j
public class SseContrller {

        @Autowired
    PersonalRepository personalRepository;

        @GetMapping("/getPesonalIntime")
        @ApiOperation(value = "sse后端服务器推送测试",notes = "sse后端服务器推送测试")
        public Flux<Personal> getPesonalIntime() throws BusinessException{
         return    Flux.interval(Duration.ofSeconds(1))
                    .map(data->personalRepository.findById("6563381487998324736").get());
        }
}
