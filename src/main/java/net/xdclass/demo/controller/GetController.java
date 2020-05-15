package net.xdclass.demo.controller;

import net.xdclass.demo.domain.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试http协议的get请求
 * @author hdz
 */
@RestController
public class GetController {

    private final Map<String,Object> params = new HashMap<>();

    /**
     * 功能描述：测试restful协议，从路径中获取字段
     * @param  cityId 城市ID
     * @param  userId 用户ID
     * @return params 返回结果对象
     */
    /*@RequestMapping(path = "/{city_id}/{user_id}", method = RequestMethod.GET)
    public Object findUser(@PathVariable("city_id") String cityId,
                           @PathVariable("user_id") String userId) {

        params.clear();
        params.put("cityId", cityId);
        params.put("userId", userId);

        return params;
    }*/

    /**
     * 功能描述：测试GetMapping
     * @param  from   开始
     * @param  size   大小
     * @return params 返回结果对象
     */
    @GetMapping(value="/v1/page_user1")
    public Object pageUser(int from, int size) {

        params.clear();
        params.put("from", from);
        params.put("size", size);

        return params;
    }

    /**
     * 功能描述：默认值，是否必须的参数
     * @param  from   开始
     * @param  size   大小
     * @return params 返回结果对象
     */
    @GetMapping(value="/v1/page_user2")
    public Object pageUserV2(@RequestParam(defaultValue="0", name="page") int from, int size) {

        params.clear();
        params.put("from", from);
        params.put("size", size);

        return params;
    }

    /**
     * 功能描述：bean对象传参
     * 注意：1、注意需要指定http头为 content-type为application/json
     * 		2、使用body传输数据
     * @param  user   用户对象
     * @return params 返回结果对象
     */
    @RequestMapping("/v1/save_user")
    public Object saveUser(@RequestBody User user) {

        params.clear();
        params.put("user", user);
        return params;
    }

    /**
     * 功能描述：测试获取http头信息
     * @param  accessToken access令牌
     * @param  id          用户ID
     * @return params      返回结果对象
     */
    @GetMapping("/v1/get_header")
    public Object getHeader(@RequestHeader("access_token") String accessToken, String id) {
        params.clear();
        params.put("access_token", accessToken);
        params.put("id", id);
        return params;
    }

    /**
     * 功能描述：测试通过HttpServletRequest，获取所有参数
     * @param  request 请求
     * @return params  返回结果对象
     */
    @GetMapping("/v1/test_request")
    public Object testRequest(HttpServletRequest request) {
        params.clear();
        String id = request.getParameter("id");
        params.put("id", id);
        String content = request.getParameter("content");
        params.put("content", content);
        return params;
    }
}
