package org.miser.demo.mapper;

import org.miser.demo.domain.Employee;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 员工 数据层
 *
 * @author Barry
 * @date 2018-09-01
 */
@Repository
public interface EmployeeMapper {
    /**
     * 查询员工信息
     *
     * @param employeeId 员工ID
     * @return 员工信息
     */
    public Employee selectEmployeeById(Integer employeeId);

    /**
     * 查询员工列表
     *
     * @param employee 员工信息
     * @return 员工集合
     */
    public List<Employee> selectEmployeeList(Employee employee);

    /**
     * 新增员工
     *
     * @param employee 员工信息
     * @return 结果
     */
    public int insertEmployee(Employee employee);

    /**
     * 修改员工
     *
     * @param employee 员工信息
     * @return 结果
     */
    public int updateEmployee(Employee employee);

    /**
     * 删除员工
     *
     * @param employeeId 员工ID
     * @return 结果
     */
    public int deleteEmployeeById(Integer employeeId);

    /**
     * 批量删除员工
     *
     * @param employeeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteEmployeeByIds(String[] employeeIds);

}