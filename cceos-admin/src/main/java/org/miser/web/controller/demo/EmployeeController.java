package org.miser.web.controller.demo;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.miser.common.annotation.Log;
import org.miser.common.base.AjaxResult;
import org.miser.common.enums.Action;
import org.miser.common.utils.ExcelUtil;
import org.miser.framework.web.page.TableDataInfo;
import org.miser.demo.domain.Employee;
import org.miser.demo.service.IEmployeeService;
import org.miser.web.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 员工 信息操作处理
 *
 * @author Barry
 * @date 2018-09-01
 */
@Controller
@RequestMapping("/demo/employee")
public class EmployeeController extends BaseController {
    private String prefix = "demo/employee";

    @Autowired
    private IEmployeeService employeeService;

    @RequiresPermissions("demo:employee:view")
    @GetMapping()
    public String employee() {
        return prefix + "/employee";
    }

    /**
     * 查询员工列表
     */
    @RequiresPermissions("demo:employee:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(Employee employee) {
        startPage();
        List<Employee> list = employeeService.selectEmployeeList(employee);
        return getDataTable(list);
    }

    @Log(title = "员工管理", action = Action.EXPORT)
    @RequiresPermissions("demo:employee:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(Employee employee) {
        List<Employee> list = employeeService.selectEmployeeList(employee);
        ExcelUtil<Employee> util = new ExcelUtil<Employee>(Employee.class);
        return util.exportExcel(list, "employee");
    }

    /**
     * 新增员工
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存员工
     */
    @RequiresPermissions("demo:employee:add")
    @Log(title = "员工管理", action = Action.INSERT)
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(Employee employee) {
        return toAjax(employeeService.insertEmployee(employee));
    }

    /**
     * 修改员工
     */
    @GetMapping("/edit/{employeeId}")
    public String edit(@PathVariable("employeeId") Integer employeeId, ModelMap mmap) {
        Employee employee = employeeService.selectEmployeeById(employeeId);
        mmap.put("employee", employee);
        return prefix + "/edit";
    }

    /**
     * 修改保存员工
     */
    @RequiresPermissions("demo:employee:edit")
    @Log(title = "员工管理", action = Action.UPDATE)
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(Employee employee) {
        return toAjax(employeeService.updateEmployee(employee));
    }

    /**
     * 删除员工
     */
    @RequiresPermissions("demo:employee:remove")
    @Log(title = "员工管理", action = Action.DELETE)
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        return toAjax(employeeService.deleteEmployeeByIds(ids));
    }

}
