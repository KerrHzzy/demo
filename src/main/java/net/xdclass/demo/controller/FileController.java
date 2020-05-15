package net.xdclass.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述：文件测试
 *
 * <p> 创建时间：Apr 22, 2018 11:22:29 PM </p>
 * @author hdz
 */
@Controller
public class FileController {

    @RequestMapping(value = "/api/v1/go_page")
    public Object index() {
        return "index";
    }
}
