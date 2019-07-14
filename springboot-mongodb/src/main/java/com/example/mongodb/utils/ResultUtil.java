/**
 * 
 */
package com.example.mongodb.utils;

/**
 * @author Thunisoft
 *
 */

public class ResultUtil {
	/**
	 * 请求成功返回
	 * 
	 * @param object
	 * @return
	 */
	public static Result success(Object object) {
		Result result = new Result();
		result.setCode(200);
		result.setMsg("请求成功");
		result.setData(object);
		return result;
	}

	public static Result success() {
		return success(null);
	}

	public static Result error(Integer code, String resultmsg) {
		Result result = new Result();
		result.setCode(code);
		result.setMsg(resultmsg);
		return result;
	}

}