package com.sevlow.sdk.tim.bean;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author Element
 * @Package com.sevlow.sdk.tim.bean
 * @date 2019-05-27 18:04
 * @Description:
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class AddFriendsResult extends BatchUpdateResult implements Serializable {

	private static final long serialVersionUID = 8152624238915124107L;

}
