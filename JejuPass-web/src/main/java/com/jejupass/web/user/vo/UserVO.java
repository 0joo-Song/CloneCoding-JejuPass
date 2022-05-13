package com.jejupass.web.user.vo;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@SuppressWarnings("serial")
@ToString
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UserVO {
	Integer userSeq;
	String userId;
	String userPw;
	String userName;
	String regDt;
	Integer loginFailCnt;
	String lastLoginDate;
	String userStatus;
	String telNo;
	String tempPwYn;
	
	@Builder
	private UserVO(String userId, String userPw, String userName) {
		this.userId = userId;
		this.userName = userName;
	}
}
