package com.example.servermybatisplus.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
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
 * @since 2020-03-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("BASE_CASE")
@ApiModel(value="BaseCase对象", description="")
public class BaseCase extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @TableField("ID")
    private String id;

    @ApiModelProperty(value = "批次号")
    @TableField("BATCH_NUMBER")
    private String batchNumber;

    @ApiModelProperty(value = "外包序号")
    @TableField("BATCH_NO")
    private String batchNo;

    @ApiModelProperty(value = "委案日期")
    @TableField("DELEGATION_DATE")
    private Date delegationDate;

    @ApiModelProperty(value = "委案城市")
    @TableField("CITY")
    private String city;

    @ApiModelProperty(value = "案件编号")
    @TableField("CASE_NUMBER")
    private String caseNumber;

    @ApiModelProperty(value = "客户ID")
    @TableField("PERSONAL_ID")
    private String personalId;

    @ApiModelProperty(value = "姓名")
    @TableField("PERSONAL_NAME")
    private String personalName;

    @ApiModelProperty(value = "证件号")
    @TableField("CERTIFICATE_NO")
    private String certificateNo;

    @ApiModelProperty(value = "帐号")
    @TableField("ACCOUNT")
    private String account;

    @ApiModelProperty(value = "手别")
    @TableField("HANDS_NUMBER")
    private String handsNumber;

    @ApiModelProperty(value = "进入催收日期")
    @TableField("REMINDERS_DATE")
    private Date remindersDate;

    @ApiModelProperty(value = "币种")
    @TableField("CURRENCY")
    private String currency;

    @ApiModelProperty(value = "逾期期数")
    @TableField("OVERDUE_PERIODS")
    private BigDecimal overduePeriods;

    @ApiModelProperty(value = "逾期天数")
    @TableField("OVERDUE_DAYS")
    private BigDecimal overdueDays;

    @ApiModelProperty(value = "卡号")
    @TableField("CARD_NO")
    private String cardNo;

    @ApiModelProperty(value = "委案金额(人民币)")
    @TableField("OVERDUE_AMT_TOTAL")
    private Float overdueAmtTotal;

    @ApiModelProperty(value = "委案总金额(美元)")
    @TableField("OVERDUE_AMT_AOTAL_DOLLAR")
    private Float overdueAmtAotalDollar;

    @ApiModelProperty(value = "欠款(人民币)")
    @TableField("LEFT_AMT")
    private Float leftAmt;

    @ApiModelProperty(value = "欠款(美元)")
    @TableField("LEFT_AMT_DOLLAR")
    private Float leftAmtDollar;

    @ApiModelProperty(value = "委托方id标")
    @TableField("PRINCIPAL_ID")
    private String principalId;

    @ApiModelProperty(value = "委托方")
    @TableField("PRINCIPAL_NAME")
    private String principalName;

    @ApiModelProperty(value = "流入日期")
    @TableField("FOLLOWIN_TIME")
    private Date followinTime;

    @ApiModelProperty(value = "操作时间")
    @TableField("OPERATOR_TIME")
    private Date operatorTime;


    @Override
    public QueryWrapper builderQueryWrapper() {
        return null;
    }
}
