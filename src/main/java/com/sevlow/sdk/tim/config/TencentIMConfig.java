package com.sevlow.sdk.tim.config;

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
public class TencentIMConfig {
	/**
	 * 腾讯IM appId
	 */
	private Long appId;

	/**
	 * privateKey 文件地址(基于Project的<b>相对</b>目录地址)
	 */
	private String privateKeyPath;
}
