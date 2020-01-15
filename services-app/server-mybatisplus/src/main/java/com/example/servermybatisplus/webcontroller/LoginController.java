package com.example.servermybatisplus.webcontroller;

import com.example.servicescore.BaseController;
import com.example.servicescore.exception.BusinessException;
import com.example.servicescore.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author: cowwa
 * @Date: 2019/12/18 11:07
 * @Description:
 */
@Slf4j
@Api(value = "系统登录",description = "系统登录")
@RestController("/loginController")
public class LoginController extends BaseController {



    @ApiOperation(value = "系统登录",notes = "系统登录")
    @PostMapping("/login")
    public ResponseData login(HttpServletRequest request) throws BusinessException {
    return resSuccess(request.getSession().getId());
    }
}
