package com.sevlow.sdk.tim.bean;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 17:37
 * @Description: TIM Account 在线状态
 */
@Data
public class OnlineStatusResult implements Serializable {

	private static final long serialVersionUID = 1687104704170171011L;

	@SerializedName("QueryResult")
	private List<AccountState> queryResult;


	@Data
	public static class AccountState implements Serializable{

		private static final long serialVersionUID = 8540690600680582034L;

		@SerializedName("To_Account")
		private String account;

		@SerializedName("State")
		private State state;
	}

	public static enum State {
		Online(), PushOnline(), Offline()
	}

}
