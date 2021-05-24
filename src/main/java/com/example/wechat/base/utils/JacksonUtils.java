package com.example.wechat.base.utils;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

/**
 * Jackson2工具类
 * 
 * @author zsl
 * @date 2020/3/12 16:59
 */
public class JacksonUtils {

	private static final ObjectMapper MAPPER = new ObjectMapper();


	/**
	 * 将json字符串转换为对象
	 * 
	 * @param jsonStr
	 * @return
	 */
	public static <T> T jsonObject(String jsonStr, Class<T> class1) {
		try {
			return (T) MAPPER.readValue(jsonStr, class1);
		} catch (Exception e) {
			// json转换失败
			e.printStackTrace();
			return null;
		}
	}

	public static String jsonObjectSerializer(Object obj ,boolean isIgnoreNull) {
		String jsonStr = null;
		try {
			if (isIgnoreNull) {
				MAPPER.setSerializationInclusion(JsonInclude.Include.NON_NULL);

			}
			jsonStr = MAPPER.writeValueAsString(obj);

		} catch (Exception e) {
			// json转换失败
			e.printStackTrace();
		}
		return jsonStr;
	}

	public static Map<String, Object> json2HashMap(String jsonStr) {
		HashMap<String, Object> dest = null;
		try {
			dest = (HashMap<String, Object>) MAPPER.readValue(jsonStr, HashMap.class);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dest;
	}
}
