package com.sevlow.sdk.tim.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.utils
 * @date 2019-05-27 15:08
 * @Description: TODO
 */
public class JsonUtils {

	private final static Gson GSON = new GsonBuilder().create();

	public static String toJson(Object obj){
		return GSON.toJson(obj);
	}

	public static <T> T fromJson(String json,Class<T> clazz){
		return GSON.fromJson(json, clazz);
	}

}
