package com.sevlow.sdk.tim.utils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.util.List;

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

	public static <T> List<T> listFromJson(String json, Class<T> clazz){
		return GSON.fromJson(json, new TypeToken<T>(){}.getType());
	}

}
