package org.miser.web.controller.demo;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.miser.common.annotation.Log;
import org.miser.common.base.AjaxResult;
import org.miser.common.enums.Action;
import org.miser.framework.web.page.TableDataInfo;
import org.miser.demo.service.IEmployeeService;
import org.miser.demo.domain.EmployeeSalary;
import org.miser.demo.service.IEmployeeSalaryService;
import org.miser.web.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 薪酬 信息操作处理
 *
 * @author Barry
 * @date 2018-09-08
 */
@Controller
@RequestMapping("/demo/employee/salary")
public class EmployeeSalaryController extends BaseController {
    private String prefix = "demo/employee/salary";

    @Autowired
    private IEmployeeSalaryService employeeSalaryService;

    @Autowired
    private IEmployeeService employeeService;

    @RequiresPermissions("demo:employee:view")
    @GetMapping()
    public String employeeSalary() {
        return prefix + "/salary";
    }

    /**
     * 查询薪酬列表
     */
    @RequiresPermissions("demo:employee:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(EmployeeSalary employeeSalary) {
        startPage();
        List<EmployeeSalary> list = employeeSalaryService.selectEmployeeSalaryList(employeeSalary);
        return getDataTable(list);
    }

    /**
     * 查询薪酬列表
     */
    @RequiresPermissions("demo:employee:list")
    @PostMapping("/details")
    @ResponseBody
    public TableDataInfo detail(EmployeeSalary employeeSalary) {
        startPage();
        List<EmployeeSalary> list = employeeSalaryService.selectEmployeeSalaryListByemployeeId(employeeSalary.getEmployeeId());
        return getDataTable(list);
    }

    /**
     * 查询薪酬详情
     */
    @RequiresPermissions("demo:employee:list")
    @GetMapping("/detail/{employeeId}")
    public String detail(@PathVariable("employeeId") Integer employeeId, ModelMap mmap) {
        mmap.put("employeeId", employeeId);
        return prefix + "/detail";
    }

    /**
     * 新增薪酬
     */
    @RequiresPermissions("demo:employee:add")
    @GetMapping("/add/{employeeId}")
    public String add(@PathVariable("employeeId") Integer employeeId, ModelMap mmap) {
        mmap.put("employee", employeeService.selectEmployeeById(employeeId));
        return prefix + "/add";
    }

    /**
     * 新增保存薪酬
     */
    @RequiresPermissions("demo:employee:add")
    @Log(title = "员工薪酬", action = Action.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(EmployeeSalary employeeSalary) {
        return toAjax(employeeSalaryService.insertEmployeeSalary(employeeSalary));
    }

    /**
     * 修改薪酬
     */
    @GetMapping("/edit/{salaryId}")
    public String edit(@PathVariable("salaryId") Integer salaryId, ModelMap mmap) {
        EmployeeSalary employeeSalary = employeeSalaryService.selectEmployeeSalaryById(salaryId);
        mmap.put("salary", employeeSalary);
        return prefix + "/edit";
    }

    /**
     * 修改保存薪酬
     */
    @RequiresPermissions("demo:employee:edit")
    @Log(title = "员工薪酬", action = Action.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(EmployeeSalary employeeSalary) {
        return toAjax(employeeSalaryService.updateEmployeeSalary(employeeSalary));
    }

    /**
     * 删除薪酬
     */
    @RequiresPermissions("demo:employee:remove")
    @Log(title = "员工薪酬", action = Action.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(employeeSalaryService.deleteEmployeeSalaryByIds(ids));
    }

}
