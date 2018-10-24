package org.miser.web.controller.monitor;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.miser.common.annotation.Log;
import org.miser.common.base.AjaxResult;
import org.miser.common.enums.Action;
import org.miser.common.utils.ExcelUtil;
import org.miser.framework.util.ShiroUtils;
import org.miser.framework.web.page.TableDataInfo;
import org.miser.quartz.domain.SysJob;
import org.miser.quartz.service.ISysJobService;
import org.miser.web.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 调度任务信息操作处理
 *
 * @author Barry
 */
@Controller
@RequestMapping("/monitor/job")
public class JobController extends BaseController {
    private String prefix = "monitor/job";

    @Autowired
    private ISysJobService jobService;

    @RequiresPermissions("monitor:job:view")
    @GetMapping()
    public String job() {
        return prefix + "/job";
    }

    @RequiresPermissions("monitor:job:list")
    @PostMapping("/list")
    @ResponseBody
    public TableDataInfo list(SysJob job) {
        startPage();
        List<SysJob> list = jobService.selectJobList(job);
        return getDataTable(list);
    }

    @Log(title = "定时任务", action = Action.EXPORT)
    @RequiresPermissions("monitor:job:export")
    @PostMapping("/export")
    @ResponseBody
    public AjaxResult export(SysJob job) {
        List<SysJob> list = jobService.selectJobList(job);
        ExcelUtil<SysJob> util = new ExcelUtil<SysJob>(SysJob.class);
        return util.exportExcel(list, "job");
    }

    @Log(title = "定时任务", action = Action.DELETE)
    @RequiresPermissions("monitor:job:remove")
    @PostMapping("/remove")
    @ResponseBody
    public AjaxResult remove(String ids) {
        try {
            jobService.deleteJobByIds(ids);
            return success();
        } catch (Exception e) {
            e.printStackTrace();
            return error(e.getMessage());
        }
    }

    /**
     * 任务调度状态修改
     */
    @Log(title = "定时任务", action = Action.UPDATE)
    @RequiresPermissions("monitor:job:changeStatus")
    @PostMapping("/changeStatus")
    @ResponseBody
    public AjaxResult changeStatus(SysJob job) {
        job.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(jobService.changeStatus(job));
    }

    /**
     * 任务调度立即执行一次
     */
    @Log(title = "定时任务", action = Action.UPDATE)
    @RequiresPermissions("monitor:job:changeStatus")
    @PostMapping("/run")
    @ResponseBody
    public AjaxResult run(SysJob job) {
        return toAjax(jobService.run(job));
    }

    /**
     * 新增调度
     */
    @GetMapping("/add")
    public String add() {
        return prefix + "/add";
    }

    /**
     * 新增保存调度
     */
    @Log(title = "定时任务", action = Action.INSERT)
    @RequiresPermissions("monitor:job:add")
    @PostMapping("/add")
    @ResponseBody
    public AjaxResult addSave(SysJob job) {
        job.setCreateBy(ShiroUtils.getLoginName());
        return toAjax(jobService.insertJobCron(job));
    }

    /**
     * 修改调度
     */
    @GetMapping("/edit/{jobId}")
    public String edit(@PathVariable("jobId") Long jobId, ModelMap mmap) {
        mmap.put("job", jobService.selectJobById(jobId));
        return prefix + "/edit";
    }

    /**
     * 修改保存调度
     */
    @Log(title = "定时任务", action = Action.UPDATE)
    @RequiresPermissions("monitor:job:edit")
    @PostMapping("/edit")
    @ResponseBody
    public AjaxResult editSave(SysJob job) {
        job.setUpdateBy(ShiroUtils.getLoginName());
        return toAjax(jobService.updateJobCron(job));
    }
}
