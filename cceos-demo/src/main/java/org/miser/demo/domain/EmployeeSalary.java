package org.miser.demo.domain;

import lombok.Data;

/**
 * 薪酬表 rdm_employee_salary
 *
 * @author Barry
 * @date 2018-09-08
 */
@Data
public class EmployeeSalary {

    private static final long serialVersionUID = 1L;

    /**
     * 员工薪酬ID
     */
    private Integer salaryId;
    /**
     * 员工ID
     */
    private Integer employeeId;
    /**
     * 月薪
     */
    private Integer monthly;
    /**
     * 薪数
     */
    private Integer point;
    /**
     * 年薪
     */
    private Integer yearly;
    /**
     * 福利
     */
    private String welfare;
    /**
     * 生效日期
     */
    private String effectiveDate;
    /**
     * 状态
     */
    private String status;

    /**
     * 员工
     */
    private Employee employee;

}
