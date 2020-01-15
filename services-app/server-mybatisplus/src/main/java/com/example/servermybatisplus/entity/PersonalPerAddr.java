package com.example.servermybatisplus.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.servermybatisplus.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
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
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="PersonalPerAddr对象", description="")
public class PersonalPerAddr extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "客户ID")
    private String personalId;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "关系")
    private String relation;

    @ApiModelProperty(value = "证件号")
    private String certificateNo;

    @ApiModelProperty(value = "单位名称")
    private String employerName;

    @ApiModelProperty(value = "地址类型")
    private String addressType;

    @ApiModelProperty(value = "地址状态")
    private String addressState;

    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "操作员")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    private Date operatorTime;

    @ApiModelProperty(value = "id标识")
    private String principalId;

    @ApiModelProperty(value = "委托方")
    private String principalName;

    @ApiModelProperty(value = "欠款人证件号")
    private String personalCerNo;

    @Override
    public QueryWrapper builderQueryWrapper() {
        return null;
    }
}
