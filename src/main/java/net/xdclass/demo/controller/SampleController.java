package net.xdclass.demo.controller;

import net.xdclass.demo.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author hdz
 */
@RestController
public class SampleController {

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/test")
    public Map<String, String> testMap() {
        Map<String, String> map = new HashMap<>(16);
        map.put("name", "XdClass");
        return map;
    }

    /**
     * 功能描述：jackson处理相关
     * 指定字段不返回：@JsonIgnore
     * 指定日期格式：@JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
     * 空字段不返回：@JsonInclude(Include.NON_NUll)
     * 指定别名：@JsonProperty
     * @return User  用户对象
     */
    @GetMapping("/test_json")
    public Object testJson(){
        return new User(111, "abc123", "10001000", new Date());
    }
}
