package com.example.serverwebflux.serverwebflux;

import com.example.serverwebflux.entity.Personal;
import com.example.serverwebflux.repository.PersonalRepository;
import com.example.servicescore.exception.BusinessException;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.codec.ServerSentEvent;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.time.LocalTime;

/**
 * @author: cowwa
 * @Date: 2020/1/17 10:33
 * @Description: Webflux服务器推送事件
 * 参考文件：https://www.baeldung.com/spring-server-sent-events
 */
@RestController("/sse")
@Api(value = "webflux服务器推送事件",description = "webflux服务器推送事件")
@Slf4j
public class SseContrller {

        @Autowired
    PersonalRepository personalRepository;

    /**
     * 采用ServerSentEvent 事件实现服务器推送,验证方式：http://localhost:8091/stream-sse
     * 指定了事件ID、事件名称、及数据
     * 在SSE事件中只支持UTF-8的文本流，不建议使用二进制流
     * 此种方式好处：
     * 1、可以忽略"text/event-stream"，吗，媒体类型
     * 2、处理我们需要的元数据
     * @return
     */
    @GetMapping("/stream-sse")
    public Flux<ServerSentEvent<Personal>> streamEvents() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> ServerSentEvent.<Personal> builder()
                        .id(String.valueOf(sequence))
                        .event("personal-event")
                        .data(personalRepository.findById("6563381487998324736").get())
                        .build());
    }

    /**
     * 通过Flux实现流事件，主要需要指定MediaType为：TEXT_EVENT_STREAM_VALUE
     */
    @GetMapping(path = "/stream-flux", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Personal> streamFlux() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(sequence -> personalRepository.findById("6563381487998324736").get());
    }

    /**
     *  此种方式是一个阻塞式的和一般的和HTTP请求无异
     * @return
     * @throws BusinessException
     */
    @GetMapping("/testFlux")
    @ApiOperation(value = "测试Flux",notes = "测试Flux")
        public Mono<Personal> testFlux() throws BusinessException{
         return   Mono.just(personalRepository.findById("6563381487998324736").get());
        }
}
