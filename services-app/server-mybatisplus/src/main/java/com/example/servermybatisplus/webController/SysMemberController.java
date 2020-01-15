package com.example.servermybatisplus.webController;

import com.example.servermybatisplus.component.RedisSeqFactory;
import com.example.servermybatisplus.entity.SysMember;
import com.example.servermybatisplus.model.req.SysMemberReq;
import com.example.servermybatisplus.service.ISysMemberService;
import com.example.servicescore.BaseController;
import com.example.servicescore.exception.BusinessException;
import com.example.servicescore.response.ResponseData;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author cowwa
 * @since 2019-12-19
 */
@Slf4j
@Api(value = "会员控制器",description = "会员控制器")
@RestController
@RequestMapping("/sysMemberController")
public class SysMemberController extends BaseController {

    @Autowired
    RedisSeqFactory redisSeqFactory;

    @Autowired
    ISysMemberService sysMemberService;

    @ApiOperation(value = "注册",notes = "注册")
    @PostMapping("/register")
    public ResponseData<SysMemberReq> register(@Validated @RequestBody SysMemberReq sysMemberReq) throws BusinessException {
        SysMember sysMember=new SysMember();
        BeanUtils.copyProperties(sysMemberReq,sysMember);
        sysMember.setId(redisSeqFactory.generateSeq());
        sysMemberService.save(sysMember);
        return resSuccess(sysMemberReq);
    }

    @ApiOperation(value = "获取redis序列号",notes = "获取redis序列号")
    @GetMapping("/getRedisSeq")
    public ResponseData getRedisSeq() throws BusinessException{
        return resSuccess(redisSeqFactory.generateSeq());
    }

}
