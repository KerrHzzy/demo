package net.xdclass.demo.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 测试http协议的post,del,put请求请求
 * @author hdz
 */
@RestController
public class OtherHttpController {

	private final Map<String,Object> params = new HashMap<>();
	/**
	 * 功能描述：测试PostMapping
	 * @param  id      用户ID
	 * @param  pwd     密码
	 * @return params  返回结果对象
	 */
	@PostMapping("/v1/login")
	public Object login(String id, String pwd) {

		params.clear();
		params.put("id", id);
		params.put("pwd", pwd);
		return params;	
	}

	/**
	 * 功能描述：测试PutMapping
	 * @param  id      用户ID
	 * @return params  返回结果对象
	 */
	@PutMapping("/v1/put")
	public Object put(String id) {

		params.clear();
		params.put("id", id);
		return params;	
	}

	/**
	 * 功能描述：测试DeleteMapping
	 * @param  id      用户ID
	 * @return params  返回结果对象
	 */
	@DeleteMapping("/v1/del")
	public Object del(String id) {

		params.clear();
		params.put("id", id);
		return params;	
	}
}
