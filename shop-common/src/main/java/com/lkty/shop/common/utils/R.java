package com.lkty.shop.common.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.lkty.shop.common.code.LKTYCodeEnum;
import org.apache.http.HttpStatus;

import java.util.HashMap;
import java.util.Map;

/**
 * 返回数据
 *
 * @author Mark sunlightcs@gmail.com
 */
public class R extends HashMap<String, Object> {
	public static final String DATA_KEY = "data";
	private static final long serialVersionUID = 1L;

	public R() {
		put("code", 0);
		put("msg", "success");
	}

	public static R error() {
		return error(LKTYCodeEnum.PARAM_FAIL.getCode(), LKTYCodeEnum.PARAM_FAIL.getMessage());
	}

	public static R error(String msg) {
		return error(LKTYCodeEnum.PARAM_FAIL.getCode(), msg);
	}

	public static R error(int code, String msg) {
		R r = new R();
		r.put("code", code);
		r.put("msg", msg);
		return r;
	}

	public static R ok(String msg) {
		R r = new R();
		r.put("msg", msg);
		return r;
	}

	public static R ok(Map<String, Object> map) {
		R r = new R();
		r.putAll(map);
		return r;
	}

	public static R ok() {
		return new R();
	}

	public R put(String key, Object value) {
		super.put(key, value);
		return this;
	}
	public  Integer getCode() {

		return (Integer) this.get("code");
	}

	public <T> T getData(TypeReference<T> typeReference) {
		String cartJson = JSON.toJSONString(super.get(DATA_KEY));
		T t = JSON.parseObject(cartJson, typeReference);
		return t;
	}
}
