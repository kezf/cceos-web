package org.miser.demo.mapper;

import org.miser.demo.domain.EmployeeSalary;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 薪酬 数据层
 *
 * @author Barry
 * @date 2018-09-08
 */
@Repository
public interface EmployeeSalaryMapper {
    /**
     * 查询薪酬信息
     *
     * @param salaryId 薪酬ID
     * @return 薪酬信息
     */
    public EmployeeSalary selectEmployeeSalaryById(Integer salaryId);

    /**
     * 查询薪酬列表
     *
     * @param employeeSalary 薪酬信息
     * @return 薪酬集合
     */
    public List<EmployeeSalary> selectEmployeeSalaryList(EmployeeSalary employeeSalary);

    /**
     * 查询薪酬列表
     *
     * @param employeeId 薪酬信息
     * @return 薪酬集合
     */
    public List<EmployeeSalary> selectEmployeeSalaryListByemployeeId(Integer employeeId);

    /**
     * 新增薪酬
     *
     * @param employeeSalary 薪酬信息
     * @return 结果
     */
    public int insertEmployeeSalary(EmployeeSalary employeeSalary);

    /**
     * 修改薪酬
     *
     * @param employeeSalary 薪酬信息
     * @return 结果
     */
    public int updateEmployeeSalary(EmployeeSalary employeeSalary);


    /**
     * 根据员工ID置薪酬记录为不可用
     *
     * @param employeeId 员工ID
     * @return 结果
     */
    public int disabledEmployeeSalaryByemployeeId(Integer employeeId);

    /**
     * 删除薪酬
     *
     * @param salaryId 薪酬ID
     * @return 结果
     */
    public int deleteEmployeeSalaryById(Integer salaryId);

    /**
     * 批量删除薪酬
     *
     * @param salaryIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmployeeSalaryByIds(String[] salaryIds);

}