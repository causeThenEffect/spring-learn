package com.szp.web.plus.handler;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;

public class BaseContextHandler {

	/* 多线程副本变量中的当前用户token Key */
	public static final String THREAD_LOCAL_KEY_USER_TOKEN = "currentUserToken";

	/* 多线程副本变量中当前用户id Key */
	public static final String THREAD_LOCAL_KEY_USER_ID = "currentUserId";

	public static final String THREAD_LOCAL_KEY_ROLE_CODE = "currentUserRoleCode";

	public static final String DEFAULT_USER_ID = "anonymous";


	private static ThreadLocal<Map<String, Object>> threadLocal = new ThreadLocal<>();


	private static void set(String key, Object value) {
		Map<String, Object> info = threadLocal.get();
		if (Objects.isNull(info)) {
			info = new HashMap<>();
			threadLocal.set(info);
		}
		info.put(key, value);
	}

	private static Object get(String key) {
		Map<String, Object> info = threadLocal.get();
		if (Objects.isNull(info)) {
			info = new HashMap<>();
			threadLocal.set(info);
		}
		return info.get(key);
	}

	/**
	 * 设置用户当前的token
	 *
	 * @param token user access token
	 */
	public static void setCurrentUserToken(String token) {
		set(THREAD_LOCAL_KEY_USER_TOKEN, token);
	}

	/**
	 * 获取当前用户的accessToken
	 *
	 * @return user access token
	 */
	public static String getCurrentUserToken() {
		return Optional.ofNullable(get(THREAD_LOCAL_KEY_USER_TOKEN)).orElse("")
				.toString();
	}

	/**
	 * 设置当前用户的id
	 *
	 * @param userId 用户id
	 */
	public static void setCurrentUserId(String userId) {
		set(THREAD_LOCAL_KEY_USER_ID, userId);
	}

	/**
	 * 获取当前用户的id
	 *
	 * @return userId
	 */
	public static String getCurrentUserId() {
		return String.valueOf(get(THREAD_LOCAL_KEY_USER_ID));
	}

	public static Long getUserId() {
		String userId = getCurrentUserId();
		if (StringUtils.isNotBlank(userId) && !DEFAULT_USER_ID.equals(userId)) {
			return Long.valueOf(userId);
		} else {
			return -1L;
		}
	}

	public static void setRoleCodes(List<String> roleCodes){
		set(THREAD_LOCAL_KEY_ROLE_CODE, Optional.ofNullable(roleCodes).orElse(Lists.newArrayList()));
	}

	@SuppressWarnings("unchecked")
	public static List<String> getRoleCodes(){
		Object o = get(THREAD_LOCAL_KEY_ROLE_CODE);
		if(o instanceof ArrayList){
			return (List<String>) o;
		}
		return Lists.newArrayList();
	}

	/**
	 * 移除当前线程的副本变量
	 */
	public static void remove() {
		threadLocal.remove();
	}
}
