package net.xdclass.demo.controller;

import net.xdclass.demo.domain.ServerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author hdz
 */
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @Autowired
    private ServerSetting serverSetting;

    @GetMapping("hello")
    public String index() {
        //不用加后缀，在配置文件里面已经指定了后缀
        return "index";
    }

    @GetMapping("info")
    public String admin(ModelMap modelMap){

        modelMap.addAttribute("setting", serverSetting);

        //不用加后缀，在配置文件里面已经指定了后缀
        return "admin/info";
    }
}
