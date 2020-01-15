package com.example.servermybatisplus.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.servermybatisplus.common.BaseEntity;
import com.google.common.base.Strings;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author cowwa
 * @since 2019-12-09
 */
@Data
@Accessors(chain = true)
@ApiModel(value="Personal对象", description="")
public class Personal extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String id;

    private String personalName;

    private String personalAccount;

    private String certificateType;

    private String certificateNo;

    private String sex;

    private Date birthday;

    private String departmentPost;

    private String selfPhoneNo;

    private String homePhoneNo;

    private String employerPhoneNo;

    private String employerPhoneNoSub;

    private String employerName;

    private String residenceAddr;

    private String homeAddr;

    private String emailAddr;

    private String billAddr;

    private String principalId;

    private String principalName;


    @Override
    public QueryWrapper builderQueryWrapper() {
        QueryWrapper<Personal> queryWrapper=new QueryWrapper<>();
        if(!Strings.isNullOrEmpty(certificateNo)){
            queryWrapper.eq("certificate_no",certificateNo);
        }
        if(!Strings.isNullOrEmpty(homePhoneNo)){
            queryWrapper.eq("home_phone_no",homePhoneNo);
        }
        return queryWrapper;
    }
}
