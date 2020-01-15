package com.example.servermybatisplus.webController;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.servermybatisplus.component.RedisUtil;
import com.example.servermybatisplus.entity.Personal;

import com.example.servermybatisplus.feignclients.DataJpaPersonalClient;
import com.example.servermybatisplus.service.IPersonalService;
import com.example.servicescore.BaseController;
import com.example.servicescore.exception.BusinessException;
import com.example.servicescore.response.ResponseData;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;


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
@RequestMapping("/test/personal")
public class PersonalController extends BaseController {

    @Autowired
    IPersonalService personalService;

    @Autowired
    RedisUtil redisUtil;

    @Autowired
    DataJpaPersonalClient dataJpaPersonalClient;



    @GetMapping("/getPerosnalPage")
    @ApiOperation(value ="分页获取客户信息",notes = "分页获取客户信息")
   public ResponseData<IPage<Personal>> getPerosnalPage(Personal personal) throws BusinessException {
        StopWatch stopWatch=new StopWatch();
        stopWatch.start();
      getHttpSession().setAttribute("test","aaaaa");
        IPage<Personal> iPage=  personalService.page(personal.builderPage(),personal.builderQueryWrapper());
        stopWatch.stop();
      return resSuccess(iPage);
   }

    @GetMapping("/getDataJpaPersonl")
    @ApiOperation(value ="feginClient获取客户信息",notes = "feginClient获取客户信息")
    public ResponseData<List<Personal>> getDataJpaPersonl(Personal personal) throws BusinessException {
        ResponseData<List<Personal>> responseData=dataJpaPersonalClient.getPerosnalPage(0,20,personal);
        return responseData;
    }


}
