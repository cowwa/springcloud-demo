package com.example.serverwebflux.entity;
import com.example.serverwebflux.common.BaseEntity;
import com.google.common.base.Strings;
import com.querydsl.core.BooleanBuilder;
import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.experimental.Accessors;

import javax.persistence.Entity;
import javax.persistence.Id;
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
@Accessors(chain = true)
@ApiModel(value="Personal对象", description="Personal对象")
@Entity
public class Personal extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    private String personalName;

    private String personalAccount;

    private String certificateType;

    private String certificateNo;

    private String sex;

    private Date birthday;

    private String departmentPost;

    private String selfPhoneNo;

    private String homePhoneNo;

    private String employerPhoneNo;

    private String employerPhoneNoSub;

    private String employerName;

    private String residenceAddr;

    private String homeAddr;

    private String emailAddr;

    private String billAddr;

    private String principalId;

    private String principalName;


    @Override
    public BooleanBuilder builderQuery() {
        QPersonal qPersonal=QPersonal.personal;
        BooleanBuilder builder = new BooleanBuilder();
        if(!Strings.isNullOrEmpty(principalName)){
            builder.and(qPersonal.principalName.like(principalName.concat("%")));
        }
        return builder;
    }
}
