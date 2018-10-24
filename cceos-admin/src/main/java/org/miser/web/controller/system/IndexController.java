package org.miser.web.controller.system;

import org.miser.common.config.Global;
import org.miser.common.utils.http.HttpUtils;
import org.miser.system.domain.SysMenu;
import org.miser.system.domain.SysUser;
import org.miser.system.service.ISysMenuService;
import org.miser.web.core.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 首页 业务处理
 *
 * @author Barry
 */
@Controller
public class IndexController extends BaseController {
    @Autowired
    private ISysMenuService menuService;

    // 系统首页
    @GetMapping("/index")
    public String index(ModelMap mmap) {
        // 取身份信息
        SysUser user = getUser();
        // 根据用户id取出菜单
        List<SysMenu> menus = menuService.selectMenusByUser(user);
        mmap.put("menus", menus);
        mmap.put("user", user);
        mmap.put("copyrightYear", Global.getCopyrightYear());
        return "index";
    }

    // 系统介绍
    @GetMapping("/system/main")
    public String main(HttpServletRequest request, ModelMap mmap) {
        mmap.put("version", Global.getVersion());
        mmap.put("hostURL", HttpUtils.getHostURL(request));
        return "main";
    }
}
