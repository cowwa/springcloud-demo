package com.example.serveroauth.webcontroller;

import com.example.serveroauth.repository.PermissionRepository;
import com.example.servicescore.BaseController;
import com.example.servicescore.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 项目名称：springcloud-demo
 * 类 名 称：LoginController
 * 类 描 述：TODO
 * 创建时间：2020/3/13 17:52
 * 创 建 人：cowwa
 * @author cowwa
 */
@Controller("/api/loginController")
@Api(value = "登录")
@Slf4j
public class LoginController extends BaseController {

    @Autowired
    PermissionRepository permissionRepository;

    @RequestMapping("/login")
    @ApiOperation(value = "系统登录",notes = "系统登录")
    public String login(){
        return "login";
    }

    @RequestMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @RequestMapping("/index")
    public String index() {
        return "index";
    }

    @RequestMapping("/login-error")
    public String loginError(Model model) {
        model.addAttribute( "loginError"  , true);
        return "login";
    }

    @GetMapping("/401")
    public String accessDenied() {
        return "401";
    }

    @GetMapping("/user/common")
    public String common() {
        return "user/common";
    }

    @GetMapping("/user/admin")
    public String admin() {
        return "user/admin";
    }


}
