package com.example.serverdowntime.hystrix;

import com.example.servicescore.BaseController;
import com.example.servicescore.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author: cowwa
 * @Date: 2020/1/2 16:11
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping("/TestController")
@Api(value = "测试",description = "测试")
public class TestController extends BaseController {

    @ApiOperation(value = "测试限流",notes = "测试限流")
    @GetMapping("/testRateLimiter")
    public void testRateLimiter(){
        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();

        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();

        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();

        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();

        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();

        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();

        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();

        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();

        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();

        new Thread( () -> {
            for(int i=0;i<100;i++){
                RestTemplate restTemplate=new RestTemplate();
                restTemplate.getForEntity("http://192.168.3.68:8760/mybatisplus-demo/sysMemberController/getRedisSeq",ResponseData.class);
            }
        }).start();



    }
}
