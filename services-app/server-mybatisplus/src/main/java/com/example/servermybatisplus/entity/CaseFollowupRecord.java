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
 * @since 2019-12-06
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="CaseFollowupRecord对象", description="")
public class CaseFollowupRecord extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "ID")
    private String id;

    @ApiModelProperty(value = "客户信息ID")
    private String personalId;

    @ApiModelProperty(value = "证件号")
    private String certificateNo;

    @ApiModelProperty(value = "操作批次号")
    private String operBatchNumber;

    @ApiModelProperty(value = "委案日期")
    private Date delegationDate;

    @ApiModelProperty(value = "委托方id标")
    private String principalId;

    @ApiModelProperty(value = "案件信息ID")
    private Long caseId;

    @ApiModelProperty(value = "联络对象/联系状态/联络人")
    private String target;

    @ApiModelProperty(value = "联络对象姓名")
    private String targetName;

    @ApiModelProperty(value = "催收日期")
    private Date followTime;

    @ApiModelProperty(value = "行动代码/联络结果/电催摘要/催收代码")
    private String contactResult;

    @ApiModelProperty(value = "行动代码CODE")
    private String contactResultCode;

    @ApiModelProperty(value = "外访摘要")
    private String collectionOutResult;

    @ApiModelProperty(value = "催收状态")
    private String collectionStatus;

    @ApiModelProperty(value = "催收方式/催收措施")
    private String collectionType;

    @ApiModelProperty(value = "催收方式Code/催收措施")
    private String collectionTypeCode;

    @ApiModelProperty(value = "电话类型/联络类型/联系类型")
    private String phoneType;

    @ApiModelProperty(value = "电话号码/(号码/地址)/(电话/地址)")
    private String contactPhone;

    @ApiModelProperty(value = "号码状态")
    private String contactState;

    @ApiModelProperty(value = "地址状态")
    private String addrStatus;

    @ApiModelProperty(value = "地址类型")
    private String addrType;

    @ApiModelProperty(value = "详细地址")
    private String detail;

    @ApiModelProperty(value = "跟进内容")
    private String content;

    @ApiModelProperty(value = "快捷录入")
    private String quickRecord;

    @ApiModelProperty(value = "承诺还款标识 0-没有承诺 1-有承诺")
    private Integer promiseFlag;

    @ApiModelProperty(value = "承诺还款金额")
    private Double promiseAmt;

    @ApiModelProperty(value = "承诺还款日期")
    private Date promiseDate;

    @ApiModelProperty(value = "已还款金额")
    private Double hasPaymentAmt;

    @ApiModelProperty(value = "已还款日期")
    private Date hasPaymentDate;

    @ApiModelProperty(value = "下次跟进日期")
    private Date follNextDate;

    @ApiModelProperty(value = "跟进备注")
    private String remark;

    @ApiModelProperty(value = "信息更新")
    private String informationUpdate;

    @ApiModelProperty(value = "跟进记录")
    private String contentView;

    @ApiModelProperty(value = "操作人")
    private String operator;

    @ApiModelProperty(value = "操作人工号")
    private String operatorUserName;

    @ApiModelProperty(value = "操作人姓名")
    private String operatorName;

    @ApiModelProperty(value = "操作人部门")
    private String operatorDeptName;

    @ApiModelProperty(value = "操作时间")
    private Date operatorTime;

    @ApiModelProperty(value = "是否还款")
    private String isPaid;

    @ApiModelProperty(value = "是否协商减免")
    private String isRemit;

    @ApiModelProperty(value = "减免状态")
    private String remitState;

    @ApiModelProperty(value = "减免金额")
    private Double remitAmt;

    @ApiModelProperty(value = "下次跟进提醒内容")
    private String follNextContent;

    @ApiModelProperty(value = "催记方式 1-自动 0-手动 2-自动补催记")
    private Integer collectionWay;

    @ApiModelProperty(value = "协催ID")
    private Long assistId;

    @ApiModelProperty(value = "催收日期(导出)")
    private String collectDate;

    @ApiModelProperty(value = "催收时间(导出)")
    private String collectTime;

    @ApiModelProperty(value = "客户信息是否已变化")
    @TableField("is_custInfo_change")
    private String isCustinfoChange;

    @ApiModelProperty(value = "是否无法联系持卡人")
    private String isLoseAssociation;

    @ApiModelProperty(value = "谈判方式提出方")
    private String proposingPart;

    @ApiModelProperty(value = "谈判方式")
    private String negotiateWay;

    @ApiModelProperty(value = "查找方式")
    private String findType;

    @ApiModelProperty(value = "是否有效")
    private String isEffect;

    @ApiModelProperty(value = "查找时间")
    private Date findTime;

    @ApiModelProperty(value = "拨号的UUID")
    private String cusData;

    @ApiModelProperty(value = "呼叫标识，1:呼入 2:手动呼出 3:自动呼出 4:内线 5:环回测试 6:办公电话")
    private String cusCallType;

    @ApiModelProperty(value = "呼叫时间")
    private Date cusStartTime;

    @ApiModelProperty(value = "客户通话时长")
    private Long cusCallLastTime;

    @ApiModelProperty(value = "座席通话时长")
    private Long cusAgentDuration;

    @ApiModelProperty(value = "主叫座席号")
    private String cusCallerAgentNum;

    @ApiModelProperty(value = "被叫座席号")
    private String cusCalleeAgentNum;

    @ApiModelProperty(value = "录音文件地址")
    private String cusDataUrl;

    @ApiModelProperty(value = "常吉呼叫中心标识")
    private String seq;

    @ApiModelProperty(value = "常吉呼叫中心返回录音文件")
    private String cjDataFile;


    @Override
    public QueryWrapper<CaseFollowupRecord> builderQueryWrapper() {
        return null;
    }
}
