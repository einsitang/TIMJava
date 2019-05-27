package com.sevlow.sdk.tim.common.error;

import java.io.Serializable;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.common.error
 * @date 2019-05-27 11:45
 * @Description: TODO
 */
public class TIMException extends Exception implements Serializable {
	private static final long serialVersionUID = 3469414966034151505L;

	private TIMError error;

	public TIMException(TIMError error) {
		super(error.toString());
		this.error = error;
	}

	public TIMException(TIMError error, Throwable cause) {
		super(error.toString(), cause);
		this.error = error;
	}

	public TIMError getError() {
		return this.error;
	}


}
