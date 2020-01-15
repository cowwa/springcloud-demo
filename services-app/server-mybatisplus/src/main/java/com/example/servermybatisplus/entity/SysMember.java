package com.example.servermybatisplus.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.servermybatisplus.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author cowwa
 * @since 2019-12-19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="SysMember对象", description="")
public class SysMember extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String id;


    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "昵称")
    private String nickName;

    @ApiModelProperty(value = "电话")
    private String phoneNo;

    @ApiModelProperty(value = "邮箱")
    private String email;


    @Override
    public QueryWrapper builderQueryWrapper() {
        return null;
    }
}
