package com.example.servermybatisplus.feignclients;

import com.example.servermybatisplus.entity.Personal;
import com.example.servicescore.exception.BusinessException;
import com.example.servicescore.response.ResponseData;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author: cowwa
 * @Date: 2020/1/15 14:12
 * @Description:
 */
@FeignClient("datajpa-demo")
public interface DataJpaPersonalClient {

    @RequestMapping(method = RequestMethod.GET, value = "/datajpa/personalController/getDataJpaPersonal")
    @ApiOperation(value = "分页获取客户信息", notes = "分页获取客户信息")
    ResponseData<List<Personal>> getPerosnalPage(@RequestParam("page") int page, @RequestParam("size") int size, @RequestParam("personal") Personal personal) throws BusinessException;
}