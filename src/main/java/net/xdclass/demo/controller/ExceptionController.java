package net.xdclass.demo.controller;

import net.xdclass.demo.domain.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 功能描述：异常测试
 *
 * <p> 创建时间：Apr 22, 2018 11:22:29 PM </p>
 * @author hdz
 */
@RestController
public class ExceptionController {

    @RequestMapping(value = "/api/v1/test_ext")
    public Object index() {
        int i = 1/0;
        return new User(11, "sfsfds", "10000", new Date());
    }
}
