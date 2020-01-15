package com.example.serverspringdatajpa.webcontroller;

import com.example.serverspringdatajpa.comment.RedisSeqFactory;
import com.example.serverspringdatajpa.entity.Personal;
import com.example.serverspringdatajpa.entity.model.req.PersonalAddReq;
import com.example.serverspringdatajpa.repository.PersonalRepository;
import com.example.servicescore.BaseController;
import com.example.servicescore.exception.BusinessException;
import com.example.servicescore.response.ResponseData;
import com.querydsl.core.BooleanBuilder;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

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
@RequestMapping("/datajpa/personalController")
@Api(value = "客户信息",description = "客户信息")
public class PersonalController extends BaseController {

    @Autowired
    PersonalRepository personalRepository;

    @Autowired
    RedisSeqFactory redisSeqFactory;



    @GetMapping("/getPerosnalPage")
    @ApiOperation(value ="分页获取客户信息",notes = "分页获取客户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", dataType = "int", paramType = "query",
                    value = "页数 (0..N)"),
            @ApiImplicitParam(name = "size", dataType = "int", paramType = "query",
                    value = "每页大小."),
            @ApiImplicitParam(name = "sort", allowMultiple = true, dataType = "string", paramType = "query",
                    value = "依据什么排序: 属性名(,asc|desc). ")})
   public ResponseData<Page<Personal>> getPerosnalPage(@ApiIgnore Pageable pageable,Personal personal) throws BusinessException {
        Page<Personal> result=personalRepository.findAll(personal.builderQuery(),pageable);
      return resSuccess(result);
   }

   @ApiOperation(value = "添加客户",notes = "添加客户")
   @PostMapping("/addPersonal")
   public ResponseData<Personal> addPersonal(@Validated @RequestBody PersonalAddReq personalAddReq) throws BusinessException{
       Personal personal=new Personal();
       BeanUtils.copyProperties(personalAddReq,personal);
       personal.setId(redisSeqFactory.generateSeq());
       personalRepository.save(personal);
       return resSuccess(personal);
   }


    @GetMapping("/getDataJpaPersonal")
    @ApiOperation(value ="分页获取客户信息",notes = "分页获取客户信息")
    public ResponseData<List<Personal>> getPerosnalPage(int page, int size, Personal personal) throws BusinessException {
        Pageable pageable= PageRequest.of(page,size);
        Page<Personal> result=personalRepository.findAll(personal.builderQuery(),pageable);
        return resSuccess(result.get());
    }


}
