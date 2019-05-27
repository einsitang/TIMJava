package com.sevlow.sdk.tim.config;

import com.sun.istack.internal.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.config
 * @date 2019-05-27 10:21
 * @Description: TODO
 */
@Data
@AllArgsConstructor
public class TIMConfig {
	/**
	 * 腾讯IM appId
	 */
	@NotNull
	private Long appId;

	/**
	 * privateKey 文件地址(基于Project的<b>相对</b>目录地址)
	 * 如果在包内需要加上classpath:
	 */
	@NotNull
	private String privateKeyPath;

	@NotNull
	private String adminIdentifier;
}
