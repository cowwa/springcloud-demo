package com.example.serverspringdatajpa.entity.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @author: cowwa
 * @Date: 2020/1/3 14:30
 * @Description:
 */
@Data
public class PersonalAddReq {

    @ApiModelProperty(value = "姓名")
    @Size(min = 2,max = 20,message = "{10001}")
    private String personalName;

    @NotBlank(message = "{10002}")
    private String personalAccount;

    private String certificateType;

    private String certificateNo;

    private String sex;

    private String selfPhoneNo;

}
