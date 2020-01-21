package com.example.serverwebflux.webcontroller;


import com.example.serverwebflux.entity.Personal;
import com.example.serverwebflux.repository.PersonalRepository;
import com.example.servicescore.BaseController;
import com.example.servicescore.exception.BusinessException;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cowwa
 * @since 2019-12-09
 */
@Slf4j
@RestController
@RequestMapping("/webflux/personalController")
@Api(value = "客户信息",description = "客户信息")
public class PersonalController extends BaseController {

    @Autowired
    PersonalRepository personalRepository;



    @GetMapping(value = "/getWebFluxPersonal", produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
    @ApiOperation(value ="分页获取客户信息",notes = "分页获取客户信息")
    public Mono<Personal> getPerosnalPage() throws BusinessException {
     return Mono.justOrEmpty(personalRepository.findById("6563381487998324736"));
    }

    @GetMapping(value = "/testWebFlux")
    @ApiOperation(value ="测试webClient",notes = "测试webClient")
    public Mono<Personal> testWebFlux(){
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();

            Mono<Personal> bodyMono = WebClient.create().get().uri("http://localhost:8760/mybatisplus-demo/test/personal/getPersonalMono")
                    .accept(MediaType.APPLICATION_JSON).retrieve().bodyToMono(Personal.class);
         return bodyMono;
    }


}
