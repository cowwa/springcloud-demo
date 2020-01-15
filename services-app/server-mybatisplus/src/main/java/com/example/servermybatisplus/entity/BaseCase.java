
package com.example.servermybatisplus.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author:peishouwen
 * @Desc: 案件基本信息
 * @Date:Create in 15:36 2018/7/20
 */
@Data
@ApiModel(value = "BaseCase", description = "案件基本信息")
public class BaseCase {
    @ApiModelProperty(notes = "id")
    private String id;

    @ApiModelProperty(notes = "主键(省份证号+操作批次号)")
    private String primaryKey;

    @ApiModelProperty(notes = "批次号")
    private String batchNumber;

    @ApiModelProperty(notes = "外包序号")
    private String batchNo;

    @ApiModelProperty(notes = "接收方")
    private String receiveName;

    @ApiModelProperty(notes = "委案日期")
    private Date delegationDate;

    @ApiModelProperty(notes = "结案日期")
    private Date endCaseDate;

    @ApiModelProperty(notes = "委案城市")
    private String city;

    @ApiModelProperty(notes = "案件编号")
    private String caseNumber;

    @ApiModelProperty(notes = "客户ID")
    private String personalId;

    @ApiModelProperty(notes = "姓名")
    private String personalName;

    @ApiModelProperty(notes = "证件号")
    private String certificateNo;

    @ApiModelProperty(notes = "帐号")
    private String account;

    @ApiModelProperty(notes = "手别")
    private String handsNumber;

    @ApiModelProperty(notes = "进入催收日期")
    private Date remindersDate;

    @ApiModelProperty(notes = "币种")
    private String currency;

    @ApiModelProperty(notes = "逾期期数")
    private Integer overduePeriods;

    @ApiModelProperty(notes = "逾期天数")
    private Integer overdueDays;

    @ApiModelProperty(notes = "卡号")
    private String cardNo;

    @ApiModelProperty(notes = "卡类型")
    private String cardNoType;

    @ApiModelProperty(notes = "开户日期")
    private Date openAccountDate;

    @ApiModelProperty(notes = "停卡日期")
    private Date stopAccountDate;

    @ApiModelProperty(notes = "账单日")
    private String billDay;

    @ApiModelProperty(notes = "卡额度")
    private Double limitAmt = 0.0;

    @ApiModelProperty(notes = "推广机构")
    private String extensionInfo;

    @ApiModelProperty(notes = "推广员")
    private String extensionAgent;

    @ApiModelProperty(notes = "分行")
    private String branch;

    @ApiModelProperty(notes = "支行")
    private String subBranch;

    @ApiModelProperty(notes = "案件属性")
    private String unhealthyFlag;

    @ApiModelProperty(notes = "委案金额(人民币)")
    private Double overdueAmtTotal = 0.0;

    @ApiModelProperty(notes = "委案总金额(美元)")
    private Double overdueAmtTotalDollar = 0.0;

    @ApiModelProperty(notes = "欠款(人民币)")
    private Double leftAmt = 0.0;

    @ApiModelProperty(notes = "欠款(美元)")
    private Double leftAmtDollar = 0.0;

    @ApiModelProperty(notes = "最后还款金额(人民币)")
    private Double latestPayAmt = 0.0;

    @ApiModelProperty(notes = "最后还款金额(美元)")
    private Double latestPayAmtDollar = 0.0;

    @ApiModelProperty(notes = "还款总金额(人民币)")
    private Double payAmountTotal = 0.0;

    @ApiModelProperty(notes = "还款总金额(美元)")
    private Double payAmountTotalDollar = 0.0;

    @ApiModelProperty(notes = "更新日期(余额/对账)")
    private Date latelyUpdateDate;



    @ApiModelProperty(notes = "委托方id标")
    private String principalId;

    @ApiModelProperty(notes = "委托方")
    private String principalName;

    @ApiModelProperty(notes = "流入日期")
    private Date followInTime;

    @ApiModelProperty(notes = "系统自动设置状态")
    private Set<String> caseStatus = new HashSet<>();

    @ApiModelProperty(notes = "手动状态")
    private Set<String> collectionStatus = new HashSet<>();

    @ApiModelProperty(notes = "颜色")
    private String color;

    @ApiModelProperty(notes = "催计数")
    private Integer collectionRecordCount = 0;

    @ApiModelProperty(notes = "催计数总数")
    private Integer collectionTotalRecordCount = 0;

    @ApiModelProperty(notes = "外访数")
    private Integer addrRecordCount = 0;

    @ApiModelProperty(notes = "电催数")
    private Integer telRecordCount = 0;

    @ApiModelProperty(notes = "查找数")
    private Integer findRecordCount = 0;

    @ApiModelProperty(notes = "跟进日期")
    private Date followTime;



    @ApiModelProperty(notes = "联络结果")
    private String contactResult;



    @ApiModelProperty(notes = "停催时间")
    private Date stopTime;



    @ApiModelProperty(notes = "部门ID用于权限判断")
    private Set<String> departments;

    @ApiModelProperty(notes = "当前部门ID")
    private String detaptId;

    @ApiModelProperty(notes = "当前部门名称")
    private String detaptName;

    @ApiModelProperty(notes = "当前部门CODE")
    private String deptCode;

    @ApiModelProperty(notes = "公司名称")
    private String companyName;

    @ApiModelProperty(notes = "操作员")
    private String operator;

    @ApiModelProperty(notes = "记事本")
    private String comment;

    @ApiModelProperty(notes = "记事本修改时间")
    private Date commentUpdateTime;

    @ApiModelProperty(notes = "操作时间")
    private Date operatorTime;

    @ApiModelProperty("删案日期")
    private Date deleteCaseDateEnd;

    @ApiModelProperty("流转日期")
    private Date transferDate;



    @ApiModelProperty(notes = "操作批次号")
    private String operBatchNumber;

    @ApiModelProperty(notes = "退案天数")
    private Integer retireCaseDays;

    @ApiModelProperty(notes = "客户工作单位(浦发临时字段)")
    private String cardNoCompany;



    @ApiModelProperty(notes = "最近通话:电话XX 联系人|关系")
    private String latelyCallLog;
}
