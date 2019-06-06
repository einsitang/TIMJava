package com.sevlow.sdk.tim.config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.config
 * @date 2019-05-27 10:21
 * @Description:
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TIMConfig {

	/**
	 * 腾讯IM appId
	 */
	@NonNull
	private Long appId;

	/**
	 * privateKey 文件地址(基于Project的<b>相对</b>目录地址)
	 * 如果在包内需要加上classpath:
	 */
	@NonNull
	private String privateKeyPath;

	@NonNull
	private String adminIdentifier;

	private Long accountType;

	private int reqReTryCount = 3;
}
