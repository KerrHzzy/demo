package net.xdclass.demo.controller;

import net.xdclass.demo.domain.ServerSetting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;

/**
 * @author hdz
 */
@Controller
@RequestMapping("/freemaker")
public class FreeMakerController {

    @Autowired
    private ServerSetting serverSetting;

    @GetMapping("hello")
    public String index(ModelMap modelMap) {

        modelMap.addAttribute("setting", serverSetting);

        modelMap.addAttribute("user", "KerrHzzy");

        HashMap<String, String> latestProduct = new HashMap<>(16);
        latestProduct.put("url", "https://www.baidu.com");
        latestProduct.put("name", "Bai Du");
        modelMap.addAttribute("latestProduct", latestProduct);

        // 不用加后缀，在配置文件里面已经指定了后缀
        return "fm/index";
    }
}
