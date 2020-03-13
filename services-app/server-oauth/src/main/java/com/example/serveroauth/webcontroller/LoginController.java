package com.example.serveroauth.webcontroller;

import com.example.servicescore.BaseController;
import com.example.servicescore.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：LoginController
 * 类 描 述：TODO
 * 创建时间：2020/3/13 17:52
 * 创 建 人：cowwa
 * @author cowwa
 */
@RestController("/api/loginController")
@Api(value = "登录")
@Slf4j
public class LoginController extends BaseController {

    @PostMapping("/login")
    @ApiOperation(value = "系统登录",notes = "系统登录")
    public ResponseData login(){
        return resSuccess();
    }
}
