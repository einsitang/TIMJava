package com.sevlow.sdk.tim.common;

import com.sun.jersey.core.util.Base64;
import io.netty.handler.codec.DecoderException;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.common
 * @date 2019-05-27 11:33
 * @Description: TODO
 */
public class Base64Url {

	//int base64_encode_url(const unsigned char *in_str, int length, char *out_str,int *ret_length)
	public static byte[] base64EncodeUrl(byte[] in_str) {
		byte[] base64 = Base64.encode(in_str);
		base64 = base64ArrFix(base64);
		return base64;
	}

	//int base64_decode_url(const unsigned char *in_str, int length, char *out_str, int *ret_length)
	public static byte[] base64DecodeUrl(byte[] in_str) throws DecoderException {
		byte[] base64 = in_str.clone();
		base64 = base64ArrFix(base64);
		return Base64.decode(base64);
	}

	private static byte[] base64ArrFix(byte[] base64) {
		for (int i = 0; i < base64.length; ++i) {

			switch (base64[i]) {
				case '*':
					base64[i] = '+';
					break;
				case '-':
					base64[i] = '/';
					break;
				case '_':
					base64[i] = '=';
					break;
				default:
					break;
			}

		}

		return base64;
	}
}
