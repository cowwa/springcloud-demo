package com.example.servermybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.annotation.TableField;
import com.example.servermybatisplus.common.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.apache.ibatis.annotations.Options;
import org.springframework.data.annotation.Id;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

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
@TableName("CASE_FOLLOWUP_RECORD")
@ApiModel(value="CaseFollowupRecord对象", description="跟进记录")
public class CaseFollowupRecord extends BaseEntity {

    @TableField("ID")
    @TableId(type = IdType.UUID)
    private String id;

    @ApiModelProperty(value = "客户信息ID")
    @TableField("PERSONAL_ID")
    private String personalId;

    @ApiModelProperty(value = "证件号")
    @TableField("CERTIFICATE_NO")
    private String certificateNo;

    @ApiModelProperty(value = "操作批次号")
    @TableField("OPER_BATCH_NUMBER")
    private String operBatchNumber;

    @ApiModelProperty(value = "委案日期")
    @TableField("DELEGATION_DATE")
    private Date delegationDate;

    @ApiModelProperty(value = "委托方id标")
    @TableField("PRINCIPAL_ID")
    private String principalId;

    @ApiModelProperty(value = "联络对象/联系状态/联络人")
    @TableField("TARGET")
    private String target;

    @ApiModelProperty(value = "联络对象姓名")
    @TableField("TARGET_NAME")
    private String targetName;

    @ApiModelProperty(value = "催收日期")
    @TableField("FOLLOW_TIME")
    private Date followTime;

    @ApiModelProperty(value = "行动代码/联络结果/电催摘要/催收代码")
    @TableField("CONTACT_RESULT")
    private String contactResult;

    @ApiModelProperty(value = "行动代码CODE")
    @TableField("CONTACT_RESULT_CODE")
    private String contactResultCode;

    @ApiModelProperty(value = "外访摘要")
    @TableField("COLLECTION_OUT_RESULT")
    private String collectionOutResult;

    @ApiModelProperty(value = "催收状态")
    @TableField("COLLECTION_STATUS")
    private String collectionStatus;

    @ApiModelProperty(value = "催收方式/催收措施")
    @TableField("COLLECTION_TYPE")
    private String collectionType;

    @ApiModelProperty(value = "催收方式Code/催收措施")
    @TableField("COLLECTION_TYPE_CODE")
    private String collectionTypeCode;

    @ApiModelProperty(value = "电话类型/联络类型/联系类型")
    @TableField("PHONE_TYPE")
    private String phoneType;

    @ApiModelProperty(value = "电话号码/(号码/地址)/(电话/地址)")
    @TableField("CONTACT_PHONE")
    private String contactPhone;

    @ApiModelProperty(value = "号码状态")
    @TableField("CONTACT_STATE")
    private String contactState;

    @ApiModelProperty(value = "地址状态")
    @TableField("ADDR_STATUS")
    private String addrStatus;

    @ApiModelProperty(value = "地址类型")
    @TableField("ADDR_TYPE")
    private String addrType;

    @ApiModelProperty(value = "详细地址")
    @TableField("DETAIL")
    private String detail;

    @ApiModelProperty(value = "跟进内容")
    @TableField("CONTENT")
    private String content;

    @ApiModelProperty(value = "快捷录入")
    @TableField("QUICK_RECORD")
    private String quickRecord;

    @ApiModelProperty(value = "承诺还款标识 0-没有承诺 1-有承诺")
    @TableField("PROMISE_FLAG")
    private BigDecimal promiseFlag;

    @ApiModelProperty(value = "承诺还款金额")
    @TableField("PROMISE_AMT")
    private Float promiseAmt;

    @ApiModelProperty(value = "承诺还款日期")
    @TableField("PROMISE_DATE")
    private Date promiseDate;

    @ApiModelProperty(value = "已还款金额")
    @TableField("HAS_PAYMENT_AMT")
    private Float hasPaymentAmt;

    @ApiModelProperty(value = "已还款日期")
    @TableField("HAS_PAYMENT_DATE")
    private Date hasPaymentDate;

    @ApiModelProperty(value = "下次跟进日期")
    @TableField("FOLL_NEXT_DATE")
    private Date follNextDate;

    @ApiModelProperty(value = "跟进备注")
    @TableField("REMARK")
    private String remark;

    @ApiModelProperty(value = "标红")
    @TableField("INFORMATION_UPDATE")
    private String informationUpdate;

    @ApiModelProperty(value = "跟进方式")
    @TableField("TYPE")
    private String type;

    @ApiModelProperty(value = "跟进记录")
    @TableField("CONTENT_VIEW")
    private String contentView;

    @ApiModelProperty(value = "操作人")
    @TableField("OPERATOR")
    private String operator;

    @ApiModelProperty(value = "操作人工号")
    @TableField("OPERATOR_USER_NAME")
    private String operatorUserName;

    @ApiModelProperty(value = "操作人姓名")
    @TableField("OPERATOR_NAME")
    private String operatorName;

    @ApiModelProperty(value = "操作人部门")
    @TableField("OPERATOR_DEPT_NAME")
    private String operatorDeptName;

    @ApiModelProperty(value = "操作时间")
    @TableField("OPERATOR_TIME")
    private Date operatorTime;

    @ApiModelProperty(value = "是否还款")
    @TableField("IS_PAID")
    private String isPaid;

    @ApiModelProperty(value = "是否协商减免")
    @TableField("IS_REMIT")
    private String isRemit;

    @ApiModelProperty(value = "减免状态")
    @TableField("REMIT_STATE")
    private String remitState;

    @ApiModelProperty(value = "减免金额")
    @TableField("REMIT_AMT")
    private Float remitAmt;

    @ApiModelProperty(value = "下次跟进提醒内容")
    @TableField("FOLL_NEXT_CONTENT")
    private String follNextContent;

    @ApiModelProperty(value = "催记方式 1-自动 0-手动 2-自动补催记")
    @TableField("COLLECTION_WAY")
    private BigDecimal collectionWay;

    @ApiModelProperty(value = "协催ID")
    @TableField("ASSIST_ID")
    private String assistId;

    @ApiModelProperty(value = "催收日期(导出)")
    @TableField("COLLECT_DATE")
    private String collectDate;

    @ApiModelProperty(value = "催收时间(导出)")
    @TableField("COLLECT_TIME")
    private String collectTime;

    @ApiModelProperty(value = "客户信息是否已变化")
    @TableField("IS_CUSTINFO_CHANGE")
    private String isCustinfoChange;

    @ApiModelProperty(value = "是否无法联系持卡人")
    @TableField("IS_LOSE_ASSOCIATION")
    private String isLoseAssociation;

    @ApiModelProperty(value = "谈判方式提出方")
    @TableField("PROPOSING_PART")
    private String proposingPart;

    @ApiModelProperty(value = "谈判方式")
    @TableField("NEGOTIATE_WAY")
    private String negotiateWay;

    @ApiModelProperty(value = "查找方式")
    @TableField("FIND_TYPE")
    private String findType;

    @ApiModelProperty(value = "是否有效")
    @TableField("IS_EFFECT")
    private String isEffect;

    @ApiModelProperty(value = "查找时间")
    @TableField("FIND_TIME")
    private Date findTime;

    @ApiModelProperty(value = "拨号的UUID")
    @TableField("CUS_DATA")
    private String cusData;

    @ApiModelProperty(value = "呼叫标识，1:呼入 2:手动呼出 3:自动呼出 4:内线 5:环回测试 6:办公电话")
    @TableField("CUS_CALL_TYPE")
    private String cusCallType;

    @ApiModelProperty(value = "呼叫时间")
    @TableField("CUS_START_TIME")
    private Date cusStartTime;

    @ApiModelProperty(value = "客户通话时长")
    @TableField("CUS_CALL_LAST_TIME")
    private BigDecimal cusCallLastTime;

    @ApiModelProperty(value = "座席通话时长")
    @TableField("CUS_AGENT_DURATION")
    private BigDecimal cusAgentDuration;

    @ApiModelProperty(value = "主叫座席号")
    @TableField("CUS_CALLER_AGENT_NUM")
    private String cusCallerAgentNum;

    @ApiModelProperty(value = "被叫座席号")
    @TableField("CUS_CALLEE_AGENT_NUM")
    private String cusCalleeAgentNum;

    @ApiModelProperty(value = "录音文件地址")
    @TableField("CUS_DATA_URL")
    private String cusDataUrl;

    @ApiModelProperty(value = "常吉呼叫中心标识")
    @TableField("SEQ")
    private String seq;

    @ApiModelProperty(value = "常吉呼叫中心返回录音文件")
    @TableField("CJ_DATA_FILE")
    private String cjDataFile;


    @Override
    public QueryWrapper<CaseFollowupRecord> builderQueryWrapper() {
        return null;
    }
}
