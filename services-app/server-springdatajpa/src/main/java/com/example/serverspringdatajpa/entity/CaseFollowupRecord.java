package com.example.serverspringdatajpa.entity;

import com.example.serverspringdatajpa.common.BaseEntity;
import com.querydsl.core.BooleanBuilder;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

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

    @Id
    @ApiModelProperty(notes = "跟进id")
    private String id;

    @ApiModelProperty(notes = "客户信息ID")
    private String personalId;

    @ApiModelProperty(notes = "证件号")
    private String certificateNo;

    @ApiModelProperty(notes = "操作批次号")
    private String operBatchNumber;

    @ApiModelProperty(notes = "委案日期")
    private Date delegationDate;

    @ApiModelProperty(notes = "委托方id标")
    private String principalId;

    @ApiModelProperty(notes = "案件信息ID")
    private String caseId;

    @ApiModelProperty(notes = "联络对象/联系状态/联络人")
    private String target;

    @ApiModelProperty(notes = "联络对象姓名")
    private String targetName;

    @ApiModelProperty(notes = "催收日期")
    private Date followTime;

    @ApiModelProperty(notes = "行动代码/联络结果/电催摘要/催收代码")
    private String contactResult;

    @ApiModelProperty(notes = "行动代码CODE")
    private String contactResultCode;

    @ApiModelProperty(notes = "外访摘要")
    private String collectionOutResult;

    @ApiModelProperty(notes = "催收状态")
    private String collectionStatus;

    @ApiModelProperty(notes = "催收方式/催收措施")
    private String collectionType;

    @ApiModelProperty(notes = "催收方式Code/催收措施")
    private String collectionTypeCode;

    @ApiModelProperty(notes = "电话类型/联络类型/联系类型")
    private String phoneType;

    @ApiModelProperty(notes = "电话号码/(号码/地址)/(电话/地址)")
    private String contactPhone;

    @ApiModelProperty(notes = "号码状态")
    private String contactState;

    @ApiModelProperty(notes = "地址状态")
    private String addrStatus;

    @ApiModelProperty(notes = "地址类型")
    private String addrType;

    @ApiModelProperty(notes = "详细地址")
    private String detail;

    @ApiModelProperty(notes = "跟进内容")
    private String content;

    @ApiModelProperty(notes = "快捷录入")
    private String quickRecord;

    @ApiModelProperty(notes = "承诺还款标识 0-没有承诺 1-有承诺")
    private Integer promiseFlag;

    @ApiModelProperty(notes = "承诺还款金额")
    private Double promiseAmt;

    @ApiModelProperty(notes = "承诺还款日期")
    private Date promiseDate;

    @ApiModelProperty(notes = "已还款金额")
    private Double hasPaymentAmt;

    @ApiModelProperty(notes = "已还款日期")
    private Date hasPaymentDate;

    @ApiModelProperty(notes = "下次跟进日期")
    private Date follNextDate;

    @ApiModelProperty(notes = "跟进备注")
    private String remark;

    @ApiModelProperty(notes = "信息更新")
    private String informationUpdate;

    @ApiModelProperty(notes = "跟进方式")
    private String type;

    @ApiModelProperty(notes = "跟进记录")
    private String contentView;

    @ApiModelProperty(notes = "操作人")
    private String operator;

    @ApiModelProperty(notes = "操作人工号")
    private String operatorUserName;

    @ApiModelProperty(notes = "操作人姓名")
    private String operatorName;

    @ApiModelProperty(notes = "操作人部门")
    private String operatorDeptName;

    @ApiModelProperty(notes = "操作时间")
    private Date operatorTime;

    @ApiModelProperty(notes = "是否还款")
    private String isPaid;

    @ApiModelProperty(notes = "是否协商减免")
    private String isRemit;

    @ApiModelProperty(notes = "减免状态")
    private String remitState;

    @ApiModelProperty(notes = "减免金额")
    private Double remitAmt;

    @ApiModelProperty(notes = "下次跟进提醒内容")
    private String follNextContent;

    @ApiModelProperty(notes = "催记方式 1-自动 0-手动 2-自动补催记")
    private Integer collectionWay;

    @ApiModelProperty("协催ID")
    private String assistId;

    @ApiModelProperty("催收日期(导出)")
    private String collectDate;

    @ApiModelProperty("催收时间(导出)")
    private String collectTime;

    @ApiModelProperty("客户信息是否已变化")
    private String isCustInfoChange;

    @ApiModelProperty("是否无法联系持卡人")
    private String isLoseAssociation;

    @ApiModelProperty("谈判方式提出方")
    private String proposingPart;

    @ApiModelProperty("谈判方式")
    private String negotiateWay;

    @ApiModelProperty(notes = "查找方式")
    private String findType;

    @ApiModelProperty(notes = "是否有效")
    private String isEffect;

    @ApiModelProperty(notes = "查找时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date findTime;

    /**以下云翳呼叫中心字段**/
    @ApiModelProperty(notes = "拨号的UUID")
    private String cusData;

    @ApiModelProperty("呼叫标识，1:呼入 2:手动呼出 3:自动呼出 4:内线 5:环回测试 6:办公电话")
    private String cusCallType;

    @ApiModelProperty(notes = "呼叫时间")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date cusStartTime;

    @ApiModelProperty("客户通话时长")
    private Integer cusCallLastTime;

    @ApiModelProperty("座席通话时长")
    private Integer cusAgentDuration;

    @ApiModelProperty("主叫座席号")
    private String cusCallerAgentNum;

    @ApiModelProperty("被叫座席号")
    private String cusCalleeAgentNum;

    @ApiModelProperty(notes = "录音文件地址")
    private String cusDataUrl;

    @ApiModelProperty(notes = "常吉呼叫中心标识")
    private String seq;

    @ApiModelProperty(notes = "常吉呼叫中心返回录音文件")
    private String cjDataFile;


    @Override
    public BooleanBuilder builderQuery() {
        return null;
    }
}
