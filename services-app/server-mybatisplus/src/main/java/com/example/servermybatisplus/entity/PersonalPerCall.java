package com.example.servermybatisplus.entity;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.annotation.TableField;
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
@ApiModel(value="PersonalPerCall对象", description="")
public class PersonalPerCall extends BaseEntity {

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

    @ApiModelProperty(value = "电话状态")
    private String phoneState;

    @ApiModelProperty(value = "电话类型")
    private String phoneType;

    @ApiModelProperty(value = "电话号码")
    private String phoneNo;

    @ApiModelProperty(value = "联络结果")
    private String contactResult;

    @ApiModelProperty(value = "备注")
    private String remark;

    @ApiModelProperty(value = "拨打电话次数")
    private Integer dialPhoneCount;

    @ApiModelProperty(value = "短信发送次数")
    private Integer sendMessageCount;

    @ApiModelProperty(value = "操作员")
    private String operator;

    @ApiModelProperty(value = "操作时间")
    private Date operatorTime;

    @ApiModelProperty(value = "id标识")
    private String principalId;

    @ApiModelProperty(value = "委托方")
    private String principalName;

    @ApiModelProperty(value = "欠款人证件号")
    @TableField("personal_cerNo")
    private String personalCerno;

    @Override
    public QueryWrapper builderQueryWrapper() {
        return null;
    }
}
