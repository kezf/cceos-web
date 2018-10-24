package org.miser.demo.service;

import org.miser.demo.domain.EmployeeSalary;

import java.util.List;

/**
 * 薪酬 服务层
 *
 * @author Barry
 * @date 2018-09-08
 */
public interface IEmployeeSalaryService {
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
     * 删除薪酬信息
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmployeeSalaryByIds(String ids);

}
