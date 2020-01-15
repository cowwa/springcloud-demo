package com.example.servermybatisplus.model.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * @author: cowwa
 * @Date: 2019/12/19 10:11
 * @Description:
 */
@Data
public class SysMemberReq {
    @ApiModelProperty(value = "账号")
    @Pattern(regexp = "^[a-zA-Z0-9_-]{5,16}$",message = "{10000}")
    private String account;

    @ApiModelProperty(value = "密码")
    @Pattern(regexp = "^.*(?=.{6,16})(?=.*\\d)(?=.*[A-Z])(?=.*[a-z])(?=.*[!@#$%^&*? ]).*$",message = "{10001}")
    private String password;

    @ApiModelProperty(value = "昵称")
    @Size(min = 2,max = 60,message = "{10002}")
    private String nickName;

    @ApiModelProperty(value = "电话")
    @Pattern(regexp = "^((13[0-9])|(14[5|7])|(15([0-3]|[5-9]))|(18[0,5-9]))\\d{8}$|^0\\d{2,3}-?\\d{7,8}$", message = "{10003}")
    private String phoneNo;

    @ApiModelProperty(value = "邮箱")
    @Email(message = "{10004}")
    private String email;
}
