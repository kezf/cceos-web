package org.miser.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.miser.common.annotation.Excel;
import org.miser.common.base.BaseEntity;
import org.miser.system.domain.SysDept;

import java.util.Date;

/**
 * 员工表 rdm_employee
 *
 * @author Barry
 * @date 2018-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Employee extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 员工id
     */
    private Integer employeeId;
    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 工号
     */
    @Excel(name = "员工编号")
    private String empno;
    /**
     * 姓名
     */
    @Excel(name = "姓名")
    private String name;
    /**
     * 性别
     */
    @Excel(name = "性别")
    private String sex;
    /**
     * 邮箱
     */
    @Excel(name = "邮箱")
    private String email;
    /**
     * 手机号码
     */
    @Excel(name = "手机")
    private String phone;
    /**
     * 出生日期
     */
    @Excel(name = "出生日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthdate;
    /**
     * 籍贯
     */
    @Excel(name = "出生地")
    private String birthplace;
    /**
     * 毕业日期
     */
    @Excel(name = "毕业日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date graduateDate;
    /**
     * 毕业院校
     */
    @Excel(name = "毕业院校")
    private String school;
    /**
     * 专业
     */
    @Excel(name = "专业")
    private String major;
    /**
     * 学历
     */
    @Excel(name = "学历")
    private String education;
    /**
     * 入职日期
     */
    @Excel(name = "入职日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date hiredate;
    /**
     * 转正日期
     */
    @Excel(name = "转正日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date formaldate;
    /**
     * 水平等级
     */
    @Excel(name = "水平等级")
    private String grade;
    /**
     * 办公地点
     */
    @Excel(name = "办公地点")
    private String location;
    /**
     * 离职日期
     */
    @Excel(name = "离职日期")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date leftdate;
    /**
     * 员工状态
     */
    @Excel(name = "员工状态")
    private String status;

    /**
     * 部门对象
     */
    private SysDept dept;

}
