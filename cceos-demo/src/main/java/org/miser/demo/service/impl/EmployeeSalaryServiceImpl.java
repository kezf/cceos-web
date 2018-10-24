package org.miser.demo.service.impl;

import org.miser.common.annotation.DataScope;
import org.miser.common.support.Convert;
import org.miser.demo.domain.EmployeeSalary;
import org.miser.demo.mapper.EmployeeSalaryMapper;
import org.miser.demo.service.IEmployeeSalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 薪酬 服务层实现
 *
 * @author Barry
 * @date 2018-09-08
 */
@Service
public class EmployeeSalaryServiceImpl implements IEmployeeSalaryService {
    @Autowired
    private EmployeeSalaryMapper employeeSalaryMapper;

    /**
     * 查询薪酬信息
     *
     * @param employeeId 薪酬ID
     * @return 薪酬信息
     */
    @Override
    public EmployeeSalary selectEmployeeSalaryById(Integer employeeId) {
        return employeeSalaryMapper.selectEmployeeSalaryById(employeeId);
    }

    /**
     * 查询薪酬列表
     *
     * @param employeeSalary 薪酬信息
     * @return 薪酬集合
     */
    @Override
    @DataScope(tableAlias = "u")
    public List<EmployeeSalary> selectEmployeeSalaryList(EmployeeSalary employeeSalary) {
        return employeeSalaryMapper.selectEmployeeSalaryList(employeeSalary);
    }

    /**
     * 查询薪酬列表
     *
     * @param employeeId 薪酬信息
     * @return 薪酬集合
     */
    @Override
    public List<EmployeeSalary> selectEmployeeSalaryListByemployeeId(Integer employeeId) {
        return employeeSalaryMapper.selectEmployeeSalaryListByemployeeId(employeeId);
    }

    /**
     * 新增薪酬
     *
     * @param employeeSalary 薪酬信息
     * @return 结果
     */
    @Override
    public int insertEmployeeSalary(EmployeeSalary employeeSalary) {
        if ("0".equals(employeeSalary.getStatus())) {
            employeeSalaryMapper.disabledEmployeeSalaryByemployeeId(employeeSalary.getEmployeeId());
        }
        return employeeSalaryMapper.insertEmployeeSalary(employeeSalary);
    }

    /**
     * 修改薪酬
     *
     * @param employeeSalary 薪酬信息
     * @return 结果
     */
    @Override
    public int updateEmployeeSalary(EmployeeSalary employeeSalary) {
        if ("0".equals(employeeSalary.getStatus())) {
            employeeSalaryMapper.disabledEmployeeSalaryByemployeeId(employeeSalary.getEmployeeId());
        }
        return employeeSalaryMapper.updateEmployeeSalary(employeeSalary);
    }

    /**
     * 删除薪酬对象
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    @Override
    public int deleteEmployeeSalaryByIds(String ids) {
        return employeeSalaryMapper.deleteEmployeeSalaryByIds(Convert.toStrArray(ids));
    }

}
